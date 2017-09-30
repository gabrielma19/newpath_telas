package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Itens;
import com.example.user.newpath.model.User;

public class RangeWheesLife extends AppCompatActivity {


    private TextView txt_pessoal;
    private TextView txt_carreira;
    private TextView txt_financa;
    private TextView txt_saude;
    private TextView txt_amigos;
    private SeekBar seek_pessoal;
    private SeekBar seek_carreira;
    private SeekBar seek_financa;
    private SeekBar seek_saude;
    private SeekBar seek_amigos;



    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_whees_life);

        txt_saude       = (TextView) findViewById(R.id.txt_saude);
        txt_amigos      = (TextView) findViewById(R.id.txt_amigos);
        txt_financa     = (TextView) findViewById(R.id.txt_financas);
        txt_pessoal     = (TextView) findViewById(R.id.txt_crescimento);
        txt_carreira    = (TextView) findViewById(R.id.txt_carreira);

        seek_saude      = (SeekBar) findViewById(R.id.seek_saude);
        seek_amigos     = (SeekBar) findViewById(R.id.seek_social);
        seek_financa    = (SeekBar) findViewById(R.id.seek_financa);
        seek_pessoal    = (SeekBar) findViewById(R.id.seek_cres_pessoal);
        seek_carreira   = (SeekBar) findViewById(R.id.seek_carreira);


        seek_saude.setOnSeekBarChangeListener(SeekBarChangeSaude);
        seek_amigos.setOnSeekBarChangeListener(SeekBarChangeAmigos);
        seek_financa.setOnSeekBarChangeListener(SeekBarChangeFinanca);
        seek_pessoal.setOnSeekBarChangeListener(SeekBarChangePessoal);
        seek_carreira.setOnSeekBarChangeListener(SeekBarChangeCarreira);



        btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarInformacoes();
            }
        });

    }
    private SeekBar.OnSeekBarChangeListener SeekBarChangeSaude = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_saude.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener SeekBarChangeAmigos = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_amigos.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener SeekBarChangeFinanca = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_financa.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener SeekBarChangePessoal = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_pessoal.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener SeekBarChangeCarreira = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_carreira.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void nextPageWheels(){
        Intent intent = new Intent(this, RangeWheelsLife_Two.class);
        startActivity(intent);
    }

    private void gravarInformacoes() {
        Itens itens = new Itens();

        Itens.instance().setSaude(Integer.parseInt(txt_saude.getText().toString()));
        Itens.instance().setAmigos(Integer.parseInt(txt_amigos.getText().toString()));
        Itens.instance().setFinanca(Integer.parseInt(txt_financa.getText().toString()));
        Itens.instance().setCresPessoal(Integer.parseInt(txt_pessoal.getText().toString()));
        Itens.instance().setCarreira(Integer.parseInt(txt_carreira.getText().toString()));

        nextPageWheels();
    }
}
