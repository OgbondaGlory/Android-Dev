package com.example.salt.qrapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ogaclejapan.arclayout.ArcLayout;


/**
 * Created by USER on 4/25/2017.
 */

public class MainActivity extends Activity implements View.OnClickListener
{

    ArcLayout arcLayout;




    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


//       fs.floatingIconImage.setId(R.id.floatingIconImage);

        setContentView(R.layout.activity_main);


     // fab = findViewById(fs.floatingIconImage.getId());

        arcLayout = (ArcLayout) findViewById(R.id.arc_layout);

        for (int i = 0, size = arcLayout.getChildCount(); i < size; i++)
        {
            arcLayout.getChildAt(i).setOnClickListener(this);
        }

    }


    @Override
    public void onClick(View v)
    {

    }
}
