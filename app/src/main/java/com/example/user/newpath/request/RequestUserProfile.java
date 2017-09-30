package com.example.user.newpath.request;

import com.example.user.newpath.model.Itens;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Gabriel Marcos on 9/21/17.
 */

public interface RequestUserProfile {
    @GET("challenges/{id}.json")
    Call<ArrayList<Itens>> getItens(@Path("id") String id);
}
