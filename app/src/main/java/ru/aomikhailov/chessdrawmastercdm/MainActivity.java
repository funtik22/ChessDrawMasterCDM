package ru.aomikhailov.chessdrawmastercdm;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public  class MainActivity extends AppCompatActivity {

    ImageButton WithoutLogin ;
    ImageButton Register;
    ImageButton Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WithoutLogin = findViewById(R.id.ButtonWithOutLogin);
        Register = findViewById(R.id.register);
        Login =  findViewById(R.id.login);
        WithoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartScreenActivity.class);
                startActivity(intent);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    /*public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, StartScreenActivity.class);
        startActivity(intent);
    }*/
}