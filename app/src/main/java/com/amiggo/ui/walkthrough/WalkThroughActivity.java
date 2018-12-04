package com.amiggo.ui.walkthrough;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.amiggo.AmiggosApp;
import com.amiggo.R;
import com.amiggo.base.BaseActivity;
import com.amiggo.custom.CirclePageIndicator;
import com.amiggo.di.component.DaggerActivityComponent;
import com.amiggo.di.module.AcitivityModule;
import com.amiggo.ui.login.LoginActivity;

import javax.inject.Inject;

public class WalkThroughActivity extends BaseActivity {

    private ViewPager pager;
    private CirclePageIndicator indicator;
    @Inject
    WalkthroughAdapter walkthroughAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);
        findViewById(R.id.button_get_started).setOnClickListener(this);
        pager = findViewById(R.id.pager);
        indicator = findViewById(R.id.indicator);
        pager.setAdapter(walkthroughAdapter);
        indicator.setViewPager(pager);
    }

    @Override
    protected void intilizeDiComponent() {
        DaggerActivityComponent.builder().applicationComponent(AmiggosApp.getApplication(this).getApplicationComponent()).acitivityModule(new AcitivityModule(this)).build().inject(this);
        // DaggerWalkthroughComponent.builder().applicationComponent(AmiggosApp.getApplication(this).getApplicationComponent())..build().inject(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_get_started:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }

    }
}
