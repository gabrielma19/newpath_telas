package com.example.user.newpath.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.adapter.ProductsNaturaItens;
import com.example.user.newpath.model.Products;
import com.example.user.newpath.request.RequestProducts;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProductsNatura extends Fragment {
    private View view;
    private ImageView img;
    private TextView label;
    private TextView score;
    private ListView listView;
    private ArrayList<Products> productsArrayList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments_products_natura, container, false);



        initViews(view);

        return view;
    }

    private void makeRequest(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://natura-challenge.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestProducts service = retrofit.create(RequestProducts.class);

        service.getProducts().enqueue(new Callback<ArrayList<Products>>() {
            @Override
            public void onResponse(Call<ArrayList<Products>> call, Response<ArrayList<Products>> response) {
                productsArrayList = response.body();
                createList();
            }

            @Override
            public void onFailure(Call<ArrayList<Products>> call, Throwable t) {
                Toast.makeText(getContext(), "FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void initViews(View view) {

        listView    = (ListView)view.findViewById(R.id.list_products);
        score       = (TextView)view.findViewById(R.id.produtcs_score);
        img         = (ImageView)view.findViewById(R.id.produtcs_image);
        label       = (TextView)view.findViewById(R.id.produtcs_description);

        makeRequest();
    }
    private void createList(){
        if(productsArrayList == null)
            return;
        listView.setAdapter(new ProductsNaturaItens(productsArrayList, getActivity()));
    }

}
