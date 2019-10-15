package com.tatkovlab.pomodoro.p078d;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

public class C2236b {

    private static Map<C2237a, Typeface> f6577a = new HashMap();
    public enum C2237a {
        LATO_BOLD("Lato-Bold.ttf"),
        PANGOLIN_REGULAR("Pangolin-Regular.ttf");
        

        /* renamed from: c */
        private String f6581c;

        private C2237a(String str) {
            this.f6581c = str;
        }

        /* renamed from: a */
        public String mo7934a() {
            return this.f6581c;
        }
    }

    /* renamed from: a */
    public static void m10219a(TextView textView, C2237a aVar) {
        textView.setTypeface(m10218a(aVar, textView.getContext()));
    }

    /* renamed from: a */
    private static Typeface m10218a(C2237a aVar, Context context) {
        Typeface typeface = (Typeface) f6577a.get(aVar);
        if (typeface != null) {
            return typeface;
        }
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), aVar.mo7934a());
        f6577a.put(aVar, createFromAsset);
        return createFromAsset;
    }
}
