package com.gbsojo.platzigram.view;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gbsojo.platzigram.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.showToolbar(getResources().getString(R.string.title_sign_up), true);
    }

    @SuppressLint("RestrictedApi")
    public void showToolbar (String title, boolean showUpButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showUpButton);
    }

    public void doSignUp (View view) {
    }
}
