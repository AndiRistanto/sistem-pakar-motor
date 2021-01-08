package com.example.andi.satriaf150.lihatData;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.andi.satriaf150.R;
import com.example.andi.satriaf150.database.DatabaseAccess;

import java.util.List;

public class lihatDataKerusakan extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_kerusakan);

        this.listView = findViewById(R.id.listView);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);

        databaseAccess.open();
        List<String> kerusakan = databaseAccess.getKerusakan();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kerusakan);
        this.listView.setAdapter(adapter);
    }
}
