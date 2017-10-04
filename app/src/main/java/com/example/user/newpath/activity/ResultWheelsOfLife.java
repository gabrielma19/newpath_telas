package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.fragment.DashboardUser;
import com.example.user.newpath.fragment.UserProfile;
import com.example.user.newpath.model.Itens;

import java.util.ArrayList;

public class ResultWheelsOfLife extends AppCompatActivity {
    private TextView area_de_foco;
    private Button btnFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_wheels_of_life);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        area_de_foco = (TextView) findViewById(R.id.btn_area_de_trabalho);

        setArea();

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDashboard();
            }
        });
    }

    public void setArea() {
        String catergoria;
        int maior = 0,menor =0, aux = 0;
        String category[] = {"Crescimento Pessoal", "Carreira", "Finanças", " Saúde", "Vida Social", "Rel.Familiar", "Rel.Afetivo", "Diversão", "Cont. Coletivo", "Espiritualidade"};
        int porcents[] = {Itens.instance().getCresPessoal(), Itens.instance().getCarreira(), Itens.instance().getFinanca(), Itens.instance().getSaude(), Itens.instance().getAmigos(), Itens.instance().getRelFamiliar(),
                Itens.instance().getRelAfetivo(), Itens.instance().getDivercao(), Itens.instance().getContColetivo(), Itens.instance().getEspiritualidade()};

        for(int i=0; i < porcents.length; i++) {
            if(porcents[i] > menor){
                menor = porcents[i];
                catergoria = category[i+1];
                area_de_foco.setText(catergoria);
            }
        }
    }

    public void startDashboard() {
        Intent intent = new Intent(ResultWheelsOfLife.this, UserProfile.class);
        startActivity(intent);
    }
}
