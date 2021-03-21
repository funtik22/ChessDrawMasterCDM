package ru.aomikhailov.chessdrawmastercdm;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateTournamentActivity extends AppCompatActivity {

    ImageButton MenuButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_tournament);

        MenuButton = findViewById(R.id.MenuButton);
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
                                                "Вы выбрали PopupMenu 1",
                                                Toast.LENGTH_SHORT).show();
                                        return true;
                                    case R.id.menu2:
                                        Toast.makeText(getApplicationContext(),
                                                "Вы выбрали PopupMenu 2",
                                                Toast.LENGTH_SHORT).show();
                                        return true;
                                    case R.id.menu3:
                                        Toast.makeText(getApplicationContext(),
                                                "Вы выбрали PopupMenu 3",
                                                Toast.LENGTH_SHORT).show();
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });

                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {
                        Toast.makeText(getApplicationContext(), "onDismiss",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                popupMenu.show();
            }
        }



