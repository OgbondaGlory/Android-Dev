package com.example.salt.qrapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SALT on 1/31/2017.
 */
public class LoginActivity extends AppCompatActivity
{
    Constants.TransitionType type;
    String toolbarTitle;
    EditText userName, password;
    Button login;
    Context c;
    @Override
    protected  void onCreate (Bundle savedInstanceState)
    {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intPage();
        intAnimation();
        c=this;



        userName = (EditText) findViewById(R.id.etUserName);
        password = (EditText) findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.btLogin);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String str_userName = userName.getText().toString();
                String str_password = password.getText().toString();

                if (str_userName.length() == 0 & str_password.length() == 0)
                {
                    Toast.makeText(c,"Username and Password are required!!!", Toast.LENGTH_LONG) .show();
                    return;

                }
                else
                    if (str_userName.length() != 0 & str_password.length()== 0)
                    {
                        Toast.makeText(c,"Password cannot be left blank!!!", Toast.LENGTH_LONG) .show();
                        return;
                    }
                else
                        if (str_userName.length() ==0 & str_password.length()!=0)
                        {
                            Toast.makeText(c,"Username cannot be left blank!!!", Toast.LENGTH_LONG) .show();
                            return;
                        }
                else

                            {
                               Intent intent = new Intent(LoginActivity.this, FloatingIconService.class);
                                startService(intent);

                                finish();
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(0);

                               // Intent intent = new Intent(LoginActivity.this, DemoLikePathActivity.class);
                              //  startActivity(intent);

                            }

            }
        });
    }

    private void intPage()
    {
        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);


       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
