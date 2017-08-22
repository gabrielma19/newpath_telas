package com.example.user.newpath.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Itens;

public class RangeWheelsLife_Two extends AppCompatActivity {
    private TextView txt_familia;
    private TextView txt_afeto;
    private TextView txt_divercao;
    private TextView txt_coletivo;
    private TextView txt_espirito;
    private SeekBar seek_familia;
    private SeekBar seek_afeto;
    private SeekBar seek_divercao;
    private SeekBar seek_coletivo;
    private SeekBar seek_espirito;

    private Itens itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_wheels_life__two);

        seek_afeto    = (SeekBar) findViewById(R.id.seek_afeto);
        seek_familia  = (SeekBar) findViewById(R.id.seek_familia);
        seek_divercao = (SeekBar) findViewById(R.id.seek_divercao);
        seek_coletivo = (SeekBar) findViewById(R.id.seek_coletivo);
        seek_espirito = (SeekBar) findViewById(R.id.seek_espirito);
        txt_familia   = (TextView)findViewById(R.id.txt_familia);
        txt_afeto     = (TextView)findViewById(R.id.txt_afeto);
        txt_divercao  = (TextView)findViewById(R.id.txt_divercao);
        txt_coletivo  = (TextView)findViewById(R.id.txt_coletivo);
        txt_espirito  = (TextView)findViewById(R.id.txt_espirito);

        seek_afeto.setOnSeekBarChangeListener(seekBarChangeAfeto);
        seek_familia.setOnSeekBarChangeListener(seekBarChangeFamily);
        seek_divercao.setOnSeekBarChangeListener(seekBarChangeDivercao);
        seek_coletivo.setOnSeekBarChangeListener(seekBarChangeColetivo);
        seek_espirito.setOnSeekBarChangeListener(seekBarChangeEspirito);


    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeFamily = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_familia.setText(String.valueOf(progress));
            itens.setRelFamiliar(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarChangeAfeto = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_afeto.setText(String.valueOf(progress));
            itens.setRelAfetivo(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarChangeDivercao = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_divercao.setText(String.valueOf(progress));
            itens.setDivercao(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarChangeColetivo = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_coletivo.setText(String.valueOf(progress));
            itens.setContColetivo(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarChangeEspirito = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_espirito.setText(String.valueOf(progress));
            itens.setEspiritualidade(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
  }
