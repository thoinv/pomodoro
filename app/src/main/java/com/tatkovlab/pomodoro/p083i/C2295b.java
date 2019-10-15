package com.tatkovlab.pomodoro.p083i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import android.util.Log;
import com.tatkovlab.pomodoro.p081g.C2271e.C2274c;

/* renamed from: com.tatkovlab.pomodoro.i.b */
public class C2295b {

    /* renamed from: a */
    public static final C2296a<Long> f6689a = new C2296a<>("APP_INSTALL_TIME", Long.class, Long.valueOf(0));

    /* renamed from: b */
    public static final C2296a<Long> f6690b = new C2296a<>("TIMER_STARTED_TIME", Long.class, Long.valueOf(0));

    /* renamed from: c */
    public static final C2296a<Long> f6691c = new C2296a<>("TIMER_DURATION_IN_MILLIS", Long.class, Long.valueOf(0));

    /* renamed from: d */
    public static final C2296a<Integer> f6692d = new C2296a<>("ringSoundTag", Integer.class, Integer.valueOf(30));

    /* renamed from: e */
    public static final C2296a<Integer> f6693e = new C2296a<>("tickingTag", Integer.class, Integer.valueOf(50));

    /* renamed from: f */
    public static final C2296a<Boolean> f6694f = new C2296a<>("isVibrationTag", Boolean.class, Boolean.valueOf(false));

    /* renamed from: g */
    public static final C2296a<Boolean> f6695g = new C2296a<>("keepScreenOnTag", Boolean.class, Boolean.valueOf(false));

    /* renamed from: h */
    public static final C2296a<Integer> f6696h = new C2296a<>("shortBreakTag", Integer.class, Integer.valueOf(2));

    /* renamed from: i */
    public static final C2296a<Integer> f6697i = new C2296a<>("longBreakTag", Integer.class, Integer.valueOf(1));

    /* renamed from: j */
    public static final C2296a<Integer> f6698j = new C2296a<>("pomodoroDurationIndex", Integer.class, Integer.valueOf(2));

    /* renamed from: k */
    public static final C2296a<Integer> f6699k = new C2296a<>("RINGING_SOUND_INDEX", Integer.class, Integer.valueOf(0));

    /* renamed from: l */
    public static final C2296a<Integer> f6700l = new C2296a<>("TICKING_SOUND_INDEX", Integer.class, Integer.valueOf(0));

    /* renamed from: m */
    public static final C2296a<String> f6701m = new C2296a<>("CURRENT_TASK_NAME", String.class, null);

    /* renamed from: n */
    public static final C2296a<Integer> f6702n = new C2296a<>("CURRENT_TASK_COUNT", Integer.class, Integer.valueOf(0));

    /* renamed from: o */
    public static final C2296a<Integer> f6703o = new C2296a<>("CURRENT_POMODORO_STATE", Integer.class, Integer.valueOf(-1));

    /* renamed from: p */
    public static final C2296a<Integer> f6704p = new C2296a<>("NEXT_POMODORO_STATE", Integer.class, Integer.valueOf(C2274c.POMODORO.mo8007a()));

    /* renamed from: q */
    public static final C2296a<Integer> f6705q = new C2296a<>("LONG_BREAK_COUNTER_COMPLETED_POMODOROS", Integer.class, Integer.valueOf(0));

    /* renamed from: r */
    public static final C2296a<Long> f6706r = new C2296a<>("LONG_BREAK_COUNTER_LAST_COMPLETED_POMODORO", Long.class, Long.valueOf(0));

    /* renamed from: s */
    public static final C2296a<String> f6707s = new C2296a<>("PRESELECTED_LANG", String.class, null);

    /* renamed from: t */
    public static final C2296a<Boolean> f6708t = new C2296a<>("WAS_WELCOME_SCREEN_SHOWN", Boolean.class, Boolean.valueOf(false));

    /* renamed from: u */
    private static final C2296a<Integer> f6709u = new C2296a<>("PREFS_VERSION", Integer.class, Integer.valueOf(0));

    /* renamed from: v */
    private static SharedPreferences f6710v;

    /* renamed from: com.tatkovlab.pomodoro.i.b$a */
    public static class C2296a<T> {

        /* renamed from: a */
        private String f6711a;

        /* renamed from: b */
        private Class<T> f6712b;

        /* renamed from: c */
        private T f6713c;

        public C2296a(String str, Class<T> cls, T t) {
            this.f6711a = str;
            this.f6712b = cls;
            this.f6713c = t;
        }

        /* renamed from: a */
        public String mo8031a() {
            return this.f6711a;
        }

        /* renamed from: b */
        public Class<T> mo8032b() {
            return this.f6712b;
        }

        /* renamed from: c */
        public T mo8033c() {
            return this.f6713c;
        }
    }

    /* renamed from: a */
    public static void m10460a(Context context) {
        f6710v = PreferenceManager.getDefaultSharedPreferences(context);
        m10462b(context);
        m10459a();
    }

    /* renamed from: b */
    private static void m10462b(Context context) {
        long j;
        if (((Long) m10458a(f6689a)).longValue() == 0) {
            try {
                j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                j = System.currentTimeMillis();
            }
            m10461a(f6689a, Long.valueOf(j));
        }
    }

    /* renamed from: a */
    private static void m10459a() {
        int intValue = m10458a(f6709u).intValue();
        if (intValue == 0) {
            m10461a(f6709u, Integer.valueOf(2));
            intValue = 2;
        }
        if (intValue < 2) {
            if (intValue < 2) {
                m10461a(f6708t, Boolean.valueOf(true));
            }
            m10461a(f6709u, Integer.valueOf(2));
        }
    }

    /* renamed from: a */
    public static <T> T m10458a(C2296a<T> aVar) {
        if (aVar.mo8032b() == Boolean.class) {
            return aVar.mo8032b().cast(Boolean.valueOf(f6710v.getBoolean(aVar.mo8031a(), ((Boolean) aVar.mo8033c()).booleanValue())));
        }
        if (aVar.mo8032b() == String.class) {
            return aVar.mo8032b().cast(f6710v.getString(aVar.mo8031a(), (String) aVar.mo8033c()));
        }
        if (aVar.mo8032b() == Integer.class) {
            return aVar.mo8032b().cast(Integer.valueOf(f6710v.getInt(aVar.mo8031a(), ((Integer) aVar.mo8033c()).intValue())));
        }
        if (aVar.mo8032b() == Long.class) {
            return aVar.mo8032b().cast(Long.valueOf(f6710v.getLong(aVar.mo8031a(), ((Long) aVar.mo8033c()).longValue())));
        }
        throw new IllegalArgumentException("Unsupported key class");
    }

    /* renamed from: a */
    public static <T> void m10461a(C2296a<T> aVar, T t) {
        Editor edit = f6710v.edit();
        try {
            if (aVar.mo8032b() == Boolean.class) {
                edit.putBoolean(aVar.mo8031a(), ((Boolean) t).booleanValue());
            } else if (aVar.mo8032b() == String.class) {
                edit.putString(aVar.mo8031a(), (String) t);
            } else if (aVar.mo8032b() == Integer.class) {
                edit.putInt(aVar.mo8031a(), ((Integer) t).intValue());
            } else if (aVar.mo8032b() == Long.class) {
                edit.putLong(aVar.mo8031a(), ((Long) t).longValue());
            } else {
                throw new IllegalArgumentException("Unsupported key class key");
            }
        } catch (Exception e) {
            Log.e("Prefs writing failed", e.toString());
        }
        edit.apply();
    }
}
