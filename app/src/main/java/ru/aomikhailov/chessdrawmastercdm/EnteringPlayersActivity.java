package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EnteringPlayersActivity extends AppCompatActivity implements DialogAddPlayers.OnAsw {

    ImageButton ButtonCreateTournament1;
    ListView ListPlayers;
    ImageButton AddPlayers;
    EditText PlayersName;
    DataBasePlayersManager myDbManager;
    String [] players ;
    ArrayList<Player> playerArrayList = new ArrayList<>();
    ArrayList<String> PlayerToAddOrDelete = new ArrayList<>();
    ImageButton DeletePlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entering_players);
        DeletePlayer = findViewById(R.id.DeletePlayer);
        ButtonCreateTournament1 = findViewById(R.id.ButtonCreateTournament2);
        ListPlayers = findViewById(R.id.ListPlayers);
        AddPlayers = findViewById(R.id.ButtonAdd);
        PlayersName = findViewById(R.id.editTextPlayerName);
        myDbManager = new DataBasePlayersManager(this);

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


        ListPlayers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray chosen = ((ListView) parent).getCheckedItemPositions();
                for (int i = 0; i < chosen.size(); i++) {
                    if (chosen.valueAt(i)) {
                        PlayerToAddOrDelete.add(players[chosen.keyAt(i)]);
                    }
                }
            }
        });

        DeletePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDbManager.openDb();
                for(int i = 0; i<PlayerToAddOrDelete.size(); i++){
                   myDbManager.delete(PlayerToAddOrDelete.get(i));

                }
               // CreateAdapter();
                CreateAdapter2();
                PlayerToAddOrDelete.clear();
                myDbManager.closeDb();
            }
        });


        myDbManager.openDb();
        if(myDbManager.NumEntries() == 0){
        }
        else {
            players = new String[myDbManager.NumEntries()];

            int i = 0;
            for (String names : myDbManager.getFromDb()) {
                players[i] = names;
                i++;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, players);
            ListPlayers.setAdapter(adapter);

        }
        myDbManager.closeDb();
    }


    protected void OnResume(){
        super.onResume();
        myDbManager.openDb();
    }


    @Override
    public void OnAsw(String name, String surname, String patronymic, Integer YearOfBirth) {
        myDbManager.openDb();
        myDbManager.insertToDb(name, surname, patronymic, YearOfBirth);
        CreateAdapter();
        myDbManager.closeDb();

    }


    public  void OnDestroy(){
        super.onDestroy();
        myDbManager.closeDb();
    }


    public void CreateAdapter(){
        if(myDbManager.NumEntries() == 0){
            players = new String[1];
        }
        else{
            ListPlayers.setVisibility(View.VISIBLE);
            players = new String[myDbManager.NumEntries()];
        }
        int i = 0;
        for(String names : myDbManager.getFromDb()){
            players[i] = names;
            i++;
        }
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, players);
        ListPlayers.setAdapter(adapter);
    }
    public void CreateAdapter2(){
        if(myDbManager.NumEntries() == 0) {
            ListPlayers.setVisibility(View.INVISIBLE);

        }
        else {
            ListPlayers.setVisibility(View.VISIBLE);
            players = new String[myDbManager.NumEntries()];

            int i = 0;
            for (String names : myDbManager.getFromDb()) {
                players[i] = names;
                i++;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, players);
            ListPlayers.setAdapter(adapter);
        }
    }

}
