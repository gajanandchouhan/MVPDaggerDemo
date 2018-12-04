package com.amiggo;

import android.app.Application;
import android.content.Context;

import com.amiggo.data.api.ApiClient;
import com.amiggo.data.local.SharedPrefHelper;
import com.amiggo.di.component.ApplicationComponent;
import com.amiggo.di.component.DaggerApplicationComponent;
import com.amiggo.di.module.ApplicationModule;

import javax.inject.Inject;

public class AmiggosApp extends Application {
    @Inject
    SharedPrefHelper sharedPrefHelper;

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent=DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
    }

    public static AmiggosApp getApplication(Context context){
        return (AmiggosApp) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
