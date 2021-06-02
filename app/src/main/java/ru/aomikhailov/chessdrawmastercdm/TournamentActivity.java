package ru.aomikhailov.chessdrawmastercdm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TournamentActivity extends AppCompatActivity {

Button OpenTable;
Button EnterResult;
TextView Tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tournament);
        getSupportActionBar().hide();
        final List <Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);
        EnterResult = findViewById(R.id.EnterResultButton);
        Tour=findViewById(R.id.tourText);
        Tour.setText(Tournament.tour.toString()+" Тур");

        if(Tournament.tour==playerList.size())
        {
            Toast.makeText(getApplicationContext(), "Турнир закончен", Toast.LENGTH_LONG);
            AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
            alertdialog.setTitle("Турнир завершён");
            alertdialog.create();
            alertdialog.show();
        }

        if(Tournament.tour!=playerList.size()) {
            EnterResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TournamentActivity.this, EnterResultActivity.class);
                    intent.putExtra(Constants.PLAYER_LIST_NAME, (Serializable) playerList);
                    startActivity(intent);
                }
            });
        }
        OpenTable = findViewById(R.id.ButtonOpenTable);
        OpenTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TournamentActivity.this, TableActivity.class);
                intent.putExtra(Constants.PLAYER_LIST_NAME, (Serializable) playerList);
                startActivity(intent);
            }
        });
    }
}
