package com.example.salt.qrapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class IconsActivity extends AppCompatActivity
{
    FloatingIconService mService;
    boolean mBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        // Create an icon
        ImageView icon = new ImageView(this);
        icon.setImageResource(R.mipmap.ic_launcher);

       // final FloatingIconService FS = new FloatingIconService();





    }

    public void hope(Context context)
    {

          
            SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
            // repeat many times:
            ImageView itemIcon1 = new ImageView(this);
            itemIcon1.setImageResource(R.mipmap.ic_launcher);

            ImageView itemIcon2 = new ImageView(this);
            itemIcon2.setImageResource(R.mipmap.ic_launcher);

            ImageView itemIcon3 = new ImageView(this);
            itemIcon3.setImageResource(R.mipmap.ic_launcher);

            SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();
            SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();
            SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();

            //attach the sub buttons to the main button
            FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                    .addSubActionView(button1)
                    .addSubActionView(button2)
                    .addSubActionView(button3)
                    .attachTo(mService.floatingIconImage)
                    .build();


    }

    @Override
    protected void onStart()
    {
        super.onStart();
        // Bind to LocalService
        Intent intent = new Intent(this, FloatingIconService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        // Unbind from the service
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    /** Called when a button is clicked (the button in the layout file attaches to
     * this method with the android:onClick attribute) */



    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection()
    {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            FloatingIconService.LocalBinder binder = (FloatingIconService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0)
        {
            mBound = false;
        }
    };

}