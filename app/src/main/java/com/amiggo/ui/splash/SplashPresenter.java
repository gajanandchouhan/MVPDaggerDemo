package com.amiggo.ui.splash;

import android.os.Handler;

import javax.inject.Inject;

public class SplashPresenter implements SplashContract.Presenter {

    SplashContract.View view;
    Handler handler;
    Runnable runnable;

    @Inject
    public SplashPresenter() {
    }

    @Override
    public void delaySplashScreen() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                view.startNextActivity();
            }
        };
        handler.postDelayed(runnable, 3000);

    }

    @Override
    public void dropView() {
        view = null;
        handler.removeCallbacks(runnable);
    }

    @Override
    public void takeView(SplashContract.View view) {
        this.view = view;
    }
}
