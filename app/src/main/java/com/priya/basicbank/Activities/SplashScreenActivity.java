package com.priya.basicbank.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.priya.basicbank.R;

public class SplashScreenActivity extends AppCompatActivity {
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        pbar=findViewById(R.id.progressBar);
        Handler handler = new Handler();
        handler.postDelayed(() -> {

            Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
            pbar.setVisibility(View.GONE);
            finish();
        },2500);

    }
}
