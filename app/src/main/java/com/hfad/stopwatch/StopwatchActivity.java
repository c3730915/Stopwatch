package com.hfad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private int seconds =0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }
    //Start the stopwatch running when Start button is clicked
    public void onClickStart(View view)
    {
        running = true;

    }

    //Stop the stopwatch running when the Stop button is clicked
    public void onClickStop(View view)
    {
        running = false;

    }

    //Reset the stopwatch when the Reset button is clicked
    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    private void runTimer()
    {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running)
                    seconds++;
                handler.postDelayed(this,1000); //Post the code in the runnable to be run again after a delay of 1 second,
                // as this line of code is included in the Runnable run() method, this will keep getting called.

            }

        });



    }


}
