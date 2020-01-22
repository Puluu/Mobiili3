package com.example.a3assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Date> lista;
    ArrayAdapter<Date> dateArrayAdapter;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button1 = findViewById(R.id.button1);
        lista = new ArrayList<>();
        dateArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listView = findViewById(R.id.listView);
        listView.setAdapter(dateArrayAdapter);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setPositiveButton("kyllä", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date aika = Calendar.getInstance().getTime();
                        dateArrayAdapter.add(aika);
                    }
                });
                ab.setNegativeButton("ei", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog alertti = ab.create();
                alertti.show();
            }
        });




    }
}
