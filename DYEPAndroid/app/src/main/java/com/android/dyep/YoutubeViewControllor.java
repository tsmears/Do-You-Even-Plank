package com.android.dyep;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class YoutubeViewControllor extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_view);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33CCFF")));
        getSupportActionBar().setTitle("youtube title");
    //    getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);

    }
}
