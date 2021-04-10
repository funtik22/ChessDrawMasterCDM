package ru.aomikhailov.chessdrawmastercdm;


import android.content.Intent;
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
     public ArrayList <Player> plList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entering_players);

        ButtonCreateTournament1 = findViewById(R.id.ButtonCreateTournament2);
        ListPlayers = findViewById(R.id.ListPlayers);
        AddPlayers = findViewById(R.id.ButtonAdd);
        PlayersName = findViewById(R.id.editTextPlayerName);
        wdaawd = findViewById(R.id.textView7);

        ArrayAdapter <Player> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, plList);
        ListPlayers.setAdapter(adapter);

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
    public void OnAsw(String name) {

    }
}
