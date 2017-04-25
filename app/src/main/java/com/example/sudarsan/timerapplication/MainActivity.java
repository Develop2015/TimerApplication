package com.example.sudarsan.timerapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds =0;  //number of seconds displayed on the timer
    private boolean running;  // is the timer running

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();

    }

    // start the timer running when the start button is clicked
    public void onClickStart(View view) {
        running = true;
    }

    //stop the timer running when the stop button is clicked
    public void onClickStop(View view) {
        running=false;
    }

    //Reset the timer when the reset button is clicked
    public void onClickReset(View view) {
        running=false;
        seconds= 0;
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view) ;

        final Handler handler = new Handler();


        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds%3600) / 60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                seconds++;
            }
            // handler.postDelayed(Runnable, long);
            handler.postDelayed(this,1000);
        }
        });
}
}
