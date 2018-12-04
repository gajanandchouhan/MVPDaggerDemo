package com.amiggo.ui.splash;

import com.amiggo.base.BasePresenter;
import com.amiggo.base.BaseView;

public interface SplashContract {
    interface View extends BaseView<Presenter>{
      void startNextActivity();
    }

    interface Presenter extends BasePresenter<View>{
        void delaySplashScreen();
    }
}
