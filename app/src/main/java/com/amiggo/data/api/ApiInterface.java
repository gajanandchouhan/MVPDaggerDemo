package com.amiggo.data.api;


import com.amiggo.data.model.BaseReponse;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by JAIN COMPUTERS on 11/18/2017.
 */

public interface ApiInterface {

    @POST("loginWithSocialMedia")
    Observable<BaseReponse> loginWithSocialMedia(@Body HashMap body);
}