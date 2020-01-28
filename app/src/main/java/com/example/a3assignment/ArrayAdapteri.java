package com.example.a3assignment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArrayAdapteri extends ArrayAdapter<Date> {

    private Context context;
    ArrayList<Date> datalista;



    public ArrayAdapteri(@NonNull Context context, int resource,
                         @NonNull ArrayList<Date> objects) {
        super(context, resource, objects);
        this.context = context;
        this.datalista = objects;


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View v = layoutInflater.inflate(R.layout.listatemplate, parent, false);
        LinearLayout linearLayout = (LinearLayout) v;
        TextView textView = v.findViewById(R.id.textView);
        textView.setText(DateFormat.getDateInstance().format(datalista.get(position)));
        Button button = v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datalista.remove(position);
                notifyDataSetChanged();
            }
        });

        return linearLayout;
    }
}
