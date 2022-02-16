package com.example.mvvmuno;

import android.app.Application;

import com.example.mvvmuno.data.database.MyDatabase;

public class MVVMUnoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MyDatabase.create(this);
    }
}
