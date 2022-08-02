package com.example.loginpitb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;



public class Main2Activity extends AppCompatActivity {

    String JSON_STRING = "{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}";
    TextView username;
    TextView password;
    String Username;
    String Password;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // get the reference of TextView's
        setContentView(R.layout.activity_login);
        // get the reference of TextView's
        username = (TextView) findViewById(R.id.tv_login_username);
        password = (TextView) findViewById(R.id.tv_login_password);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            // fetch JSONObject named employee
            JSONObject data = obj.getJSONObject("data");
            // get employee name and salary

            // set employee name and salary in TextView's
            username.setText("Name: "+Username);
            password.setText("Salary: "+Password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}