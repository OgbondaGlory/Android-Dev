package com.example.salt.qrapp;

/**
 * Created by USER on 4/20/2017.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.app.Application;
import android.app.Notification;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class Service extends ContextWrapper implements ComponentCallbacks2 {
    public static final int START_CONTINUATION_MASK = 15;
    public static final int START_FLAG_REDELIVERY = 1;
    public static final int START_FLAG_RETRY = 2;
    public static final int START_NOT_STICKY = 2;
    public static final int START_REDELIVER_INTENT = 3;
    public static final int START_STICKY = 1;
    public static final int START_STICKY_COMPATIBILITY = 0;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    public Service() {
        super((Context)null);
        throw new RuntimeException("Stub!");
    }

    public final Application getApplication() {
        throw new RuntimeException("Stub!");
    }

    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /** @deprecated */
    @Deprecated
    public void onStart(Intent intent, int startId) {
        throw new RuntimeException("Stub!");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        throw new RuntimeException("Stub!");
    }

    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    public void onConfigurationChanged(Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    public void onLowMemory() {
        throw new RuntimeException("Stub!");
    }

    public void onTrimMemory(int level) {
        throw new RuntimeException("Stub!");
    }

    public abstract IBinder onBind(Intent var1);

    public boolean onUnbind(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    public void onRebind(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    public void onTaskRemoved(Intent rootIntent) {
        throw new RuntimeException("Stub!");
    }

    public final void stopSelf() {
        throw new RuntimeException("Stub!");
    }

    public final void stopSelf(int startId) {
        throw new RuntimeException("Stub!");
    }

    public final boolean stopSelfResult(int startId) {
        throw new RuntimeException("Stub!");
    }

    public final void startForeground(int id, Notification notification) {
        throw new RuntimeException("Stub!");
    }

    public final void stopForeground(boolean removeNotification) {
        throw new RuntimeException("Stub!");
    }

    public final void stopForeground(int flags) {
        throw new RuntimeException("Stub!");
    }

    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }

    public Window getWindow() {
        throw new RuntimeException("Stub!");
    }
    public WindowManager getWindowManager() {
        throw new RuntimeException("Stub!");
    }
}

