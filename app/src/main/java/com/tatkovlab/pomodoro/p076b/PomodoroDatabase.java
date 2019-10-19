package com.tatkovlab.pomodoro.p076b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        sQLiteDatabase.execSQL("create table tasks (_id integer primary key autoincrement, list_order integer not null, name text not null, status integer not null, list integer not null, estimated integer not null, done integer not null, abandoned integer not null, date_added integer not null);");
        sQLiteDatabase.execSQL("create table stats (_id integer primary key autoincrement, date_finished integer not null);");
        sQLiteDatabase.execSQL("create index my_date_index on stats(date_finished);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String name = PomodoroDatabase.class.getName();
        String sb = "Upgrading database from version " +
                i +
                " to " +
                i2;
        Log.w(name, sb);
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("create table stats (_id integer primary key autoincrement, date_finished integer not null);");
                sQLiteDatabase.execSQL("create index my_date_index on stats(date_finished);");
                for (TaskInfo taskInfo : C2210a.m10136a(sQLiteDatabase.rawQuery("SELECT * FROM tasks", null))) {
                    for (int i3 = 0; ((long) i3) < taskInfo.mo7903e(); i3++) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("date_finished", taskInfo.mo7908h());
                        sQLiteDatabase.insert("stats", null, contentValues);
                    }
                }
                break;
            case 2:
                break;
            default:
                return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE tasks ADD COLUMN list_order integer not null DEFAULT 1;");
        sQLiteDatabase.execSQL("UPDATE tasks SET list_order = date_added;");
    }
}
