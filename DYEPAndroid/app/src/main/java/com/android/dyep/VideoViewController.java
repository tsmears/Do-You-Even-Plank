package com.android.dyep;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VideoViewController extends ActionBarActivity {

    Button plank;
    TextView youtube_title;

    public void init(){
        plank = (Button) findViewById(R.id.plank_btn);
        plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plank = new Intent(VideoViewController.this,YoutubeViewControllor.class);
                startActivity(plank);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        youtube_title = (TextView) findViewById(R.id.youtube_title);
        youtube_title.setText("Video:");

        init();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_icon);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
    }
}
