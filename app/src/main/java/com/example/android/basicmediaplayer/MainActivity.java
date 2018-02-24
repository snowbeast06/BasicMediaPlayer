package com.example.android.basicmediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer = null;
    float leftVolume = (float) .5;
    float rightVolume = (float) .5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vivaldi_sonata);


        //mediaplayer oncompletion listener
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Completed!",Toast.LENGTH_SHORT).show();
            }
        });

        //listener for the play button
        Button playButton = (Button) findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent playIntent = new Intent();
                //
                    mediaPlayer.start();

            }
        });


        Button pauseButton = (Button) findViewById(R.id.pauseButton);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent playIntent = new Intent();
                //
                if (!(mediaPlayer == null)) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();

                    }
                }
            }
        });


        Button volumeUpButton = (Button) findViewById(R.id.volumeUpButton);

        volumeUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent playIntent = new Intent();
                //
                if (leftVolume < .9) {
                    leftVolume +=.1;
                    rightVolume+=.1;
                    mediaPlayer.setVolume(leftVolume,rightVolume);

                }
            }
        });



        Button volumeDownButton = (Button) findViewById(R.id.volumeDownButton);

        volumeDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent playIntent = new Intent();
                //
                if (leftVolume > .1) {
                    leftVolume  -=.1;
                    rightVolume -=.1;
                    mediaPlayer.setVolume(leftVolume,rightVolume);

                }
            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
        mediaPlayer = null;
    }


}
