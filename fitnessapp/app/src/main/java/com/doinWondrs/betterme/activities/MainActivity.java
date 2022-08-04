package com.doinWondrs.betterme.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.doinWondrs.betterme.R;

import com.doinWondrs.betterme.helpers.GoToNav;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //field declaration
    private SurfaceView surfaceView;
    private MediaPlayer player;
    private SurfaceHolder holder;

    private GoToNav gotoHelper = new GoToNav();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navGoTo();
    }








    //Bottom Navbar: NOTE: to link new activity just create a new switch cases and use new intents
    //EXCEPT if you are at workoutpagefirst.java then you dont need to do anything just break out of switch case.
    public void navGoTo()
    {
        //NOTES: https://www.geeksforgeeks.org/how-to-implement-bottom-navigation-with-activities-in-android/
        //NOTES: bottomnavbar is deprecated: https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView.OnNavigationItemSelectedListener

        //initialize, instantiate
        NavigationBarView navigationBarView;//new way to do nav's but more research needed
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //set home selected: home
        bottomNavigationView.setSelectedItemId(R.id.home_nav);
        //perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_nav:
                        //we are here right now
                        break;
                    case R.id.calendar_nav:
                        startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.gps_nav:
                        startActivity(new Intent(getApplicationContext(), GPSActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.workouts_nav:
                        startActivity(new Intent(getApplicationContext(), WorkoutPageFirst.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.settings_nav:
                        startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    default: return false;// this is to cover all other cases if not working properly
                }

                return true;
            }
        });//end lambda: bottomNavview
    }//end method: navGoTo

}//end class:

