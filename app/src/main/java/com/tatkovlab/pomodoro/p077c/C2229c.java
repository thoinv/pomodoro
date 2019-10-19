package com.tatkovlab.pomodoro.p077c;

import com.tatkovlab.pomodorolite.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tatkovlab.pomodoro.c.c */
public enum C2229c {
    ENGLISH("en", R.string.native_lang_english),
    PORTUGUESE("pt", R.string.native_lang_portuguese),
    VIETNAMESE("vi", R.string.native_lang_vietnamese),
    TURKISH("tr", R.string.native_lang_turkish),
    RUSSIAN("ru", R.string.native_lang_russian),
    HINDI("hi", R.string.native_lang_hindi),
    THAI("th", R.string.native_lang_thai);
    

    /* renamed from: h */
    private static Map<String, C2229c> f6553h;

    /* renamed from: i */
    private String f6555i;

    /* renamed from: j */
    private int f6556j;

    static {
        f6553h = null;
    }

    C2229c(String str, int i) {
        this.f6555i = str;
        this.f6556j = i;
    }

    /* renamed from: a */
    public String mo7920a() {
        return this.f6555i;
    }

    /* renamed from: b */
    public int mo7921b() {
        return this.f6556j;
    }

    /* renamed from: a */
    public static C2229c m10199a(String str) {
        C2229c[] values;
        if (f6553h == null) {
            f6553h = new HashMap();
            for (C2229c cVar : values()) {
                f6553h.put(cVar.mo7920a(), cVar);
            }
        }
        return f6553h.get(str);
    }
}
