package com.lab.fadlikadn.advanceandroid.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lab.fadlikadn.advanceandroid.di.Injector;

import java.util.UUID;

public class BaseActivity extends AppCompatActivity {

    private static String INSTANCE_ID_KEY = "instance_id";

    private String instanceId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    public String getInstanceId() {
        return instanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
    }
}
