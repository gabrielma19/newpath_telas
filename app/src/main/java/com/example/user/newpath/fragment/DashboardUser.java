package com.example.user.newpath.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.adapter.ChallengeAdapter;
import com.example.user.newpath.model.ItensChallenge;
import com.example.user.newpath.model.User;
import com.example.user.newpath.request.RequestChallenge;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;
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
    private ProgressBar progress_bar;
    private TextView txt_pontos_total;
    private ScrollView info_challenge;
    private LinearLayout click_finalizar;
    private LinearLayout click_compartilhar;
    private CircleImageView image_profile;

    private AlertDialog alerta;
    private LinearLayout viewContent;

    private TextView  conclued_title;
    private TextView  conclued_local;
    private TextView  conclued_tempo;
    private TextView  conclued_categoria;
    private TextView  conclued_description;
    private ImageView close_challenge_conclued;

    private ScrollView conclued_challenge;

    private ArrayList<ItensChallenge> desafios;

    private static final int SOLICITAR_PERMISSAO = 1;

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

    int currentValue = User.instance().getScore();
    Timer timer = new Timer();

    protected void initViews(final View view){
        data                     = (TextView)view.findViewById(R.id.txt_date_challenge_today);
        label                    = (TextView)view.findViewById(R.id.txt_desc_challenge_today);
        pontos                   = (TextView)view.findViewById(R.id.txt_points_challenge_today);
        listView                 = (ListView)view.findViewById(R.id.list_challenge);
        close_info               = (ImageView)view.findViewById(R.id.close_info);

        lbl_title                = (TextView)view.findViewById(R.id.label_title);
        lbl_tempo                = (TextView)view.findViewById(R.id.txt_info_tempo);
        lbl_local                = (TextView)view.findViewById(R.id.txt_info_local);
        lbl_descricao            = (TextView)view.findViewById(R.id.txt_info_descricao);
        lbl_categoria            = (TextView)view.findViewById(R.id.txt_info_categoria);
        txt_pontos_total         = (TextView)view.findViewById(R.id.txt_pontos_total);

        progress_bar             = (ProgressBar)view.findViewById(R.id.progress_bar_list);

        image_profile            = (CircleImageView)view.findViewById(R.id.image_profile);

        btn_finalizar            = (TextView)view.findViewById(R.id.btn_finalizar_desafio);

        viewContent              = (LinearLayout)view.findViewById(R.id.contentView);

        conclued_title           = (TextView)view.findViewById(R.id.conclued_title);
        conclued_local           = (TextView)view.findViewById(R.id.conclued_local);
        conclued_tempo           = (TextView)view.findViewById(R.id.conclued_tempo);
        conclued_categoria       = (TextView)view.findViewById(R.id.conclued_categoria);
        conclued_challenge       = (ScrollView)view.findViewById(R.id.conclued_challenge);
        conclued_description     = (TextView)view.findViewById(R.id.conclued_description);
        close_challenge_conclued = (ImageView)view.findViewById(R.id.close_warning_challenge_conclued);

        info_challenge           = (ScrollView)view.findViewById(R.id.info_challenge);

        click_finalizar          = (LinearLayout)view.findViewById(R.id.box_finalizar_desafio);
        click_compartilhar       = (LinearLayout)view.findViewById(R.id.compartilhar_desafio);

        verifyChallenge();

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
                            click_finalizar.setBackgroundColor(getContext().getResources().getColor(R.color.colorFontPrincipal));
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
                    click_compartilhar.setVisibility(View.VISIBLE);

                    int pontos_challenge  = User.instance().getScore() + 100;
                    User.instance().setScore(pontos_challenge);

                    setChallengeConclued();
                }
            }
        });

        click_compartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarPermissao();
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

                                click_compartilhar.setVisibility(View.GONE);
                                click_finalizar.setBackgroundColor(getContext().getResources().getColor(R.color.colorButtonOff));

                                timer.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        getActivity().runOnUiThread(new Runnable(){
                                            @Override
                                            public void run(){

                                                if(currentValue < User.instance().getScore()){
                                                    currentValue++;
                                                    txt_pontos_total.setText(currentValue + "pts");
                                                }
                                                else
                                                    timer.cancel();
                                            }
                                        });
                                    }
                                }, 30, 30);
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
        progress_bar.setVisibility(View.GONE);

        txt_pontos_total.setText("" + User.instance().getScore() + "pts");
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
        Picasso.with(getContext()).load("https://scontent.fcgh9-1.fna.fbcdn.net/v/t1.0-1/p160x160/15541669_1198791003538602_6695998944680896879_n.jpg?oh=c6b1cceefd55a422f5ab999609768f60&oe=5A73394F").into(image_profile);

        label.setText(desafios.get(0).getLabel());
        data.setText(desafios.get(0).getTime());
        pontos.setText(desafios.get(0).getValue());
    }

    private void checarPermissao(){

        // Verifica  o estado da permissão de WRITE_EXTERNAL_STORAGE
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);


        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            // Se for diferente de PERMISSION_GRANTED, então vamos exibir a tela padrão
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, SOLICITAR_PERMISSAO);
        } else {
            // Senão vamos compartilhar a imagem
            sharedImage();
        }
    }

    public  Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap( 320, 400, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;

    }

    private void sharedImage(){

        // Vamos carregar a imagem em um bitmap
        Bitmap b = loadBitmapFromView(viewContent);
        Intent share = new Intent(Intent.ACTION_SEND);
        //setamos o tipo da imagem
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        // comprimomos a imagem
        b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        // Gravamos a imagem
        String path = MediaStore.Images.Media.insertImage(getContext().getContentResolver(), b, "NewPath", null);
        // criamos uam Uri com o endereço que a imagem foi salva
        Uri imageUri =  Uri.parse(path);
        // Setmaos a Uri da imagem
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        // chama o compartilhamento
        startActivity(Intent.createChooser(share, "Selecione"));
    }

}

