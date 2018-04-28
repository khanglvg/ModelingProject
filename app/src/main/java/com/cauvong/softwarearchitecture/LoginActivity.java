package com.cauvong.softwarearchitecture;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth _auth;
    private EditText _edtEmail;
    private EditText _edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _auth = FirebaseAuth.getInstance();
        _edtEmail = findViewById(R.id.edt_email);
        _edtPassword = findViewById(R.id.edt_password);
    }

    public void firebaseAnonymousAuth(View view) {
        _auth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }
                        else {
                            // If sign in fails, display a message to the user.
                        }
                    }
                });
    }


    public void createAccount(View view)
    {
        if(!isEmpty())
        {
            _auth.createUserWithEmailAndPassword(_edtEmail.getText().toString(), _edtPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginActivity.this, "Create failed", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
        else
        {
            Toast.makeText(this, "Please, Check your email and password fields!", Toast.LENGTH_SHORT).show();
        }
    }


    public void signIn(View view)
    {
        if (!isEmpty()) {
            _auth.signInWithEmailAndPassword(_edtEmail.getText().toString(), _edtPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
        else
        {
            Toast.makeText(this, "Please, Check your email and password fields!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmpty()
    {
        return _edtEmail.getText().toString().equals("") || _edtPassword.getText().toString().equals("");
    }
}
