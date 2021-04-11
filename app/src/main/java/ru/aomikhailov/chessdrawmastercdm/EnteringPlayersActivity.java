package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EnteringPlayersActivity extends AppCompatActivity implements DialogAddPlayers.OnAsw {

    ImageButton ButtonCreateTournament1;
    ListView ListPlayers;
    ImageButton AddPlayers;
    EditText PlayersName;
    TextView wdaawd;
    DataBasePlayersManager myDbManager;
    String [] players ;
    ArrayList<String> arrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entering_players);

        ButtonCreateTournament1 = findViewById(R.id.ButtonCreateTournament2);
        ListPlayers = findViewById(R.id.ListPlayers);
        AddPlayers = findViewById(R.id.ButtonAdd);
        PlayersName = findViewById(R.id.editTextPlayerName);
        wdaawd = findViewById(R.id.textView7);
        myDbManager = new DataBasePlayersManager(this);


       // ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, players);


        ButtonCreateTournament1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnteringPlayersActivity.this, TournamentActivity.class);
                startActivity(intent);
            }
        });


        AddPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAddPlayers dialog = new DialogAddPlayers();
                dialog.show(getSupportFragmentManager(), "custom");
            }
        });
    }

    protected void OnResume(){
        super.onResume();
        myDbManager.openDb();
    }

    @Override
    public void OnAsw(String name, String surname, String patronymic, Integer YearOfBirth) {
        myDbManager.openDb();
        myDbManager.insertToDb(name, surname, patronymic, YearOfBirth);
        if(myDbManager.NumEntries() == 0){
            players = new String[1];
        }
        else{
            players = new String[myDbManager.NumEntries()];
        }
        int i = 0;
        for(String names : myDbManager.getFromDb()){
           players[i] = names;
           i++;
        }
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, players);
        ListPlayers.setAdapter(adapter);

    }

    public  void OnDestroy(){
        super.onDestroy();
        myDbManager.closeDb();
    }
}
