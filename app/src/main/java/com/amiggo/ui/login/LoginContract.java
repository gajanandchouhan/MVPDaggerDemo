package com.amiggo.ui.login;

import com.amiggo.base.BasePresenter;
import com.amiggo.base.BaseView;

import java.util.HashMap;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void onLoginSuccess();
    }

    interface Presenter extends BasePresenter<View> {
        void loginWithSocialMedia(HashMap<String,String> body);
    }
}
