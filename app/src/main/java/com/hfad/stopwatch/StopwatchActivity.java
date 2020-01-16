package com.hfad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private int seconds =0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
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

        int hours = seconds/3600;
        int minutes = (seconds%3600)/60;
        int secs = seconds%60;
        String time = String.format("%d:%02d:%02d",hours,minutes,secs);
        timeView.setText(time);
        if(running)
            seconds++;
        

    }
}
