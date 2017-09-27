package com.example.user.newpath.request;


import com.example.user.newpath.model.ItensChallenge;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jussi on 9/21/17.
 */

public interface RequestChallenge {


    @GET("challenges.json")
    Call<ArrayList<ItensChallenge>> getChallenges();
}
