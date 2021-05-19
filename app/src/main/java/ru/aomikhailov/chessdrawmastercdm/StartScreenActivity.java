package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartScreenActivity extends AppCompatActivity {


    Button ButtonCreateTournament;
    Button ButtonOpenTournament;
    Button ButtonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);

        ButtonCreateTournament = findViewById(R.id.buttonCreateTournament);
        ButtonOpenTournament = findViewById(R.id.buttonOpenTournament);
        ButtonSettings = findViewById(R.id.buttonSettings);

        ButtonCreateTournament.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenActivity.this, CreateTournamentActivity.class);
                startActivity(intent);
            }
        });

        ButtonOpenTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.InWork, Toast.LENGTH_SHORT).show();
            }
        });

        ButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.InWork, Toast.LENGTH_SHORT).show();
            }
        });
    }
}