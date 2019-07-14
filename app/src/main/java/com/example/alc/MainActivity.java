package com.example.alc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTopToolbar;

    private Button about_btn, profile_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mTopToolbar);


        about_btn = (Button) findViewById(R.id.btn1);
        profile_btn = (Button) findViewById(R.id.btn2);


        about_btn.setOnClickListener(view -> startActivity(new Intent(this, AboutActivity.class)));

        profile_btn.setOnClickListener(view -> startActivity(new Intent(this, Profilepage.class)));
    }
}
