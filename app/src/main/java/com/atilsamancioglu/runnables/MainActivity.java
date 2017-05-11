package com.atilsamancioglu.runnables;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Handler handler;
    Runnable run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void start(View view) {
        textView = (TextView) findViewById(R.id.textView);

        number = 0;

        handler = new Handler();
        run = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " + number);
                number++;
                textView.setText("Time: " + number);
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run);

    }

    public void stop(View view) {
        handler.removeCallbacks(run);
        number = 0;

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Time: " + number);


    }

}
