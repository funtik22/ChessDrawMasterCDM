package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.provider.SyncStateContract.*;

public class EnteringPlayersActivity extends AppCompatActivity implements DialogAddPlayers.OnAsw {

    Button ButtonCreateTournament;
    Button ButtonAddPlayer;
    Button ButtonDeletePlayer;
    DataBasePlayersManager myDbManager;
    String [] players ;
    List<Player> playerArrayList = new ArrayList<>();
    ArrayList<String> PlayerToAddOrDelete = new ArrayList<>();
    ListView ListPlayers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entering_players);
        getSupportActionBar().hide();
        ButtonDeletePlayer = findViewById(R.id.buttonDeletePlayer);
        ButtonCreateTournament = findViewById(R.id.buttonCreateTournamentNow);
        ButtonAddPlayer = findViewById(R.id.buttonAddPlayers);
        ListPlayers = findViewById(R.id.ListPlayers);
        myDbManager = new DataBasePlayersManager(this);

        ButtonCreateTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePlayerList();
                Intent intent = new Intent(EnteringPlayersActivity.this, TournamentActivity.class);
                intent.putExtra(Constants.PLAYER_LIST_NAME, (Serializable) playerArrayList);
                startActivity(intent);
            }
        });

        ButtonAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAddPlayers dialog = new DialogAddPlayers();
                dialog.show(getSupportFragmentManager(), "custom");
            }
        });

        // A list of players is created to be removed from the database or added to the tournament
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

        ButtonDeletePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDbManager.openDb();
                for(int i = 0; i<PlayerToAddOrDelete.size(); i++){
                   myDbManager.delete(PlayerToAddOrDelete.get(i));
                }
                CreateAdapter2();
                PlayerToAddOrDelete.clear();
                myDbManager.closeDb();
            }
        });

        myDbManager.openDb();
        if(myDbManager.NumEntries() != 0){
            players = new String[myDbManager.NumEntries()];
            int i = 0;
            for (String names : myDbManager.getNameFromDb()) {
                players[i] = names;
                i++;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, players);
            ListPlayers.setAdapter(adapter);
        }
        myDbManager.closeDb();
    }

    public void CreatePlayerList() {
        myDbManager.openDb();
        Collections.sort(PlayerToAddOrDelete);
        playerArrayList = myDbManager.getFromDbPlayers(PlayerToAddOrDelete);
        myDbManager.closeDb();
    }

    @Override
    public void OnAsw(String name, String surname, String patronymic, Integer YearOfBirth, Integer rating) {
        myDbManager.openDb();
        myDbManager.insertToDb(name, surname, patronymic, YearOfBirth, rating);
        CreateAdapter();
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
        for(String names : myDbManager.getNameFromDb()){
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
            for (String names : myDbManager.getNameFromDb()) {
                players[i] = names;
                i++;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, players);
            ListPlayers.setAdapter(adapter);
        }
    }
}
