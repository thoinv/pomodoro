package com.tatkovlab.pomodoro.p083i;

import java.util.Locale;

public class C2298d {
    public static String m10468a(long j) {
        String str;
        String str2;
        long j2 = j % 60;
        long j3 = (j / 60) % 60;
        long j4 = (j / 3600) % 24;
        if (j2 < 10) {
            str = String.format(Locale.US, "0%d", j2);
        } else {
            str = "" + j2;
        }
        if (j3 < 10) {
            str2 = String.format(Locale.US, "0%d", j3);
        } else {
            str2 = "" + j3;
        }
        String sb6 = "" + j4;
        if (j4 > 0) {
            return String.format("%s:%s:%s", sb6, str2, str);
        }
        return String.format("%s:%s", str2, str);
    }
}
