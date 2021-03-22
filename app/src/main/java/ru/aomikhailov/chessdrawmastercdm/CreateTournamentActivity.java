package ru.aomikhailov.chessdrawmastercdm;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateTournamentActivity extends AppCompatActivity {

    Button MenuButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_tournament);

        MenuButton = findViewById(R.id.Menubutton);
        MenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }
            private void showPopupMenu(View v) {
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



