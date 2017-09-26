package com.example.user.newpath.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.adapter.ChallengeAdapter;
import com.example.user.newpath.model.Desafio;
import com.example.user.newpath.model.ItensChallenge;
import com.example.user.newpath.request.RequestChallenge;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardUser extends Fragment {
    private TextView data;
    private TextView label;
    private TextView pontos;
    private ListView listView;
    private ArrayList<ItensChallenge> desafios;

    protected View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard_user, container, false);

        initViews(view);
        makeRequest();
        return view;
    }

    private void makeRequest(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://natura-challenge.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestChallenge service = retrofit.create(RequestChallenge.class);

        service.getChallenges().enqueue(new Callback<Desafio>() {
            @Override
            public void onResponse(Call<Desafio> call, Response<Desafio> response) {
                Desafio resp = response.body();
                desafios = resp.getChallenges();
                createList();
                setChallengeToday();
            }

            @Override
            public void onFailure(Call<Desafio> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    protected void initViews(View view){

        data     = (TextView)view.findViewById(R.id.txt_date_challenge_today);
        label    = (TextView)view.findViewById(R.id.txt_desc_challenge_today);
        pontos   = (TextView)view.findViewById(R.id.txt_points_challenge_today);
        listView = (ListView)view.findViewById(R.id.list_challenge);
    }

    private void createList(){
        listView.setAdapter(new ChallengeAdapter(desafios, getActivity()));
    }

    private void setChallengeToday() {
        label.setText(desafios.get(0).getLabel());
        data.setText(desafios.get(0).getTime());
        pontos.setText(desafios.get(0).getValue());
    }

    private View.OnClickListener click_finalizar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
