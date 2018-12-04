package com.amiggo.di.module;

import android.app.Activity;

import com.amiggo.ui.login.LoginContract;
import com.amiggo.ui.login.LoginPresenter;
import com.amiggo.ui.splash.SplashActivity;
import com.amiggo.ui.splash.SplashContract;
import com.amiggo.ui.splash.SplashPresenter;
import com.amiggo.ui.walkthrough.WalkthroughAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class AcitivityModule {
    private Activity activity;

    public AcitivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    SplashContract.Presenter provideSplashPresenter() {
        return new SplashPresenter();
    }

    @Provides
    WalkthroughAdapter provideWalkThoruhAdapter() {
        return new WalkthroughAdapter(activity);
    }

    @Provides
    LoginContract.Presenter provideLoginPresenter() {
        return new LoginPresenter();
    }
}
