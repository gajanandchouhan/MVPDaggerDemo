package com.amiggo.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.ViewDebug;

import com.amiggo.data.api.ApiClient;
import com.amiggo.data.api.ApiInterface;
import com.amiggo.utils.ConstantLib;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Context getAppicationContext() {
        return application;
    }

    @Provides
    Application getApplication() {
        return application;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return application.getSharedPreferences(ConstantLib.PREF_NAME, Context.MODE_PRIVATE);
    }


}
