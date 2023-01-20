package com.example.salt.qrapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by USER on 4/25/2017.
 */

public class TransitionActivity extends AppCompatActivity
{
    Constants.TransitionType type;
    String toolbarTitle;
    EditText userName, password;
    Button login;
    Context c;

    @Override
    protected void onCreate( Bundle savedInstanceState)
    {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        intPage();
        intAnimation();



    }



    private void intPage()
    {
        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);


     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setTitle(toolbarTitle);


    }

    @Override
    @TargetApi(21)
    public boolean onSupportNavigateUp()
    {
        finishAfterTransition();
        return true;
    }
    @TargetApi(21)
    private void intAnimation()
    {
        switch (type)
        {

            case ExplodeJava:
                {
                    Explode enterTransition = new Explode();
                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
            case ExplodeXML:
                {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
        }
    }
}
