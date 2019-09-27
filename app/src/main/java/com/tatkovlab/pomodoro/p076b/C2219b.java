package com.tatkovlab.pomodoro.p076b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* renamed from: com.tatkovlab.pomodoro.b.b */
class C2219b extends SQLiteOpenHelper {

    /* renamed from: a */
    private static C2219b f6511a;

    /* renamed from: a */
    static synchronized C2219b m10160a(Context context) {
        C2219b bVar;
        synchronized (C2219b.class) {
            if (f6511a == null) {
                f6511a = new C2219b(context.getApplicationContext());
            }
            bVar = f6511a;
        }
        return bVar;
    }

    private C2219b(Context context) {
        super(context, "pomodoro_timer.db", null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table tasks (_id integer primary key autoincrement, list_order integer not null, name text not null, status integer not null, list integer not null, estimated integer not null, done integer not null, abandoned integer not null, date_added integer not null);");
        sQLiteDatabase.execSQL("create table stats (_id integer primary key autoincrement, date_finished integer not null);");
        sQLiteDatabase.execSQL("create index my_date_index on stats(date_finished);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String name = C2219b.class.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("Upgrading database from version ");
        sb.append(i);
        sb.append(" to ");
        sb.append(i2);
        Log.w(name, sb.toString());
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("create table stats (_id integer primary key autoincrement, date_finished integer not null);");
                sQLiteDatabase.execSQL("create index my_date_index on stats(date_finished);");
                for (C2223f fVar : C2210a.m10136a(sQLiteDatabase.rawQuery("SELECT * FROM tasks", null))) {
                    for (int i3 = 0; ((long) i3) < fVar.mo7903e(); i3++) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("date_finished", Long.valueOf(fVar.mo7908h()));
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
