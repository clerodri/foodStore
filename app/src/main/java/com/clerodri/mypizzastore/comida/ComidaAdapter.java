
package com.clerodri.mypizzastore.comida;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView.*;

import com.clerodri.mypizzastore.OrderActivity;
import com.clerodri.mypizzastore.R;

import java.util.List;

public class ComidaAdapter extends BaseAdapter implements View.OnClickListener {

    private List<Comida> comidas;
    private LayoutInflater mInflater;

    public ComidaAdapter(Context context, List<Comida> comidas) {
        this.mInflater= LayoutInflater.from(context);
        this.comidas = comidas;
    }

    @Override
    public int getCount() {
        return comidas.size();
    }

    @Override
    public Comida getItem(int idComida) {
        return comidas.get(idComida);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.item_comida, container, false);
            TextView txtNombreComida =  convertView.findViewById(R.id.nombre_comida);
            txtNombreComida.setText(getItem(position).getNombre());
            TextView tvDescription =  convertView.findViewById(R.id.descripcion_comida);
            tvDescription.setText(getItem(position).getDescripcion());
            ImageView ivComida =  convertView.findViewById(R.id.imagen_comida);
            ivComida.setImageResource(getItem(position).getImagenId());

        }
        Comida comida = getItem(position);
        convertView.setOnClickListener(v->{
            Intent intent = new Intent(mInflater.getContext(), OrderActivity.class);
            intent.putExtra("comidaSelected",comida);
            mInflater.getContext().startActivity(intent);
        });

        return convertView;
    }


    @Override
    public void onClick(View view) {

    }
}
