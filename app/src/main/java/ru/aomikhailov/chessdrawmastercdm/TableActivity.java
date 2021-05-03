package ru.aomikhailov.chessdrawmastercdm;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class TableActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        List<Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);
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
