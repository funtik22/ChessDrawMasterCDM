package ru.aomikhailov.chessdrawmastercdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateTournamentActivity extends AppCompatActivity {

    Button ButtonOpenMenuWithNumberOfTour;
    Button ButtonOpenMenuWithTypeOfTournament;
    Button ButtonNext;
    Button ButtonOpenMenuWithNumberOfPlayers;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_tournament);

        ButtonOpenMenuWithNumberOfPlayers = findViewById(R.id.NumberOfPlayer);
        ButtonOpenMenuWithTypeOfTournament = findViewById(R.id.Menubutton);
        ButtonOpenMenuWithNumberOfTour = findViewById(R.id.NumberOfTours);
        ButtonNext = findViewById(R.id.buttonNext);

        ButtonOpenMenuWithTypeOfTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {showPopupMenuWithTypeOfTournament(v);
            }
        });

        ButtonOpenMenuWithNumberOfPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenuWithNumberOfPlayers(v);
            }
        });

        ButtonOpenMenuWithNumberOfTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showPopupMenuWithNumberOfTours(v);
            }
        });

       ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateTournamentActivity.this, EnteringPlayersActivity.class);
                startActivity(intent);
            }
        });
    }


    private void showPopupMenuWithNumberOfPlayers(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        for(Integer i = 3; i<=21; i++){
            popupMenu.getMenu().add(1, R.id.menu1+i, i, i.toString());
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                for(Integer i = 3; i<=21; i++){
                    if(item.getItemId() == R.id.menu1+i){
                        ButtonOpenMenuWithNumberOfPlayers.setText(i.toString());
                        return true;
                    }
                }
                return false;
            }
        });
        popupMenu.show();

    }


    private void showPopupMenuWithNumberOfTours(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        for (Integer i = 1; i < 100; i++) {
            popupMenu.getMenu().add(1, R.id.menu1+i, i, i.toString());
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                for(Integer i = 1; i< 100; i++){
                    if(item.getItemId() == R.id.menu1+i){
                        ButtonOpenMenuWithNumberOfTour.setText(i.toString());
                        return true;
                    }
                }
                return false;
            }
        });
        popupMenu.show();
    }


            private void showPopupMenuWithTypeOfTournament(View v) {
                PopupMenu popupMenu = new PopupMenu(this, v);
                popupMenu.inflate(R.menu.populmenu);
                OnItemClickMenuWithTypeOfTournament(popupMenu);
                popupMenu.show();
            }

            private void OnItemClickMenuWithTypeOfTournament(PopupMenu popupMenu){
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Knockout and Swiss systems are in development
                        switch (item.getItemId()) {
                            case R.id.menu1:
                            case R.id.menu2:
                                Toast.makeText(getApplicationContext(), R.string.InWork, Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu3:
                                Toast.makeText(getApplicationContext(),
                                        R.string.RoundSystem,
                                        Toast.LENGTH_SHORT).show();
                                ButtonOpenMenuWithTypeOfTournament.setText(R.string.Round);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }

        }



