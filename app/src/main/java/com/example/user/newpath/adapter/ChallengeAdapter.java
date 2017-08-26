package com.example.user.newpath.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Desafio;

import java.util.ArrayList;

/**
 * Created by User on 25/08/2017.
 */

public class ChallengeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Desafio> desafios;

    public  ChallengeAdapter(ArrayList<Desafio> desafios, Context context){
        this.desafios = desafios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null){


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.adpter_challenge_list, null);

        TextView txt_desc_challenge = (TextView)view.findViewById(R.id.txt_desc_challenge);
        TextView txt_data_challenge = (TextView)view.findViewById(R.id.txt_date_challenge);
        TextView txt_point_challenge = (TextView)view.findViewById(R.id.txt_points_challenge);

        viewHolder = new ViewHolder(txt_desc_challenge, txt_data_challenge, txt_point_challenge);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        fillFields(i, viewHolder);

        return view;
    }

    public void fillFields(int position, ViewHolder viewHolder){

    }

    public class ViewHolder {
        private TextView txt_desc_challenge;
        private TextView txt_data_challenge;
        private TextView txt_point_challenge;

        public ViewHolder(TextView txt_desc_challenge,TextView txt_data_challenge,TextView txt_point_challenge) {
            this.txt_data_challenge  = txt_data_challenge;
            this.txt_desc_challenge  = txt_desc_challenge;
            this.txt_point_challenge = txt_point_challenge;
        }
    }

}


