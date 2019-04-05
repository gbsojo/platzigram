package com.gbsojo.platzigram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gbsojo.platzigram.view.SignUpActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goSignUp(View view) {
        // Toast.makeText(getBaseContext(), R.string.sign_up, Toast.LENGTH_LONG);
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void login (View view) {
        Toast.makeText(getBaseContext(), R.string.login, Toast.LENGTH_LONG);
    }
}
