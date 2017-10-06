package com.example.user.newpath.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.adapter.ChallengeAdapter;
import com.example.user.newpath.model.Challenge;
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
    private TextView info_local;
    private ImageView close_info;
    private TextView info_categoria;
    private TextView info_descricao;
    private LinearLayout info_challenge;
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

        service.getChallenges().enqueue(new Callback<ArrayList<ItensChallenge>>() {
            public void onResponse(Call<ArrayList<ItensChallenge>> call, Response<ArrayList<ItensChallenge>> response) {
                desafios= response.body();
                createList();
                setChallengeToday();
            }

            @Override
            public void onFailure(Call<ArrayList<ItensChallenge>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    protected void initViews(View view){

        data            = (TextView)view.findViewById(R.id.txt_date_challenge_today);
        label           = (TextView)view.findViewById(R.id.txt_desc_challenge_today);
        pontos          = (TextView)view.findViewById(R.id.txt_points_challenge_today);
        listView        = (ListView)view.findViewById(R.id.list_challenge);
        info_local      = (TextView)view.findViewById(R.id.txt_info_local);
        close_info      = (ImageView)view.findViewById(R.id.close_info);
        info_categoria  = (TextView)view.findViewById(R.id.txt_info_categoria);
        info_descricao  = (TextView)view.findViewById(R.id.txt_info_descricao);
        info_challenge  = (LinearLayout)view.findViewById(R.id.info_challenge);

        close_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info_challenge.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }
        });

    }

    private void createList(){
        if(desafios == null)
            return;

        listView.setOnItemClickListener(listItemclick);
        listView.setAdapter(new ChallengeAdapter(desafios, getActivity()));
    }

    private AdapterView.OnItemClickListener listItemclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
            ItensChallenge desafio = desafios.get(index);
            info_challenge.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);

            info_local.setText(desafio.getWhere());
            info_categoria.setText(desafio.getCategoria());
            info_descricao.setText(desafio.getDescripton());
            Toast.makeText(getActivity(), desafio.getTitle(), Toast.LENGTH_SHORT).show();
        }
    };


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
