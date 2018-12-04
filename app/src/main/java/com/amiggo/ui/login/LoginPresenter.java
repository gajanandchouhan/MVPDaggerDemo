package com.amiggo.ui.login;

import com.amiggo.data.api.ApiClient;
import com.amiggo.data.api.ApiInterface;
import com.amiggo.data.model.BaseReponse;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    private final ApiInterface apiInterface;
    LoginContract.View view;
    CompositeDisposable compositeDisposable;

    @Inject
    public LoginPresenter() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void dropView() {
        view = null;
        compositeDisposable.clear();
    }

    @Override
    public void takeView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void loginWithSocialMedia(HashMap<String, String> body) {
        Observable<BaseReponse> response = apiInterface.loginWithSocialMedia(body);
        DisposableObserver<BaseReponse> disposableObserver = response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeWith(new DisposableObserver<BaseReponse>() {
            @Override
            public void onNext(BaseReponse o) {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        compositeDisposable.add(disposableObserver);
    }
}
