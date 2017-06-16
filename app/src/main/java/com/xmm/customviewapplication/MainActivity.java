package com.xmm.customviewapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ViscosityView viscosityView;
    private static final int PULL_MAX = 600;

    private float startY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        startY = event.getY();
                        return true;
                    case MotionEvent.ACTION_HOVER_MOVE:
                        float y = event.getY();
                        if(y >= startY){
                            y = y-PULL_MAX;
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        });



    }
}
