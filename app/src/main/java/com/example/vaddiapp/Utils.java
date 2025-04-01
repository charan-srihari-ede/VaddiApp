package com.example.vaddiapp;

import android.app.ProgressDialog;
import android.content.Context;

public class Utils {
    private static ProgressDialog progressDialog;

    // Show loading dialog
    public static void showLoading(Context context, String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(false);
            progressDialog.setMessage(message);
        }
        progressDialog.show();
    }

    // Hide loading dialog
    public static void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
