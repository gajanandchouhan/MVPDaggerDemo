package com.amiggo.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;

public class CommonUtils {


    public static void showListDialog(String title,String arr[], Context context, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        dialog.setSingleChoiceItems(arr, 0, listener);
        dialog.show();
    }

    public static int getScreenWidth(Context mContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }
}
