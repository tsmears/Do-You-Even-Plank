package com.android.dyep;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class ContentViewController extends ActionBarActivity{

    Button sports;

    public void init(){
        sports = (Button) findViewById(R.id.sports_btn);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sports = new Intent(ContentViewController.this,VideoViewController.class);
                startActivity(sports);
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);

        Intent first = getIntent();


        init();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_icon);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
    }

}

