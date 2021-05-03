package ru.aomikhailov.chessdrawmastercdm;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TableActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        List<Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);
        lv =  findViewById(R.id.listview);
         MyTableAdapter adapter = new MyTableAdapter(this,R.layout.adapter_item_table, playerList);
        lv.setAdapter(adapter);


    }
}
