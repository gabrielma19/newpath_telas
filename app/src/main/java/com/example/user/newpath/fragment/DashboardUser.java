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

import java.util.ArrayList;

import okhttp3.Challenge;

public class DashboardUser extends Fragment {

    private ListView listView;

    protected View view;
    private LinearLayout box_finalizar_desafio;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

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
