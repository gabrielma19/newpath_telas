package com.example.user.newpath.fragment;


import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.adapter.ChallengeAdapter;
import com.example.user.newpath.model.ItensChallenge;
import com.example.user.newpath.model.User;
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

    private ImageView close_info;

    private TextView lbl_title;
    private TextView lbl_tempo;
    private TextView lbl_local;
    private TextView btn_finalizar;
    private TextView lbl_descricao;
    private TextView lbl_categoria;
    private TextView txt_pontos_total;
    private LinearLayout click_finalizar;
    private ScrollView info_challenge;

    private AlertDialog alerta;

    private TextView  conclued_title;
    private TextView  conclued_local;
    private TextView  conclued_tempo;
    private TextView  conclued_categoria;
    private TextView  conclued_description;
    private ImageView close_challenge_conclued;

    private ScrollView conclued_challenge;

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
                desafios = response.body();
                createList();
                setChallengeToday();
            }

            @Override
            public void onFailure(Call<ArrayList<ItensChallenge>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    protected void initViews(final View view){
//        verifyChallenge();

        data            = (TextView)view.findViewById(R.id.txt_date_challenge_today);
        label           = (TextView)view.findViewById(R.id.txt_desc_challenge_today);
        pontos          = (TextView)view.findViewById(R.id.txt_points_challenge_today);
        listView        = (ListView)view.findViewById(R.id.list_challenge);
        close_info      = (ImageView)view.findViewById(R.id.close_info);

        lbl_title       = (TextView)view.findViewById(R.id.label_title);
        lbl_tempo       = (TextView)view.findViewById(R.id.txt_info_tempo);
        lbl_local       = (TextView)view.findViewById(R.id.txt_info_local);
        lbl_descricao   = (TextView)view.findViewById(R.id.txt_info_descricao);
        lbl_categoria   = (TextView)view.findViewById(R.id.txt_info_categoria);
        txt_pontos_total = (TextView)view.findViewById(R.id.txt_pontos_total);

        btn_finalizar   = (TextView)view.findViewById(R.id.btn_finalizar_desafio);

        conclued_title           = (TextView)view.findViewById(R.id.conclued_title);
        conclued_local           = (TextView)view.findViewById(R.id.conclued_local);
        conclued_tempo           = (TextView)view.findViewById(R.id.conclued_tempo);
        conclued_categoria       = (TextView)view.findViewById(R.id.conclued_categoria);
        conclued_challenge       = (ScrollView)view.findViewById(R.id.conclued_challenge);
        conclued_description     = (TextView)view.findViewById(R.id.conclued_description);
        close_challenge_conclued = (ImageView)view.findViewById(R.id.close_warning_challenge_conclued);

        info_challenge  = (ScrollView)view.findViewById(R.id.info_challenge);

        click_finalizar = (LinearLayout)view.findViewById(R.id.box_finalizar_desafio);


        click_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(User.instance().getChallengeStatus() == false){

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Iniciar Desafio");

                    builder.setMessage("Deseja Iniciar este desafio ?");
                    builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            User.instance().setChallengeStatus(true);
                            btn_finalizar.setText("Finalizar Desafio");
                            User.instance().getNumberChallenge();
                        }
                    });
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(getContext(), "Estamos te Esperando", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alerta = builder.create();
                    alerta.show();

                }else{
                    User.instance().setChallengeStatus(false);
                    btn_finalizar.setText("Inicar Desafio");

                    Animation sliceIn = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in);
                    conclued_challenge.startAnimation(sliceIn);

                    conclued_challenge.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    click_finalizar.setVisibility(View.GONE);

                    int pontos  = User.instance().getScore() + 100;

                    User.instance().setScore(pontos);

                    txt_pontos_total.setText(User.instance().getScore() + "pts");

                    setChallengeConclued();
                }
            }
        });

        close_challenge_conclued.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation sliceOut = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out);
                conclued_challenge.startAnimation(sliceOut);

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                conclued_challenge.setVisibility(View.GONE);
                                listView.setVisibility(View.VISIBLE);
                                click_finalizar.setVisibility(View.VISIBLE);
                            }
                        }, 300);
            }
        });
        close_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation sliceOut = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out);

                info_challenge.startAnimation(sliceOut);

                new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            info_challenge.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            click_finalizar.setVisibility(View.VISIBLE);
                        }
                    }, 300);
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

            Animation sliceUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in);

            listView.setVisibility(View.GONE);
            info_challenge.setVisibility(View.VISIBLE);
            click_finalizar.setVisibility(View.GONE);

            info_challenge.startAnimation(sliceUp);


            lbl_title.setText(desafio.getTitle());
            lbl_tempo.setText(desafio.getTime());
            lbl_local.setText(desafio.getWhere());
            lbl_descricao.setText(desafio.getDescripton());
            lbl_categoria.setText(desafio.getCategoria());


            Toast.makeText(getActivity(), desafio.getTitle(), Toast.LENGTH_SHORT).show();
        }
    };
    private void verifyChallenge() {
        if(User.instance().getChallengeStatus() != false){
            btn_finalizar.setText("Finalizar Desafio");
        }
    }
    private void setChallengeConclued() {

        conclued_title.setText(desafios.get(0).getTitle());
        conclued_description.setText(desafios.get(0).getDescripton());
        conclued_categoria.setText(desafios.get(0).getCategoria());
        conclued_local.setText(desafios.get(0).getWhere());
        conclued_tempo.setText(desafios.get(0).getTime());
    }

    private void setChallengeToday() {
        label.setText(desafios.get(0).getLabel());
        data.setText(desafios.get(0).getTime());
        pontos.setText(desafios.get(0).getValue());
    }
}
