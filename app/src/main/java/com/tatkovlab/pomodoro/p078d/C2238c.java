package com.tatkovlab.pomodoro.p078d;

import android.app.Activity;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.tatkovlab.pomodoro.p077c.PomodoroLanguage;
import com.tatkovlab.pomodoro.p083i.PrefManager;
import com.tatkovlab.pomodorolite.R;

import java.util.Locale;

/* renamed from: com.tatkovlab.pomodoro.d.c */
public class C2238c {

    /* renamed from: a */
    private static final PomodoroLanguage defaultLanguage = PomodoroLanguage.ENGLISH;

    /* renamed from: a */
    public static void m10222a(String str) {
        PrefManager.save(PrefManager.PRESELECTED_LANG, str);
    }

    /* renamed from: a */
    public static boolean m10223a() {
        return PrefManager.getValue(PrefManager.PRESELECTED_LANG) != null;
    }

    /* renamed from: b */
    public static String m10225b() {
        String str = PrefManager.getValue(PrefManager.PRESELECTED_LANG);
        if (str != null) {
            return str;
        }
        String language = Locale.getDefault().getLanguage();
        return language.equals("") ? defaultLanguage.mo7920a() : language;
    }

    /* renamed from: c */
    public static int m10226c() {
        return m10224b(m10225b());
    }

    /* renamed from: b */
    public static int m10224b(String str) {
        PomodoroLanguage a = PomodoroLanguage.m10199a(str);
        if (a == null) {
            a = defaultLanguage;
        }
        return a.mo7921b();
    }

    /* renamed from: a */
    public static void showLanguageChooserDialog(final Activity activity) {
        String b = m10225b();
        final PomodoroLanguage[] values = PomodoroLanguage.values();
        String[] strArr = new String[values.length];
        int currentLanguageIndex = 0;
        for (int i = 0; i < values.length; i++) {
            String a = values[i].mo7920a();
            strArr[i] = activity.getResources().getString(m10224b(a));
            if (a.equals(b)) {
                currentLanguageIndex = i;
            }
        }

        AlertDialog alertDialog = new AlertDialog.Builder(activity).setTitle(R.string.language)
                .setSingleChoiceItems(strArr, currentLanguageIndex, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        C2238c.m10222a(values[i].mo7920a());
                        activity.recreate();
                    }
                })
                .create();

        alertDialog.show();
    }
}
