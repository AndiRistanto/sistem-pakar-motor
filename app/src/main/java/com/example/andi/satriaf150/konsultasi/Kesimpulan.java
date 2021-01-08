package com.example.andi.satriaf150.konsultasi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andi.satriaf150.MainActivity;
import com.example.andi.satriaf150.R;
import com.example.andi.satriaf150.database.DatabaseAccess;

public class Kesimpulan extends AppCompatActivity {

    //contoh commit
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesimpulan);

        TextView simpulan = (findViewById(R.id.kesimpulan));
        TextView judul = (findViewById(R.id.judul_kesimpulan));
        ImageView g = findViewById(R.id.gambar);

        Intent i = getIntent();
        id = i.getStringExtra("id");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        String kesimpulan = databaseAccess.getData("kerusakan",1, id);
        databaseAccess.close();


        simpulan.setText(kesimpulan);
    }
    public void goHome(View v) {
        Intent inte = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(inte);
        finish();
    }
    @SuppressLint("ShowToast")
    public void goDetail(View v) {
        if (id.equals("K10")) {
            Toast.makeText(this,"Anda tidak kerusakan",Toast.LENGTH_SHORT).show();
        } else {
            Intent inte = new Intent(getApplicationContext(), Detail.class);
            inte.putExtra("id", id);
            startActivity(inte);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}