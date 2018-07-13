package com.lab.fadlikadn.advanceandroid.base;

import android.app.Application;

import com.lab.fadlikadn.advanceandroid.di.ActivityInjector;

import javax.inject.Inject;

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        component.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
