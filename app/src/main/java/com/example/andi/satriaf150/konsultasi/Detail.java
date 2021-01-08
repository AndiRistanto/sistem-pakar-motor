package com.example.andi.satriaf150.konsultasi;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andi.satriaf150.MainActivity;
import com.example.andi.satriaf150.R;
import com.example.andi.satriaf150.database.DatabaseAccess;

import java.util.List;

public class Detail extends AppCompatActivity {

    private ListView listView;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView detail = findViewById(R.id.detail);
        TextView solusi = findViewById(R.id.solusi);
        this.listView = findViewById(R.id.listView);

        Intent i = getIntent();

        id = i.getStringExtra("id");

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String detail_kesimpulan = databaseAccess.getData("kerusakan",1, id);
        String x = "SELECT * FROM kerusakan_solusi where kode_kerusakan_solusi = \"" + id + "\"";
        String daftar_kode_solusi = databaseAccess.getData("kerusakan_solusi",1, id);
        String daftar_solusi = databaseAccess.getData("solusi", 1, daftar_kode_solusi);

        /*
        final List<String> daftar_kode_solusi = databaseAccess.getListData("kerusakan_solusi",1, id);

        List<String> daftar_solusi = databaseAccess.getListData("solusi",1, daftar_kode_solusi);
        databaseAccess.close();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, daftar_solusi){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.BLACK);
                return view;
            }
        };
        this.listView.setAdapter(arrayAdapter);
*/


        detail.setText(detail_kesimpulan);
        solusi.setText(daftar_solusi);
    }

    public void goHome(View v) {
        Intent inte =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(inte);
        finish();
    }


    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
    }
}
