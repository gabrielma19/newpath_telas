package com.example.user.newpath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Challenge;


public class ChallengeToday extends Fragment {

    private TextView label_today;
    private TextView title_today;
    private TextView description_today;
    private TextView location_today;
    private TextView time_today;
    private TextView validation_today;
    private TextView value_today;
    private TextView bonus_today;




    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_challenge_today, container, false);

        initViews(view);

        return view;
    }

    protected void initViews(View view) {
        label_today = (TextView)view.findViewById(R.id.txt_label_challenge_today);
        title_today = (TextView)view.findViewById(R.id.txt_title_challenge_today);
        description_today = (TextView)view.findViewById(R.id.txt_description_challenge_today);
        location_today = (TextView)view.findViewById(R.id.txt_location_challenge_today);
        time_today = (TextView)view.findViewById(R.id.txt_time_challenge_today);
        validation_today = (TextView)view.findViewById(R.id.txt_validation_time_challenge_today);
        value_today =(TextView)view.findViewById(R.id.txt_value_challenge_today);

        setValues();

    }

    private void setValues() {
        //TODO
        label_today.setText(Challenge.instance().getLabel());

    }
}
