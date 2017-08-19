package com.example.user.newpath.activity;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.newpath.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.github.mikephil.charting.utils.ColorTemplate.*;

public class ChartGraph extends AppCompatActivity {
    int porcents[] = {2, 5, 4, 8, 10, 7, 3, 8, 5, 7};
    String category[] = {"Crescimento Pessoal", "Carreira", "Finanças", " Saúde", "Vida Social", "Rel.Familiar", "Rel.Afetivo", "Diversão","Cont. Coletivo", "Espiritualidade"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_graph);

        setupPieChart();
    }
    private void setupPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i <  porcents.length; i++){
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
}
