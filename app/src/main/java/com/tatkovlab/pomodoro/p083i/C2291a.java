package com.tatkovlab.pomodoro.p083i;

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
import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.i.a */
public class C2291a {
    /* renamed from: a */
    public static void m10454a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("key_app_rater", 0);
        if (!sharedPreferences.getBoolean("key_dont_show_again", false)) {
            Editor edit = sharedPreferences.edit();
            edit.putLong("key_launch_count", sharedPreferences.getLong("key_launch_count", 0) + 1);
            if (Long.valueOf(sharedPreferences.getLong("key_date_firstlaunch", 0)).longValue() == 0) {
                edit.putLong("key_date_firstlaunch", Long.valueOf(System.currentTimeMillis()).longValue());
            }
            edit.commit();
        }
    }

    /* renamed from: a */
    public static long m10453a(Context context, long j) {
        return context.getSharedPreferences("key_app_rater", 0).getLong("key_date_firstlaunch", j);
    }

    /* renamed from: b */
    public static void m10456b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("key_app_rater", 0);
        if (!sharedPreferences.getBoolean("key_dont_show_again", false)) {
            long j = sharedPreferences.getLong("key_launch_count", 0);
            Long valueOf = Long.valueOf(sharedPreferences.getLong("key_date_firstlaunch", System.currentTimeMillis()));
            if (j >= 7 && System.currentTimeMillis() >= valueOf.longValue() + 259200000 && m10457c(context)) {
                m10455a(context, sharedPreferences.edit());
            }
        }
    }

    /* renamed from: a */
    public static void m10455a(final Context context, final Editor editor) {
        C0787a aVar = new C0787a(context, 2131755081);
        aVar.mo2813a((int) R.string.rating_dialog_title).mo2825c(R.drawable.ic_heart_red).mo2822b(R.string.rating_dialog_body).mo2820a(true).mo2814a((int) R.string.rating_dialog_positive_btn, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (editor != null) {
                    editor.putBoolean("key_dont_show_again", true);
                    editor.commit();
                }
                Context context = context;
                StringBuilder sb = new StringBuilder();
                sb.append("market://details?id=");
                sb.append(context.getPackageName());
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                Toast.makeText(context, context.getString(R.string.thank_you_for_5_stars), 1).show();
                dialogInterface.dismiss();
            }
        }).mo2826c(R.string.rating_dialog_neutral_btn, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (editor != null) {
                    editor.putLong("key_launch_count", 0);
                    editor.commit();
                }
                dialogInterface.dismiss();
            }
        }).mo2823b(R.string.rating_dialog_negative_btn, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (editor != null) {
                    editor.putBoolean("key_dont_show_again", true);
                    editor.commit();
                }
                dialogInterface.dismiss();
            }
        });
        aVar.mo2824b().show();
    }

    /* renamed from: c */
    public static boolean m10457c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
