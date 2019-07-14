package com.example.alc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Profilepage extends AppCompatActivity {

    private Toolbar mTopToolbar;

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.profile_page);

        mTopToolbar = (Toolbar) findViewById(R.id.toolBar);

        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setTitle("My Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mTopToolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
