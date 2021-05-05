package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.*;

public class TableActivity extends AppCompatActivity {

    ListView lv;
    Button ButtonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        final List<Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);
        ButtonExit = findViewById(R.id.ExitButton);
        ButtonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TableActivity.this, TournamentActivity.class);
                intent.putExtra(Constants.PLAYER_LIST_NAME, (Serializable) playerList);
                startActivity(intent);
            }
        });
       Collections.sort(playerList, new Comparator<Player>() {
           @Override
           public int compare(Player o1, Player o2) {
                if(o1.getRating()>o2.getRating()){
                    return -1;
                }
                else{
               return 1; }
           }
       });
        lv =  findViewById(R.id.listview);
         MyTableAdapter adapter = new MyTableAdapter(this,R.layout.adapter_item_table, playerList);
        lv.setAdapter(adapter);


    }
}
