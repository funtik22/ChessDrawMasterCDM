package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TournamentActivity extends AppCompatActivity {

Button OpenTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tournament);
        List <Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);
        OpenTable = findViewById(R.id.ButtonOpenTable);
        OpenTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TournamentActivity.this, TableActivity.class);
                startActivity(intent);
            }
        });



    }
}
