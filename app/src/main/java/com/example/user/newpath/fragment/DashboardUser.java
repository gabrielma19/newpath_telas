package com.example.user.newpath.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.user.newpath.R;
import com.example.user.newpath.adapter.ChallengeAdapter;
import com.example.user.newpath.model.Desafio;
import com.example.user.newpath.request.RequestChallenge;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Challenge;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardUser extends Fragment {


    private ListView listView;

    protected View view;
    private LinearLayout box_finalizar_desafio;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestChallenge.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        RequestChallenge service = retrofit.create(RequestChallenge.class);

        service.getChallenges().enqueue(new Callback<RequestChallenge>() {
            @Override
            public void onResponse(Call<RequestChallenge> call, Response<RequestChallenge> response) {
                RequestChallenge json = response.body();
                chall = new ArrayList<>(Arrays.asList(json.ge))
                String result = desafios.size()==0 ? "Desafio nao encontrada" : desafios.get(desafios.size()-1).getChallenges().;
                mResult.setText(response.body().getChannel().getField1() + " - " + result);
            }

            @Override
            public void onFailure(Call<ArduinoResponse> call, Throwable t) {

            }
        });

        view = inflater.inflate(R.layout.fragment_dashboard_user, container, false);
        initViews(view);
        return view;
    }

    protected void initViews(View view){

        listView = (ListView)view.findViewById(R.id.list_challenge);

        ArrayList teste = new ArrayList<Desafio>();

        teste.add(new Desafio());
        teste.add(new Desafio());
        teste.add(new Desafio());
        teste.add(new Desafio());
        teste.add(new Desafio());




        listView.setAdapter(new ChallengeAdapter(teste, getActivity()));


    }
    private View.OnClickListener click_finalizar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
