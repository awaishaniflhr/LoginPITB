package com.example.loginpitb;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface InterfacePremises {

    String BASE_URL = "https://dev-net.punjab.gov.pk/paits/api/exPremesis/";
    Call<JSONObject> LoginApiResponse();

    @POST("Premesis")
    Call<LoginApiResponse> getlogin(@Body ApiRequest apiRequest);
    @POST("token")
    @Headers("Content-Type")
    Call <Data>createLoginRequest(@Body Data loginRequest);
}

