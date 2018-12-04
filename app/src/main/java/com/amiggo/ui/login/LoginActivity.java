package com.amiggo.ui.login;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amiggo.AmiggosApp;
import com.amiggo.R;
import com.amiggo.base.BaseActivity;
import com.amiggo.data.api.ApiInterface;
import com.amiggo.data.local.SharedPrefHelper;
import com.amiggo.di.component.DaggerActivityComponent;
import com.amiggo.di.module.AcitivityModule;
import com.amiggo.ui.dialog.selectiondialog.SelectionListDialog;
import com.amiggo.utils.Log;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private LinearLayout layoutFacebook;
    private LinearLayout layoutInstagram;
    private LinearLayout layoutGoogle;
    private TextView textViewLanguage;
    private SelectionListDialog listDailog;

    @Inject
    LoginPresenter presenter;

    @Inject
    SharedPrefHelper sharedPrefHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        layoutFacebook = findViewById(R.id.layout_facebook);
        layoutInstagram = findViewById(R.id.layout_instagram);
        textViewLanguage = findViewById(R.id.text_view_language);
        layoutGoogle = findViewById(R.id.layout_google);
        layoutFacebook.setOnClickListener(this);
        layoutGoogle.setOnClickListener(this);
        layoutInstagram.setOnClickListener(this);
        textViewLanguage.setOnClickListener(this);
        GradientDrawable backgroundInstagram = (GradientDrawable) layoutInstagram.getBackground();
        GradientDrawable backgroundFacebook = (GradientDrawable) layoutFacebook.getBackground();
        GradientDrawable backgroundGoogle = (GradientDrawable) layoutGoogle.getBackground();
        backgroundFacebook.setColor(ContextCompat.getColor(this, R.color.colorFacebook));
        backgroundInstagram.setColor(ContextCompat.getColor(this, R.color.colorInstagram));
        backgroundGoogle.setColor(ContextCompat.getColor(this, R.color.colorGoogle));

    }

    @Override
    protected void intilizeDiComponent() {
        DaggerActivityComponent.builder().applicationComponent(AmiggosApp.getApplication(this).getApplicationComponent()).acitivityModule(new AcitivityModule(this)).build().inject(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_language:
                showLanguagePicker();
                break;
        }

    }

    private void showLanguagePicker() {
        if (listDailog == null) {
            final String[] stringArray = getResources().getStringArray(R.array.languages);
            List<String> list = Arrays.asList(stringArray);
            listDailog = new SelectionListDialog(this, list, new SelectionListDialog.SelectedListner<String>() {
                @Override
                public void onSelected(int position, String object) {
                    textViewLanguage.setText(object);

                }
            });
            listDailog.setTitle(getString(R.string.select_language));
        }
        listDailog.show();
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
