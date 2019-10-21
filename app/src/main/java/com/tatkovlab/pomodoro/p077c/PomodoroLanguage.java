package com.tatkovlab.pomodoro.p077c;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.tatkovlab.pomodorolite.R;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tatkovlab.pomodoro.c.c */
public enum PomodoroLanguage {
    ENGLISH("en", R.string.native_lang_english),
    PORTUGUESE("pt", R.string.native_lang_portuguese),
    VIETNAMESE("vi", R.string.native_lang_vietnamese),
    TURKISH("tr", R.string.native_lang_turkish),
    RUSSIAN("ru", R.string.native_lang_russian),
    HINDI("hi", R.string.native_lang_hindi),
    THAI("th", R.string.native_lang_thai);


    /* renamed from: h */
    private static Map<String, PomodoroLanguage> languages;

    /* renamed from: i */
    private String f6555i;

    /* renamed from: j */
    private int f6556j;

    static {
        languages = null;
    }

    PomodoroLanguage(@NonNull String languageCode, @StringRes int languageNameResId) {
        this.f6555i = languageCode;
        this.f6556j = languageNameResId;
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
    public static PomodoroLanguage m10199a(String str) {
        PomodoroLanguage[] values;
        if (languages == null) {
            languages = new HashMap();
            for (PomodoroLanguage cVar : values()) {
                languages.put(cVar.mo7920a(), cVar);
            }
        }
        return languages.get(str);
    }
}
