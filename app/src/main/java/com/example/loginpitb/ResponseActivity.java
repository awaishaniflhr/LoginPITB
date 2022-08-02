package com.example.loginpitb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Response;


public class ResponseActivity extends Activity {

    String JSON_STRING = "{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}";
    TextView username;
    TextView password;
    String Username;
    String Password;
    String data;
    private Button Next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        // get the reference of TextView's
        setContentView(R.layout.activity_response);
        // get the reference of TextView's
        username = (TextView) findViewById(R.id.tv_response_username);
        password = (TextView) findViewById(R.id.tv_response_password);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            // fetch JSONObject named employee
            JSONObject data = obj.getJSONObject("data");
            // get employee name and salary


            username.setText("Name: "+Username);
            password.setText("Salary: "+Password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Next = (Button) findViewById(R.id.btn_next);

        Next.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "working", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), Premises.class);
            startActivity(intent);
        });
    }
}