package com.amiggo.di.component;

import com.amiggo.AmiggosApp;
import com.amiggo.data.local.SharedPrefHelper;
import com.amiggo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(AmiggosApp amiggosApp);
    SharedPrefHelper getSharedPrefHelper();
}
