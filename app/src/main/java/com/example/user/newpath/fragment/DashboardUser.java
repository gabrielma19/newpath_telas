package com.example.user.newpath.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.user.newpath.R;

public class DashboardUser extends Fragment {
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


    }
    private View.OnClickListener click_finalizar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
