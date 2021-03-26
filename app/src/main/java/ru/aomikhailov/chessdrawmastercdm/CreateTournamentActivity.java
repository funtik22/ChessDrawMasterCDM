package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateTournamentActivity extends AppCompatActivity {

    Button ButtonNumberOfTours;
    Button MenuButton;
    Button NumberOfPlayer;
    ImageButton ButtonNext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_tournament);
        NumberOfPlayer = findViewById(R.id.NumberOfPlayer);
        MenuButton = findViewById(R.id.Menubutton);
        ButtonNumberOfTours = findViewById(R.id.NumberOfTours);
        ButtonNext = findViewById(R.id.Next);

        MenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenuWithTypeOfTournament(v);
            }
        });
        NumberOfPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenuWithNumberOfPlayer(v);
            }
        });
        ButtonNumberOfTours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenuWithNumberOfTours(v);
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
    private void showPopupMenuWithNumberOfTours(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        for(Integer i = 3; i<=21; i++){
            popupMenu.getMenu().add(1, R.id.menu1+i, i, i.toString());
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                for(Integer i = 3; i<=21; i++){
                    if(item.getItemId() == R.id.menu1+i){
                        ButtonNumberOfTours.setText(i.toString());
                        return true;
                    }
                }
                return false;
            }
        });
        popupMenu.show();

    }


    private void showPopupMenuWithNumberOfPlayer(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        for (Integer i = 1; i < 100; i++) {
            popupMenu.getMenu().add(1, R.id.menu1+i, i, i.toString());
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                for(Integer i = 1; i< 100; i++){
                    if(item.getItemId() == R.id.menu1+i){
                        NumberOfPlayer.setText(i.toString());
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

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.menu1:
                                        Toast.makeText(getApplicationContext(),
                                                "Вы выбрали Нокаут систему",
                                                Toast.LENGTH_SHORT).show();
                                        MenuButton.setText("Нокаут");
                                        return true;
                                    case R.id.menu2:
                                        Toast.makeText(getApplicationContext(),
                                                "Вы выбрали Швейцарскую систему",
                                                Toast.LENGTH_SHORT).show();
                                        MenuButton.setText("Швейцарская");
                                        return true;
                                    case R.id.menu3:
                                        Toast.makeText(getApplicationContext(),
                                                "Вы выбрали Круговую систему",
                                                Toast.LENGTH_SHORT).show();
                                        MenuButton.setText("Круговая");
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                popupMenu.show();

            }
        }



