package com.example.user.newpath.activity;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Itens;
import com.example.user.newpath.model.User;
import com.example.user.newpath.request.RequestUserProfile;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ChartGraph extends AppCompatActivity {

    private Button btn_avaliation;
    private ArrayList<Itens> itens;
    int porcents[] = {2, 5, 4, 8, 10, 7, 3, 8, 5, 7};
    String category[] = {"Crescimento Pessoal", "Carreira", "Finanças", " Saúde", "Vida Social", "Rel.Familiar", "Rel.Afetivo", "Diversão", "Cont. Coletivo", "Espiritualidade"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chart_graph);
        btn_avaliation = (Button) findViewById(R.id.btn_avaliation);

        request();

        btn_avaliation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });
        setupPieChart();
    }

    private void request() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://natura-challenge.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestUserProfile service = retrofit.create(RequestUserProfile.class);



        service.getItens(User.instance().getId()).enqueue(new Callback<ArrayList<Itens>>() {
            @Override
            public void onResponse(Call<ArrayList<Itens>> call, Response<ArrayList<Itens>> response) {
                itens = response.body();

            }

            @Override
            public void onFailure(Call<ArrayList<Itens>> call, Throwable t) {

            }
        });
    }

    private void setupPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0; i < porcents.length; i++) {
            pieEntries.add(new PieEntry(porcents[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Roda da Vida");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);

        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();
    }

    public void showResult(){
        Intent intent = new Intent(ChartGraph.this, ResultWheelsOfLife.class);
        startActivity(intent);
    }
}
