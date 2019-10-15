package com.tatkovlab.pomodoro.p078d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import androidx.appcompat.app.AlertDialog;

import com.tatkovlab.pomodoro.p077c.C2229c;
import com.tatkovlab.pomodoro.p083i.C2295b;
import com.tatkovlab.pomodorolite.R;
import java.util.Locale;

/* renamed from: com.tatkovlab.pomodoro.d.c */
public class C2238c {

    /* renamed from: a */
    private static final C2229c f6582a = C2229c.ENGLISH;

    /* renamed from: a */
    public static void m10222a(String str) {
        C2295b.m10461a(C2295b.f6707s, str);
    }

    /* renamed from: a */
    public static boolean m10223a() {
        return C2295b.m10458a(C2295b.f6707s) != null;
    }

    /* renamed from: b */
    public static String m10225b() {
        String str = (String) C2295b.m10458a(C2295b.f6707s);
        if (str != null) {
            return str;
        }
        String language = Locale.getDefault().getLanguage();
        return (language == null || language.equals("")) ? f6582a.mo7920a() : language;
    }

    /* renamed from: c */
    public static int m10226c() {
        return m10224b(m10225b());
    }

    /* renamed from: b */
    public static int m10224b(String str) {
        C2229c a = C2229c.m10199a(str);
        if (a == null) {
            a = f6582a;
        }
        return a.mo7921b();
    }

    /* renamed from: a */
    public static void m10221a(final Activity activity) {
        String b = m10225b();
        final C2229c[] values = C2229c.values();
        String[] strArr = new String[values.length];
        int i = 0;
        for (int i2 = 0; i2 < values.length; i2++) {
            String a = values[i2].mo7920a();
            strArr[i2] = activity.getResources().getString(m10224b(a));
            if (a.equals(b)) {
                i = i2;
            }
        }

//        AlertDialog aVar = new AlertDialog(activity, 2131755081);
//        aVar.mo2813a(R.string.language);
//        aVar.mo2821a(strArr, i, new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//                C2238c.m10222a(values[i].mo7920a());
//                activity.recreate();
//            }
//        });
//        aVar.mo2824b().show();

    }
}
