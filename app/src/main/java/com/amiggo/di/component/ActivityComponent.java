package com.amiggo.di.component;

import com.amiggo.di.ActivityScope;
import com.amiggo.di.module.AcitivityModule;
import com.amiggo.ui.login.LoginActivity;
import com.amiggo.ui.splash.SplashActivity;
import com.amiggo.ui.walkthrough.WalkThroughActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = AcitivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity splashActivity);

    void inject(WalkThroughActivity walkThroughActivity);

    void inject(LoginActivity loginActivity);
}
