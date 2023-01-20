package com.example.salt.qrapp;

/**
 * Created by USER on 4/2/2017.
 */

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

import java.util.Random;

public class FloatingIconService extends Service
{
    private WindowManager windowManager;
    public ImageView floatingIconImage;
    private Context mContext;
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenerator = new Random();



    public class LocalBinder extends Binder
    {
        FloatingIconService getService()
        {
            // Return this instance of LocalService so clients can call public methods
            return FloatingIconService.this;
        }
    }

    public void onCreate()
    {
        super.onCreate();
        floatingIconImage = new ImageView(this);



       // FloatingIconService actionButton = new FloatingIconService.Builder(this)
             //   .build();
        //a face floating bubble as imageView
        floatingIconImage.setImageResource(R.drawable.floatqr);

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        //here is all the science of params
        final LayoutParams myParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.TYPE_PHONE,
                LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);


        myParams.gravity = Gravity.TOP | Gravity.LEFT;
        myParams.x = 0;
        myParams.y = 100;
        // add a floatingIconImage icon in window
        windowManager.addView(floatingIconImage, myParams);

        try {
            //for moving the picture on touch and slide
            floatingIconImage.setOnTouchListener(new View.OnTouchListener()
            {
                LayoutParams paramsT = myParams;
                private int initialX;
                private int initialY;
                private float initialTouchX;
                private float initialTouchY;
                private long touchStartTime = 0;

                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    //remove face bubble on long press
                    if (System.currentTimeMillis() - touchStartTime > ViewConfiguration.getLongPressTimeout() && initialTouchX == event.getX()) {
                        windowManager.removeView(floatingIconImage);
                        //stopSelf();
                        return false;

                    }
                    switch (event.getAction())
                    {


                        case MotionEvent.ACTION_DOWN:
                            touchStartTime = System.currentTimeMillis();
                            initialX = myParams.x;
                            initialY = myParams.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            break;
                        case MotionEvent.ACTION_UP:
                            break;
                        case MotionEvent.ACTION_MOVE:

                            myParams.x = initialX + (int) (event.getRawX() - initialTouchX);
                            myParams.y = initialY + (int) (event.getRawY() - initialTouchY);
                            windowManager.updateViewLayout(v, myParams);
                            break;
                    }
                    return false;
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        floatingIconImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(FloatingIconService.this, MainActivity.class);
                startActivity(i);
            }
        });





    }



    @TargetApi(21)
    public void explodeTransitionByCode(View view)
    {
        Activity context;
        context = (Activity) this.mContext;
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(context);
        Intent i = new Intent(FloatingIconService.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
        i.putExtra(Constants.KEY_TITLE, "Explode Test");
        startActivity(i, options.toBundle());
    }

    @TargetApi(21)
    public void explodeTransitionByXML(View view)
    {
        Activity context;
        context = (Activity) this.mContext;
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(context);
        Intent i = new Intent(FloatingIconService.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
        i.putExtra(Constants.KEY_TITLE, "Explode XML");
        startActivity(i, options.toBundle());
    }



    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (floatingIconImage != null)
            windowManager.removeView(floatingIconImage);
    }


    @Override
    public IBinder onBind(Intent intent)
    {
        // TODO Auto-generated method stub
        return mBinder;
    }

    /**
     * method for clients
     */
    public int getRandomNumber()
    {
        return mGenerator.nextInt(100);
    }

    public static class Builder
    {
        private Service service;
        private int theme;
        private Drawable backgroundDrawable;
        private int position;
        private View contentView;

        public Builder(Service service)
        {
            this.service = service;

        }




    }



}