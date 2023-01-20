package com.example.salt.qrapp;

/**
 * Created by USER on 5/3/2017.
 */

import android.content.Context;

import com.ogaclejapan.arclayout.Arc;

public enum Demo {

    //Basic

    //Advanced

    ADVANCED_PATH(R.string.app_name, 0, 0, null) {
       // @Override
        public void startActivity(Context context) {
            DemoLikePathActivity.startActivity(context, this);
        }
    };

    public final int titleResId;
    public final int noteResId;
    public final int layoutResId;
    public final Arc arc;

    Demo(int titleResId, int noteResId, int layoutResId, Arc arc) {
        this.titleResId = titleResId;
        this.noteResId = noteResId;
        this.layoutResId = layoutResId;
        this.arc = arc;
    }

 //   public void startActivity(Context context) {
  //      DemoActivity.startActivity(context, this);
  //  }

}
