package ru.aomikhailov.chessdrawmastercdm;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity  {

   Button ButtonContinueWithoutLogin ;
   Button ButtonRegister;
   Button ButtonLogin;
   TextInputEditText edEmail;
    TextInputEditText edPassword;
   private FirebaseAuth mAuth;
   private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButtonContinueWithoutLogin = findViewById(R.id.buttonContinueWithoutLogin);
        ButtonRegister = findViewById(R.id.buttonRegister);
        ButtonLogin = findViewById(R.id.buttonLogin);
        mAuth = FirebaseAuth.getInstance();
        edEmail = findViewById(R.id.email1);
        edPassword = findViewById(R.id.password1);


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
                signing(edEmail.getText().toString(), edPassword.getText().toString());
            }
        });
    }
    public void signing(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, StartScreenActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, R.string.ZaRg, Toast.LENGTH_LONG).show();
            }
        });

    }

}

