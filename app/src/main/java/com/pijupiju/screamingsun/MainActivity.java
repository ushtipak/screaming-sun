package com.pijupiju.screamingsun;

import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = findViewById(R.id.cl);
        constraintLayout.setOnClickListener(v -> {
            vibe();
        });
    }

    private void vibe() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        if (hour < 5 || hour > 7) {
            vibrator.vibrate(VibrationEffect.createOneShot(5, VibrationEffect.DEFAULT_AMPLITUDE));
        } else if (hour == 5) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else if (hour == 6) {
            vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 200, 100, 200}, -1));
        } else {
            vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 200, 100, 200, 100, 200}, -1));
        }
    }
}