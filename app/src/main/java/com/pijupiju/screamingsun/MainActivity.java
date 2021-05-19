package com.pijupiju.screamingsun;

import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    Vibrator vibrator;
    Button btnVibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btnVibrate = findViewById(R.id.btnVibrate);
        btnVibrate.setOnClickListener(view -> {
            if (hour < 5 || hour > 7) {
                vibrator.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
            } else if (hour == 5) {
                vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
            } else if (hour == 6) {
                vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 200, 100, 200}, -1));
            } else {
                vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 200, 100, 200, 100, 200}, -1));
            }
        });
    }
}