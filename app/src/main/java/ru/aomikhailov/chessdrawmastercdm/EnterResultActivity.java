package ru.aomikhailov.chessdrawmastercdm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EnterResultActivity extends AppCompatActivity {

    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_result);
        final List<Player> playerList = (List<Player>) getIntent().getSerializableExtra(Constants.PLAYER_LIST_NAME);
        listView = findViewById(R.id.ListViewEnterResult);

        if(Tournament.tour != playerList.size()){
            MyEnterPlayerAdapter myEnterPlayerAdapter = new MyEnterPlayerAdapter(this, R.layout.adapter_item_enterresult, playerList);
            listView.setAdapter(myEnterPlayerAdapter);

        }

    }
}
