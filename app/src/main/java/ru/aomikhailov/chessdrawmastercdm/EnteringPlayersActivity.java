package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.Objects;


public class EnteringPlayersActivity extends AppCompatActivity implements DialogAddPlayers.OnAsw {

    ImageButton ButtonCreateTournament1;
    ListView ListPlayers;
    ImageButton AddPlayers;
    EditText PlayersName;
    TextView wdaawd;

     public ArrayList <Player> plList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entering_players);
        ButtonCreateTournament1 = findViewById(R.id.ButtonCreateTournament2);
        ListPlayers = findViewById(R.id.ListPlayers);
        AddPlayers = findViewById(R.id.ButtonAdd);
        PlayersName = findViewById(R.id.editTextPlayerName);
        wdaawd = findViewById(R.id.textView7);



      //  final String[] PlayersList = new String[]{"sefsef","wrfwaf","sef"};//для теста



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

    @Override
    public void OnAsw(String name) {
        wdaawd.setText(name);
    }

    //Player pl = new Player(PlayersName.getText().toString(), "","",234,234,324f,false);



}
