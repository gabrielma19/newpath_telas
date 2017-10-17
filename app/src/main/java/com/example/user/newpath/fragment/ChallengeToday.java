package com.example.user.newpath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Challenge;
import com.example.user.newpath.model.ItensChallenge;
import com.example.user.newpath.request.RequestChallenge;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ChallengeToday extends Fragment {


    private TextView time_today;
    private TextView value_today;
    private TextView bonus_today;
    private TextView label_today;
    private TextView title_today;
    private TextView location_today;
    private ProgressBar progress_bar;
    private TextView validation_today;
    private TextView description_today;
    private ArrayList<ItensChallenge> desafios;




    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_challenge_today, container, false);

        initViews(view);


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
                setValues();
            }

            @Override
            public void onFailure(Call<ArrayList<ItensChallenge>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    protected void initViews(View view) {

        time_today          = (TextView)view.findViewById(R.id.txt_time_challenge_today);
        label_today         = (TextView)view.findViewById(R.id.txt_label_challenge_today);
        title_today         = (TextView)view.findViewById(R.id.txt_title_challenge_today);
        value_today         = (TextView)view.findViewById(R.id.txt_value_challenge_today);
        progress_bar        = (ProgressBar)view.findViewById(R.id.progress_challenge_today);
        location_today      = (TextView)view.findViewById(R.id.txt_location_challenge_today);
        description_today   = (TextView)view.findViewById(R.id.txt_description_challenge_today);
        validation_today    = (TextView)view.findViewById(R.id.txt_validation_time_challenge_today);

        makeRequest();
    }

    private void setValues() {
        if (desafios == null)
            return;
        progress_bar.setVisibility(View.GONE);

        time_today.setText(desafios.get(0).getTime());
        label_today.setText(desafios.get(0).getLabel());
        title_today.setText(desafios.get(0).getTitle());
        value_today.setText(desafios.get(0).getValue());
        location_today.setText(desafios.get(0).getWhere());
        validation_today.setText(desafios.get(0).getValidation());
        description_today.setText(desafios.get(0).getDescripton());
    }
}
