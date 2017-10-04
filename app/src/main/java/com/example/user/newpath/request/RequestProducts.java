package com.example.user.newpath.request;

import com.example.user.newpath.model.Products;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jussi on 10/4/17.
 */

public interface RequestProducts {
    @GET("/productList")
    Call<ArrayList<Products>> getProducts();

}
