package com.pijupiju.screamingsun;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR);
        Log.d(TAG, "current hour: " + hour);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        Handler handler = new Handler(Looper.getMainLooper());
        btn1.setOnClickListener(view -> {
            handler.postDelayed(() -> vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE)), 200);
            handler.postDelayed(() -> vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE)), 500);
            handler.postDelayed(() -> vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE)), 1000);
        });

        btn2.setOnClickListener(view -> vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE)));
        btn3.setOnClickListener(view -> vibrator.vibrate(VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE)));
        btn4.setOnClickListener(view -> vibrator.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE)));
        btn5.setOnClickListener(view -> vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)));
    }
}