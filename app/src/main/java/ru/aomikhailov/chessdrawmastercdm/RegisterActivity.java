package ru.aomikhailov.chessdrawmastercdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends AppCompatActivity {

    Button ButtonRegister;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    TextInputEditText edMail;
    TextInputEditText edPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        ButtonRegister = findViewById(R.id.buttonRegisterNow);
        edMail = findViewById(R.id.email);
        edPassword = findViewById(R.id.password);
        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration(edMail.getText().toString(), edPassword.getText().toString());

            }
        });
    }

    public void registration (String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, R.string.RgSus, Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(RegisterActivity.this, R.string.Warnings, Toast.LENGTH_LONG).show();
            }
        });
    }
}
