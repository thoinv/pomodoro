package com.tatkovlab.pomodoro.p083i;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.tatkovlab.pomodorolite.R;

import java.util.Locale;

public class AppRateUtils {

    public static void checkAndUpdateFirstLaunchTime(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("key_app_rater", 0);
        if (sharedPreferences.getBoolean("key_dont_show_again", false)) {
            return;
        }

        Editor edit = sharedPreferences.edit();
        edit.putLong("key_launch_count", sharedPreferences.getLong("key_launch_count", 0) + 1);
        if (sharedPreferences.getLong("key_date_firstlaunch", 0) == 0) {
            edit.putLong("key_date_firstlaunch", System.currentTimeMillis());
        }
        edit.apply();
    }

    public static long getFirstLaunchTime(Context context, long j) {
        return context.getSharedPreferences("key_app_rater", 0).getLong("key_date_firstlaunch", j);
    }

    public static void checkAndShowRateIfNeed(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("key_app_rater", 0);
        if (!sharedPreferences.getBoolean("key_dont_show_again", false)) {
            long j = sharedPreferences.getLong("key_launch_count", 0);
            long valueOf = sharedPreferences.getLong("key_date_firstlaunch", System.currentTimeMillis());
            if (j >= 7 && System.currentTimeMillis() >= valueOf + 259200000 && isConnected(context)) {
                showRateDialog(context, sharedPreferences.edit());
            }
        }
    }

    public static void showRateDialog(final Context context, final Editor editor) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(R.string.rating_dialog_title)
                .setIcon(R.drawable.ic_heart_red)
                .setMessage(R.string.rating_dialog_body)
                .setCancelable(true)
                .setPositiveButton(R.string.rating_dialog_positive_btn, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (editor != null) {
                            editor.putBoolean("key_dont_show_again", true);
                            editor.commit();
                        }
                        String sb = String.format(Locale.US, "market://details?id=%s", context.getPackageName());
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb)));
                        Toast.makeText(context, context.getString(R.string.thank_you_for_5_stars), Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton(R.string.rating_dialog_neutral_btn, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (editor != null) {
                            editor.putLong("key_launch_count", 0);
                            editor.commit();
                        }
                        dialogInterface.dismiss();
                    }
                }).setNeutralButton(R.string.rating_dialog_negative_btn, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (editor != null) {
                            editor.putBoolean("key_dont_show_again", true);
                            editor.commit();
                        }
                        dialogInterface.dismiss();
                    }
                }).create();
        dialog.show();
    }

    private static boolean isConnected(Context context) {
        @SuppressLint("WrongConstant") NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
