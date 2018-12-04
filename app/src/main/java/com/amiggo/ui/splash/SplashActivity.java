package com.amiggo.ui.splash;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.amiggo.AmiggosApp;
import com.amiggo.di.component.DaggerActivityComponent;
import com.amiggo.di.module.AcitivityModule;
import com.amiggo.ui.main.MainActivity;
import com.amiggo.R;
import com.amiggo.base.BaseActivity;
import com.amiggo.ui.walkthrough.WalkThroughActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter.takeView(this);
        presenter.delaySplashScreen();
    }

    @Override
    protected void intilizeDiComponent() {
        DaggerActivityComponent.builder().applicationComponent(AmiggosApp.getApplication(this).getApplicationComponent()).acitivityModule(new AcitivityModule(this)).build().inject(this);
    }

    @Override
    public void startNextActivity() {
        startActivity(new Intent(this, WalkThroughActivity.class));
        finish();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    protected void onDestroy() {
        presenter.dropView();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }
}
