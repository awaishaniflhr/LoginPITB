package com.example.loginpitb;

import android.content.Context;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Interface {
    String BASE_URL = "https://dev-net.punjab.gov.pk/paits/api/MobileApis/";

    @POST("Login")
    Call<LoginApiResponse> getlogin(@Body ApiRequest apiRequest);


}

