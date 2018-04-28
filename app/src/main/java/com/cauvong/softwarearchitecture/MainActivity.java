package com.cauvong.softwarearchitecture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cauvong.softwarearchitecture.MVC.Views.ChatView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView _txtUserName;
    private FirebaseAuth _auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _auth = FirebaseAuth.getInstance();
        FirebaseUser user = _auth.getCurrentUser();

        _txtUserName = findViewById(R.id.txt_username);

        try {
            if(user.isAnonymous())
                _txtUserName.setText("Anonymous");
            _txtUserName.setText(user.getUid());
        }
        catch(NullPointerException e)
        {
            _txtUserName.setText("");
        }
    }

    public void goToMVP(View view) {
        Intent mvpIntent = new Intent(MainActivity.this, com.cauvong.softwarearchitecture.MVP.Views.ChatView.class);
        startActivity(mvpIntent);
    }

    public void goToMVC(View view) {
        Intent mvpIntent = new Intent(MainActivity.this, ChatView.class);
        startActivity(mvpIntent);
    }


    public void goToMVVM(View view) {
        Intent mvpIntent = new Intent(MainActivity.this, com.cauvong.softwarearchitecture.MVVM.Views.ChatView.class);
        startActivity(mvpIntent);
    }
}
