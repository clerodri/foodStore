package com.clerodri.mypizzastore.bebida;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.clerodri.mypizzastore.R;
import com.clerodri.mypizzastore.comida.Comida;

import java.util.List;

public class BediaAdapter extends BaseAdapter {
    private List<Bebida> bebidas;
    private LayoutInflater mInflater;

    public BediaAdapter(Context context, List<Bebida> bebidas) {
        this.mInflater= LayoutInflater.from(context);
        this.bebidas = bebidas;
    }

    @Override
    public int getCount() {
        return bebidas.size();
    }

    @Override
    public Object getItem(int i) {
        return bebidas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup container) {
        if (view == null) {

           /* view = mInflater.inflate(R.layout.item_comida, container, false);
            TextView txtNombreComida =  view.findViewById(R.id.nombre_comida);
            txtNombreComida.setText(getItem(position).getNombre());
            TextView tvDescription =  view.findViewById(R.id.descripcion_comida);
            tvDescription.setText(getItem(position).getNombre());
            ImageView ivComida =  view.findViewById(R.id.imagen_comida);
            ivComida.setImageResource(getItem(position).getImagenId());*/

        }
        return view;
    }
}
