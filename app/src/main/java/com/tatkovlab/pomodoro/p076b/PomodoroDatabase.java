package com.tatkovlab.pomodoro.p076b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Locale;

class PomodoroDatabase extends SQLiteOpenHelper {

    private static PomodoroDatabase instance;

    static synchronized PomodoroDatabase getInstance(Context context) {
        synchronized (PomodoroDatabase.class) {
            if (instance == null) {
                instance = new PomodoroDatabase(context.getApplicationContext());
            }
        }
        return instance;
    }

    private PomodoroDatabase(Context context) {
        super(context, "pomodoro_timer.db", null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tasks (_id integer primary key autoincrement, " +
                "list_order integer not null, " +
                "name text not null, " +
                "status integer not null, " +
                "list integer not null, " +
                "estimated integer not null, " +
                "done integer not null, " +
                "abandoned integer not null, " +
                "date_added integer not null);");
        sQLiteDatabase.execSQL("create table if not exists stats (_id integer primary key autoincrement, date_finished integer not null);");
        sQLiteDatabase.execSQL("create index my_date_index on stats(date_finished);");
        sQLiteDatabase.execSQL("UPDATE tasks SET list_order = date_added;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {

    }
}
