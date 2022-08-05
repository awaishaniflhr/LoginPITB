package com.example.loginpitb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.Headers;
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



        Login.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "working", Toast.LENGTH_SHORT).show();
            new ApiRequest("Username","Password");
            String username = Username.getText().toString();
            String password = Password.getText().toString();

            ApiRequest apiRequest = new ApiRequest(username, password);
            login(apiRequest);

            Intent intent = new Intent(getApplicationContext(), ResponseActivity.class);
            startActivity(intent);

        });


    }
    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("Username", "");
        int a = sh.getInt("Password", 1);

        // Setting the fetched data
        // in the EditTexts
        Username.setText(s1);
        Password.setText(String.valueOf(a));
    }
    @Override
    protected void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("username", Username.getText().toString());
        myEdit.putString("password", Password.getText().toString());
        myEdit.apply();
    }


    private String loadJSONFromAsset() {
        return null;
    }

    private void login(ApiRequest apiRequest) {
        Call<LoginApiResponse> call = RetrofitClient.getInstance().getMyApi().getlogin(apiRequest);
        call.enqueue(new Callback<LoginApiResponse>() {
            @Override
            public void onResponse(Call<LoginApiResponse> call, Response<LoginApiResponse> response) {
                LoginApiResponse details  = response.body();
                Headers data  = response.headers();
                Toast.makeText(MainActivity.this, ""+ response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}