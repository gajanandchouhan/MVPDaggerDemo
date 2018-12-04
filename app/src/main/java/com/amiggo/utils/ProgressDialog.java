package com.amiggo.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;

import com.amiggo.R;

import javax.inject.Inject;

public class ProgressDialog extends Dialog {

    @Inject
    public ProgressDialog(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.progress_dialog);
    }


}
