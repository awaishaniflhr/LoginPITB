package com.example.loginpitb;


import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Interface {
    String BASE_URL = "https://dev-net.punjab.gov.pk/paits/api/MobileApis/";
    Call<JSONObject> LoginApiResponse();

    @POST("Login")
    Call<LoginApiResponse> getlogin(@Body ApiRequest apiRequest) ;



}

