package ru.aomikhailov.chessdrawmastercdm;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EnterResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_result);
        final List<Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);

    }
}
