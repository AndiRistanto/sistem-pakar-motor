package com.example.andi.satriaf150;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.andi.satriaf150.konsultasi.Konsultasi;
import com.example.andi.satriaf150.lihatData.lihatDataKerusakan;
import com.example.andi.satriaf150.tentang.TentangActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView konsulCv, lihat_dataCv, bantuanCv, tentangCv, rawatCv, exitCv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konsulCv = (CardView) findViewById(R.id.konsulCv);
        lihat_dataCv = (CardView) findViewById(R.id.lihat_dataCv);
        bantuanCv = (CardView) findViewById(R.id.bantuanCv);
        tentangCv = (CardView) findViewById(R.id.tentangCv);
        rawatCv = (CardView) findViewById(R.id.rawatCv);
        exitCv = (CardView) findViewById(R.id.exitCv);

        //add click listener
        konsulCv.setOnClickListener(this);
        lihat_dataCv.setOnClickListener(this);
        bantuanCv.setOnClickListener(this);
        tentangCv.setOnClickListener(this);
        rawatCv.setOnClickListener(this);
        exitCv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.konsulCv : i = new Intent(this, Konsultasi.class);
                i.putExtra("kode_gejala","G06");
                startActivity(i);
                break;
            case R.id.lihat_dataCv : i = new Intent(this, lihatDataKerusakan.class);
                i.putExtra("kode_gejala","G06");
                startActivity(i);
                break;
            case R.id.bantuanCv : i = new Intent(this, BantuanActivity.class);
                startActivity(i);
                break;
            case R.id.tentangCv : i = new Intent(this, TentangActivity.class);
                startActivity(i);
                break;
            case R.id.rawatCv : i = new Intent(this, PerawatanActivity.class);
                startActivity(i);
                break;
            case R.id.exitCv : showAlertDialog();
            default: break;
        }

        /*
        exitCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
        */
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Yakin Anda ingin keluar?")
                .setCancelable(false)
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }


}
