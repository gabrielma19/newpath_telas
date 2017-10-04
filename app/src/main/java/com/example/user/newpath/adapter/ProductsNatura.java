package com.example.user.newpath.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.newpath.R;
import com.example.user.newpath.model.Products;

import java.util.ArrayList;

/**
 * Created by jussi on 10/4/17.
 */

public class ProductsNatura extends RecyclerView.Adapter<ProductsNatura.MyViewHolder> {

    private ArrayList<Products> products;
    private LayoutInflater layoutInflater;

    public  ProductsNatura(ArrayList<Products> produtos, Context context){
        products = produtos;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.adapter_products_natura, parent, false);

        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView prod_image;
        private TextView  prod_description;
        private TextView  prod_points;

        public MyViewHolder(View itemView) {
            super(itemView);

            prod_description = (TextView)itemView.findViewById(R.id.produtcs_description);
            prod_points = (TextView)itemView.findViewById(R.id.produtcs_score);
            prod_image = (ImageView)itemView.findViewById(R.id.produtcs_image);

        }
    }


}

