package com.android.dyep;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends ActionBarActivity {

    ActionBarDrawerToggle toggle;

    Button first_btn;   //0:30 button

    public void init(){
        first_btn = (Button) findViewById(R.id.first_btn);
        first_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(MainActivity.this,ContentViewController.class);
                startActivity(first);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        try{
            loadSheet();
        }catch (Exception e){

        }




        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.history) {
                    Intent history = new Intent(MainActivity.this,HistoryViewControllor.class);
                    startActivity(history);
                } else if (id == R.id.support) {
                    Intent support = new Intent(MainActivity.this,SupportViewControllor.class);
                    startActivity(support);
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
                drawer.openDrawer(GravityCompat.START);
                return true;
            }
        });


//---slide menu and action bar icon--------------
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_icon);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void loadSheet() throws Exception{
        final String USER_AGENT = "Mozilla/5.0";
        String urlString = "https://spreadsheets.google.com/feeds/list/16HjsPso7jGQRJXP2Dnn_1maux0Oye_Vpr6bJzWSAsTY/1/public/values?alt=json";

        URL url = new URL(urlString);



        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
    //    con.setRequestProperty("User-Agent", USER_AGENT);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jo = new JSONObject(response.toString());
        JSONArray resultarr = jo.getJSONArray("results");

        System.out.println(resultarr);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        if(toggle.onOptionsItemSelected(menuItem)){

            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }


}
