package com.example.salt.qrapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by USER on 5/1/2017.
 */

public class Splashscreen extends Activity
{
    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    // Called when the Activity is created for the first time

    Thread splashThread;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        StartAnimation();
    }

    public void StartAnimation()
    {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim= AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashThread = new Thread()
        {
            @Override
            public void run()
            {
             try
             {
                int waited =0;
                 // Splash screen pause time
                 while (waited <8500)
                 {
                     sleep(100);
                     waited +=100;
                 }
                 Intent intent = new Intent(Splashscreen.this, RegisterActivity.class);
                 intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                 startActivity(intent);
                 Splashscreen.this.finish();
             }
             catch (InterruptedException e)
             {
                 //do nothing
             }
             finally
             {
                 Splashscreen.this.finish();

             }
            }
        };
        splashThread.start();
    }
}
