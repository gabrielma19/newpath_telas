package com.example.user.newpath.request;


import com.example.user.newpath.model.Desafio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by jussi on 9/21/17.
 */

public interface RequestChallenge {

    public static final String BASE_URL = "https://natura-challenge.firebaseio.com/";

    @GET("challenges/")
    Call<Desafio> desafios();

}
