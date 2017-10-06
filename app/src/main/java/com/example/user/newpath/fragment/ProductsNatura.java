package com.example.user.newpath.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.adapter.ChallengeAdapter;
import com.example.user.newpath.model.Products;
import com.example.user.newpath.request.RequestProducts;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProductsNatura extends Fragment {
    private ListView listView;
    private TextView label;
    private TextView socore;
    private ArrayList<Products> productsArrayList;
    private View view;
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

            }
        });
    }
    protected void initViews(View view) {
        label = (TextView)view.findViewById(R.id.produtcs_description) ;
        socore = (TextView)view.findViewById(R.id.produtcs_score);
        makeRequest();


    }
    private void createList(){
        if(productsArrayList == null)
            return;

//        listView.setOnItemClickListener(listItemclick);
//        listView.setAdapter(new ChallengeAdapter(productsArrayList, getActivity()));
    }

    private AdapterView.OnItemClickListener listItemclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
            Products products = productsArrayList.get(index);
            label.setText(products.getName());
            socore.setText(products.getScore());
        }
    };

}
