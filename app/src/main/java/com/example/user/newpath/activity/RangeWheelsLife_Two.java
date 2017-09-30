package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Itens;

public class RangeWheelsLife_Two extends AppCompatActivity {

    private Button   btn_graphic;
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

        btn_graphic   = (Button)findViewById(R.id.btn_finally);

        seek_afeto.setOnSeekBarChangeListener(seekBarChangeAfeto);
        seek_familia.setOnSeekBarChangeListener(seekBarChangeFamily);
        seek_divercao.setOnSeekBarChangeListener(seekBarChangeDivercao);
        seek_coletivo.setOnSeekBarChangeListener(seekBarChangeColetivo);
        seek_espirito.setOnSeekBarChangeListener(seekBarChangeEspirito);

        btn_graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarDados();
                generateGraphic();
            }
        });


    }
    public void  generateGraphic() {
        Intent intent = new Intent(RangeWheelsLife_Two.this, ChartGraph.class);
        startActivity(intent);
    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeFamily = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            txt_familia.setText(String.valueOf(progress));
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
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private void gravarDados() {
        Itens itens = new Itens();

        itens.setSaude(Itens.instance().getSaude());
        itens.setAmigos(Itens.instance().getAmigos());
        itens.setFinanca(Itens.instance().getFinanca());
        itens.setCresPessoal(Itens.instance().getCresPessoal());
        itens.setCarreira(Itens.instance().getCarreira());


        itens.setRelFamiliar(Integer.parseInt(txt_familia.getText().toString()));
        itens.setRelAfetivo(Integer.parseInt(txt_afeto.getText().toString()));
        itens.setDivercao(Integer.parseInt(txt_divercao.getText().toString()));
        itens.setContColetivo(Integer.parseInt(txt_coletivo.getText().toString()));
        itens.setEspiritualidade(Integer.parseInt(txt_espirito.getText().toString()));

        itens.salvarDados();

        generateGraphic();
    }
  }
