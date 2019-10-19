package com.tatkovlab.pomodoro.p076b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskType;
import com.tatkovlab.pomodoro.p076b.TaskInfo.TaskStatus;
import com.tatkovlab.pomodoro.p077c.C2228b;
import com.tatkovlab.pomodoro.p077c.C2234h;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tatkovlab.pomodoro.b.a */
public class C2210a {

    /* renamed from: a */
    private static C2219b f6499a;

    /* renamed from: com.tatkovlab.pomodoro.b.a$a */
    private static class C2211a extends AsyncTask<TaskInfo, Void, Void> {

        /* renamed from: a */
        private C2219b f6500a;

        C2211a(C2219b bVar) {
            this.f6500a = bVar;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(TaskInfo... fVarArr) {
            SQLiteDatabase writableDatabase = this.f6500a.getWritableDatabase();
            TaskInfo fVar = fVarArr[0];
            writableDatabase.beginTransaction();
            try {
                long a = fVar.mo7891a();
                StringBuilder sb = new StringBuilder();
                sb.append("_id = ");
                sb.append(a);
                writableDatabase.delete("tasks", sb.toString(), null);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.close();
                return null;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    private static class C2212b extends AsyncTask<Void, Void, TaskInfo> {

        /* renamed from: a */
        private C2221d<TaskInfo> f6501a;

        /* renamed from: b */
        private C2219b f6502b;

        C2212b(C2219b bVar, C2221d<TaskInfo> dVar) {
            this.f6502b = bVar;
            this.f6501a = dVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public TaskInfo doInBackground(Void... voidArr) {
            String[] strArr = C2222e.f6512a;
            String sb = "status = " +
                    TaskStatus.IN_PROGRESS.intValue();
            List a = C2210a.m10136a(this.f6502b.getReadableDatabase()
                    .query("tasks", strArr, sb, null, null, null, null));
            if (a == null || a.size() <= 0) {
                return null;
            }
            return (TaskInfo) a.get(0);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(TaskInfo fVar) {
            this.f6501a.mo7844a(fVar);
        }
    }

    /* renamed from: com.tatkovlab.pomodoro.b.a$c */
    private static class C2213c extends AsyncTask<C2228b, Void, C2234h> {

        /* renamed from: a */
        private C2221d<C2234h> f6503a;

        /* renamed from: b */
        private C2219b f6504b;

        C2213c(C2219b bVar, C2221d<C2234h> dVar) {
            this.f6504b = bVar;
            this.f6503a = dVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C2234h doInBackground(C2228b... bVarArr) {
            C2234h hVar = new C2234h();
            SQLiteDatabase readableDatabase = this.f6504b.getReadableDatabase();
            hVar.f6576b = m10150a(readableDatabase);
            for (C2228b a : bVarArr) {
                hVar.f6575a.add(Long.valueOf(m10151a(readableDatabase, a)));
            }
            readableDatabase.close();
            return hVar;
        }

        /* renamed from: a */
        private long m10150a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM stats", null);
            rawQuery.moveToFirst();
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        }

        /* renamed from: a */
        private long m10151a(SQLiteDatabase sQLiteDatabase, C2228b bVar) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM stats WHERE date_finished >= ? AND date_finished < ?", new String[]{String.valueOf(bVar.f6544a), String.valueOf(bVar.f6545b)});
            rawQuery.moveToFirst();
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C2234h hVar) {
            this.f6503a.mo7844a(hVar);
        }
    }

    /* renamed from: com.tatkovlab.pomodoro.b.a$d */
    private static class C2214d extends AsyncTask<Void, Void, List<TaskInfo>> {

        /* renamed from: a */
        private C2220c<TaskInfo> f6505a;

        /* renamed from: b */
        private C2219b f6506b;

        C2214d(C2219b bVar, C2220c<TaskInfo> cVar) {
            this.f6506b = bVar;
            this.f6505a = cVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<TaskInfo> doInBackground(Void... voidArr) {
            SQLiteDatabase readableDatabase = this.f6506b.getReadableDatabase();
            List<TaskInfo> a = C2210a.m10136a(readableDatabase.query("tasks", C2222e.f6512a, null, null, null, null, "list_order DESC", String.valueOf(200)));
            readableDatabase.close();
            return a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<TaskInfo> list) {
            this.f6505a.mo7850a(list);
        }
    }

    /* renamed from: com.tatkovlab.pomodoro.b.a$e */
    private static class C2215e extends AsyncTask<Long, Void, Void> {

        /* renamed from: a */
        private C2219b f6507a;

        C2215e(C2219b bVar) {
            this.f6507a = bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Long... lArr) {
            SQLiteDatabase writableDatabase = this.f6507a.getWritableDatabase();
            for (Long l : lArr) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("date_finished", l);
                writableDatabase.insert("stats", null, contentValues);
            }
            writableDatabase.close();
            return null;
        }
    }

    /* renamed from: com.tatkovlab.pomodoro.b.a$f */
    private static class C2216f extends AsyncTask<TaskInfo, Void, Void> {

        /* renamed from: a */
        private C2219b f6508a;

        C2216f(C2219b bVar) {
            this.f6508a = bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(TaskInfo... fVarArr) {
            SQLiteDatabase writableDatabase = this.f6508a.getWritableDatabase();
            for (TaskInfo fVar : fVarArr) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", fVar.mo7898c());
                contentValues.put("list_order", Long.valueOf(fVar.mo7908h()));
                contentValues.put("status", Long.valueOf(fVar.getTaskStatus().intValue()));
                contentValues.put("list", Long.valueOf(fVar.getTaskType().intValue()));
                contentValues.put("estimated", Long.valueOf(fVar.mo7900d()));
                contentValues.put("done", Long.valueOf(fVar.mo7903e()));
                contentValues.put("abandoned", Long.valueOf(fVar.mo7905f()));
                contentValues.put("date_added", Long.valueOf(fVar.mo7908h()));
                fVar.mo7892a(writableDatabase.insert("tasks", null, contentValues));
            }
            writableDatabase.close();
            return null;
        }
    }

    /* renamed from: com.tatkovlab.pomodoro.b.a$g */
    private static class C2217g extends AsyncTask<TaskInfo, Void, Void> {

        /* renamed from: a */
        private C2219b f6509a;

        C2217g(C2219b bVar) {
            this.f6509a = bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(TaskInfo... fVarArr) {
            SQLiteDatabase writableDatabase = this.f6509a.getWritableDatabase();
            TaskInfo fVar = fVarArr[0];
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Long.valueOf(TaskStatus.NEW.intValue()));
            StringBuilder sb = new StringBuilder();
            sb.append("status = ");
            sb.append(TaskStatus.IN_PROGRESS.intValue());
            writableDatabase.update("tasks", contentValues, sb.toString(), null);
            contentValues.put("status", Long.valueOf(TaskStatus.IN_PROGRESS.intValue()));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("_id = ");
            sb2.append(fVar.mo7891a());
            writableDatabase.update("tasks", contentValues, sb2.toString(), null);
            writableDatabase.close();
            return null;
        }
    }

    /* renamed from: com.tatkovlab.pomodoro.b.a$h */
    private static class C2218h extends AsyncTask<TaskInfo, Void, Void> {

        /* renamed from: a */
        private C2219b f6510a;

        C2218h(C2219b bVar) {
            this.f6510a = bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(TaskInfo... fVarArr) {
            SQLiteDatabase writableDatabase = this.f6510a.getWritableDatabase();
            for (TaskInfo fVar : fVarArr) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("list_order", Long.valueOf(fVar.mo7896b()));
                contentValues.put("name", fVar.mo7898c());
                contentValues.put("estimated", Long.valueOf(fVar.mo7900d()));
                contentValues.put("done", Long.valueOf(fVar.mo7903e()));
                contentValues.put("abandoned", Long.valueOf(fVar.mo7905f()));
                contentValues.put("status", Long.valueOf(fVar.getTaskStatus().intValue));
                writableDatabase.update("tasks", contentValues, "_id = ?", new String[]{String.valueOf(fVar.mo7891a())});
            }
            writableDatabase.close();
            return null;
        }
    }

    /* renamed from: a */
    public static void m10138a(Context context) {
        f6499a = C2219b.m10160a(context);
    }

    /* renamed from: a */
    public static void m10141a(TaskInfo fVar) {
        new C2216f(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new TaskInfo[]{fVar});
    }

    /* renamed from: b */
    public static void m10144b(TaskInfo fVar) {
        new C2218h(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new TaskInfo[]{fVar});
    }

    /* renamed from: a */
    public static void m10139a(C2220c<TaskInfo> cVar) {
        new C2214d(f6499a, cVar).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[]{null});
    }

    /* renamed from: c */
    public static void m10145c(TaskInfo fVar) {
        new C2211a(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new TaskInfo[]{fVar});
    }

    /* renamed from: d */
    public static void m10146d(TaskInfo fVar) {
        new C2217g(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new TaskInfo[]{fVar});
    }

    /* renamed from: a */
    public static void m10140a(C2221d<TaskInfo> dVar) {
        new C2212b(f6499a, dVar).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[]{null});
    }

    /* renamed from: a */
    public static void m10142a(C2228b[] bVarArr, C2221d<C2234h> dVar) {
        new C2213c(f6499a, dVar).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, bVarArr);
    }

    /* renamed from: a */
    public static void m10137a(long j) {
        new C2215e(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Long[]{Long.valueOf(j)});
    }

    /* renamed from: a */
    static List<TaskInfo> m10136a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(m10143b(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }

    /* renamed from: b */
    private static TaskInfo m10143b(Cursor cursor) {
        TaskInfo fVar = new TaskInfo();
        fVar.mo7892a(cursor.getLong(0));
        fVar.mo7897b(cursor.getLong(1));
        fVar.mo7895a(cursor.getString(2));
        fVar.mo7894a(TaskStatus.m10194a(cursor.getLong(3)));
        fVar.setTaskType(TaskType.m10192a(cursor.getLong(4)));
        fVar.mo7899c(cursor.getLong(5));
        fVar.mo7901d(cursor.getLong(6));
        fVar.mo7904e(cursor.getLong(7));
        fVar.mo7906f(cursor.getLong(8));
        return fVar;
    }
}
