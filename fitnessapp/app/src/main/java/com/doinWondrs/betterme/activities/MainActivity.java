package com.doinWondrs.betterme.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
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


        delayIcon();
        navGoTo();
//        renderBackground();
        renderBackground2();
    }





    private void delayIcon()
    {
        ImageView iconDelayer = findViewById(R.id.iconMainActivity);
        int imagePath = R.drawable.icon1;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iconDelayer.setImageResource(imagePath);

            }
        }, 2000);
    }


//    private void renderBackground()
//    {
//        final VideoView videoView = (VideoView) findViewById(R.id.videoBackground1);
//        final String videopath = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.workout_intro).toString();
//        videoView.setVideoPath(videopath);
//        videoView.start();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.start();
//                mediaPlayer.setLooping(true);
//            }
//        });
//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer)
//            {
//                videoView.setVideoPath(videopath);
//                videoView.start();
//            }
//        });
//    }

    private void renderBackground2()
    {

        //NOTES :  https://developpaper.com/android-uses-surfaceview-mediaplayer-to-play-video/
        //NOTES : https://itecnote.com/tecnote/java-full-screen-videoview-without-stretching-the-video/
        surfaceView = (SurfaceView) findViewById(R.id.videoBackground1);
        player = new MediaPlayer();
        try {
            player.setDataSource(this, Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.workout_intro) );
            holder= surfaceView.getHolder();
            holder.addCallback(new MyCallBack());
            player.prepare();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {


                    // so it fits on the screen
                    int videoWidth = player.getVideoWidth();
                    int videoHeight = player.getVideoHeight();
                    float videoProportion = (float) videoWidth / (float) videoHeight;
                    int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
                    int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
                    float screenProportion = (float) screenWidth / (float) screenHeight;
                    android.view.ViewGroup.LayoutParams lp = surfaceView.getLayoutParams();

                    if (videoProportion > screenProportion) {
                        lp.width = (1) * videoWidth;
                        lp.height = (1/2) * videoWidth;
//                        lp.width = screenWidth;
//                        lp.height = (int) ((float) screenWidth / videoProportion);
                    } else {
                        lp.width = (int) (videoProportion * (float) screenHeight);
                        lp.height = screenHeight;
                    }
                    surfaceView.setLayoutParams(lp);

                    player.start();
                    player.setLooping(true);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

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
    private class MyCallBack implements SurfaceHolder.Callback{

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            player.setDisplay(holder);
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        }
    }//END: class MyCallback - implements sufaceholder.callback
}//end class:

