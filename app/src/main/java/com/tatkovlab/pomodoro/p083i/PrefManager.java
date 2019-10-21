package com.tatkovlab.pomodoro.p083i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import android.util.Log;
import com.tatkovlab.pomodoro.p081g.C2271e.C2274c;

public class PrefManager {

    public static final PreferenceValueObject<Long> APP_INSTALL_TIME = new PreferenceValueObject<>("APP_INSTALL_TIME", Long.class, 0L);

    public static final PreferenceValueObject<Long> TIMER_STARTED_TIME = new PreferenceValueObject<>("TIMER_STARTED_TIME", Long.class, 0L);

    public static final PreferenceValueObject<Long> TIMER_DURATION_IN_MILLIS = new PreferenceValueObject<>("TIMER_DURATION_IN_MILLIS", Long.class, 0L);

    public static final PreferenceValueObject<Integer> ringSoundTags = new PreferenceValueObject<>("ringSoundTag", Integer.class, 30);

    public static final PreferenceValueObject<Integer> tickingTag = new PreferenceValueObject<>("tickingTag", Integer.class, 50);

    public static final PreferenceValueObject<Boolean> isVibrationTag = new PreferenceValueObject<>("isVibrationTag", Boolean.class, Boolean.FALSE);

    public static final PreferenceValueObject<Boolean> keepScreenOnTag = new PreferenceValueObject<>("keepScreenOnTag", Boolean.class, Boolean.FALSE);

    public static final PreferenceValueObject<Integer> shortBreakTag = new PreferenceValueObject<>("shortBreakTag", Integer.class, 2);

    public static final PreferenceValueObject<Integer> longBreakTag = new PreferenceValueObject<>("longBreakTag", Integer.class, 1);

    public static final PreferenceValueObject<Integer> pomodoroDurationIndex = new PreferenceValueObject<>("pomodoroDurationIndex", Integer.class, 2);

    public static final PreferenceValueObject<Integer> RINGING_SOUND_INDEX = new PreferenceValueObject<>("RINGING_SOUND_INDEX", Integer.class, 0);

    public static final PreferenceValueObject<Integer> TICKING_SOUND_INDEX = new PreferenceValueObject<>("TICKING_SOUND_INDEX", Integer.class, 0);

    public static final PreferenceValueObject<String> CURRENT_TASK_NAME = new PreferenceValueObject<>("CURRENT_TASK_NAME", String.class, null);

    public static final PreferenceValueObject<Integer> CURRENT_TASK_COUNT = new PreferenceValueObject<>("CURRENT_TASK_COUNT", Integer.class, 0);

    public static final PreferenceValueObject<Integer> CURRENT_POMODORO_STATE = new PreferenceValueObject<>("CURRENT_POMODORO_STATE", Integer.class, -1);

    public static final PreferenceValueObject<Integer> NEXT_POMODORO_STATE = new PreferenceValueObject<>("NEXT_POMODORO_STATE", Integer.class, C2274c.POMODORO.mo8007a());

    public static final PreferenceValueObject<Integer> LONG_BREAK_COUNTER_COMPLETED_POMODOROS = new PreferenceValueObject<>("LONG_BREAK_COUNTER_COMPLETED_POMODOROS", Integer.class, 0);

    public static final PreferenceValueObject<Long> LONG_BREAK_COUNTER_LAST_COMPLETED_POMODORO = new PreferenceValueObject<>("LONG_BREAK_COUNTER_LAST_COMPLETED_POMODORO", Long.class, 0L);

    public static final PreferenceValueObject<String> PRESELECTED_LANG = new PreferenceValueObject<>("PRESELECTED_LANG", String.class, null);

    public static final PreferenceValueObject<Boolean> WAS_WELCOME_SCREEN_SHOWN = new PreferenceValueObject<>("WAS_WELCOME_SCREEN_SHOWN", Boolean.class, Boolean.FALSE);

    private static final PreferenceValueObject<Integer> PREFS_VERSION = new PreferenceValueObject<>("PREFS_VERSION", Integer.class, 0);

    private static SharedPreferences sharedPreferences;

    public static class PreferenceValueObject<T> {

        private String name;

        private Class<T> objectClass;

        private T defaultValue;

        public PreferenceValueObject(String name, Class<T> objectClass, T defaultValue) {
            this.name = name;
            this.objectClass = objectClass;
            this.defaultValue = defaultValue;
        }

        public String getName() {
            return this.name;
        }

        public Class<T> getObjectClass() {
            return this.objectClass;
        }

        public T getDefaultValue() {
            return this.defaultValue;
        }
    }

    public static void init(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        saveInstalledTimeIfNeed(context);
        m10459a();
    }

    private static void saveInstalledTimeIfNeed(Context context) {
        long j;
        if (getValue(APP_INSTALL_TIME) == 0) {
            try {
                j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                j = System.currentTimeMillis();
            }
            save(APP_INSTALL_TIME, j);
        }
    }

    private static void m10459a() {
        int intValue = getValue(PREFS_VERSION);
        if (intValue == 0) {
            save(PREFS_VERSION, 2);
            intValue = 2;
        }
        if (intValue < 2) {
            save(WAS_WELCOME_SCREEN_SHOWN, Boolean.TRUE);
            save(PREFS_VERSION, 2);
        }
    }

    public static <T> T getValue(PreferenceValueObject<T> preferenceValueObject) {
        if (preferenceValueObject.getObjectClass() == Boolean.class) {
            return preferenceValueObject.getObjectClass().cast(sharedPreferences.getBoolean(preferenceValueObject.getName(), (Boolean) preferenceValueObject.getDefaultValue()));
        }
        if (preferenceValueObject.getObjectClass() == String.class) {
            return preferenceValueObject.getObjectClass().cast(sharedPreferences.getString(preferenceValueObject.getName(), (String) preferenceValueObject.getDefaultValue()));
        }
        if (preferenceValueObject.getObjectClass() == Integer.class) {
            return preferenceValueObject.getObjectClass().cast(sharedPreferences.getInt(preferenceValueObject.getName(), (Integer) preferenceValueObject.getDefaultValue()));
        }
        if (preferenceValueObject.getObjectClass() == Long.class) {
            return preferenceValueObject.getObjectClass().cast(sharedPreferences.getLong(preferenceValueObject.getName(), (Long) preferenceValueObject.getDefaultValue()));
        }
        throw new IllegalArgumentException("Unsupported key class");
    }

    public static <T> void save(PreferenceValueObject<T> aVar, T t) {
        Editor edit = sharedPreferences.edit();
        try {
            if (aVar.getObjectClass() == Boolean.class) {
                edit.putBoolean(aVar.getName(), (Boolean) t);
            } else if (aVar.getObjectClass() == String.class) {
                edit.putString(aVar.getName(), (String) t);
            } else if (aVar.getObjectClass() == Integer.class) {
                edit.putInt(aVar.getName(), (Integer) t);
            } else if (aVar.getObjectClass() == Long.class) {
                edit.putLong(aVar.getName(), (Long) t);
            } else {
                throw new IllegalArgumentException("Unsupported key class key");
            }
        } catch (Exception e) {
            Log.e("Prefs writing failed", e.toString());
        }
        edit.apply();
    }
}
