package com.tatkovlab.pomodoro.p083i;

/* renamed from: com.tatkovlab.pomodoro.i.d */
public class C2298d {
    /* renamed from: a */
    public static String m10468a(long j) {
        String str;
        String str2;
        long j2 = j % 60;
        long j3 = (j / 60) % 60;
        long j4 = (j / 3600) % 24;
        if (j2 < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("0");
            sb.append(j2);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(j2);
            str = sb2.toString();
        }
        if (j3 < 10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j3);
            str2 = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("");
            sb4.append(j3);
            str2 = sb4.toString();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(j4);
        String sb6 = sb5.toString();
        if (j4 > 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append(":");
            sb7.append(str2);
            sb7.append(":");
            sb7.append(str);
            return sb7.toString();
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append(str2);
        sb8.append(":");
        sb8.append(str);
        return sb8.toString();
    }
}
