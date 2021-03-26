package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartScreenActivity extends AppCompatActivity {


    ImageButton CreateTournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
        CreateTournament = findViewById(R.id.ButtonCreateTournament);
        CreateTournament.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenActivity.this, CreateTournamentActivity.class);
                startActivity(intent);
            }
        });
    }
}