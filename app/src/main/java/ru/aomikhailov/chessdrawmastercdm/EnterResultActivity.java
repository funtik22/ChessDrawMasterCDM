package ru.aomikhailov.chessdrawmastercdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterResultActivity extends AppCompatActivity {

    ListView listView;
    Button ExitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_result);
        final List<Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);
        listView = findViewById(R.id.ListViewEnterResult);
        ExitButton = findViewById(R.id.buttonExit1);
        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tournament.tour++;
                Intent intent = new Intent(EnterResultActivity.this, TournamentActivity.class);
                intent.putExtra(Constants.PLAYER_LIST_NAME, (Serializable) playerList);
                startActivity(intent);
            }
        });
        if(Tournament.tour != playerList.size()){
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
            MyEnterPlayerAdapter myEnterPlayerAdapter = new MyEnterPlayerAdapter(this, R.layout.adapter_item_enterresult, playerList);
            listView.setAdapter(myEnterPlayerAdapter);
        }

    }
}
