package com.example.loginpitb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = (EditText) findViewById(R.id.et_login_username);
        Password = (EditText) findViewById(R.id.et_login_password);
        Login = (Button) findViewById(R.id.btn_login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                ApiRequest apiRequest = new ApiRequest(username, password);
                login(apiRequest);
            }

        });


    }


    private void login(ApiRequest apiRequest) {
        Call<LoginApiResponse> call = RetrofitClient.getInstance().getMyApi().getlogin(apiRequest);
        call.enqueue(new Callback<LoginApiResponse>() {
            @Override
            public void onResponse(Call<LoginApiResponse> call, Response<LoginApiResponse> response) {
                LoginApiResponse myheroList = response.body();
                Toast.makeText(MainActivity.this, ""+ myheroList.getToken(), Toast.LENGTH_SHORT).show();
                if (response.isSuccessful());

            }

            @Override
            public void onFailure(Call<LoginApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}