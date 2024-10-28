package com.clerodri.mypizzastore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private List<Product> products;
    private LayoutInflater mInflater;


    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.mInflater = LayoutInflater.from(context);;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Product getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        Product product = getItem(position);
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.item_comida, container, false);
            TextView tvProduct =  convertView.findViewById(R.id.nombre_comida);
            tvProduct.setText(product.getName());
            TextView tvDescription =  convertView.findViewById(R.id.descripcion_comida);
            tvDescription.setText(product.getMessage());
            ImageView ivProduct =  convertView.findViewById(R.id.imagen_comida);
            ivProduct.setImageResource(product.getImgId());

        }
        convertView.setOnClickListener(v->{
            Intent intent = new Intent(mInflater.getContext(), OrderActivity.class);
            intent.putExtra("productSelected",product);
            mInflater.getContext().startActivity(intent);
        });
        return convertView;
    }
}
