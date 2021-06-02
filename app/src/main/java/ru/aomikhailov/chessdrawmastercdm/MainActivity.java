package ru.aomikhailov.chessdrawmastercdm;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

   Button ButtonContinueWithoutLogin ;
   Button ButtonRegister;
   Button ButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButtonContinueWithoutLogin = findViewById(R.id.buttonContinueWithoutLogin);
        ButtonRegister = findViewById(R.id.buttonRegister);
        ButtonLogin = findViewById(R.id.buttonLogin);

        ButtonContinueWithoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartScreenActivity.class);
                startActivity(intent);
            }
        });

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.InWork, Toast.LENGTH_SHORT).show();
            }
        });
    }
}