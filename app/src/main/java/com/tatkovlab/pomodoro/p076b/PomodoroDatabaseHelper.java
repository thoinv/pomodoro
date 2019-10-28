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

public class PomodoroDatabaseHelper {

    private static PomodoroDatabase f6499a;

    private static class C2211a extends AsyncTask<TaskInfo, Void, Void> {

        private PomodoroDatabase pomodoroDatabase;

        C2211a(PomodoroDatabase pomodoroDatabase) {
            this.pomodoroDatabase = pomodoroDatabase;
        }

        public Void doInBackground(TaskInfo... tasks) {
            SQLiteDatabase writableDatabase = this.pomodoroDatabase.getWritableDatabase();
            TaskInfo taskInfo = tasks[0];
            writableDatabase.beginTransaction();
            try {
                long a = taskInfo.getId();
                String sb = "_id = " + a;
                writableDatabase.delete("tasks", sb, null);
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

        private C2221d<TaskInfo> f6501a;

        private PomodoroDatabase pomodoroDatabase;

        C2212b(PomodoroDatabase pomodoroDatabase, C2221d<TaskInfo> dVar) {
            this.pomodoroDatabase = pomodoroDatabase;
            this.f6501a = dVar;
        }

        public TaskInfo doInBackground(Void... voidArr) {
            String[] databaseColumns = DatabaseConst.databaseColumns;
            String selection = "status = " + TaskStatus.IN_PROGRESS.intValue();
            List<TaskInfo> a = PomodoroDatabaseHelper.getListTaskInfo(this.pomodoroDatabase.getReadableDatabase()
                    .query("tasks", databaseColumns, selection, null, null, null, null));
            if (a == null || a.size() <= 0) {
                return null;
            }
            return a.get(0);
        }

        public void onPostExecute(TaskInfo fVar) {
            this.f6501a.mo7844a(fVar);
        }
    }

    private static class C2213c extends AsyncTask<C2228b, Void, C2234h> {

        private C2221d<C2234h> f6503a;

        private PomodoroDatabase pomodoroDatabase;

        C2213c(PomodoroDatabase pomodoroDatabase, C2221d<C2234h> dVar) {
            this.pomodoroDatabase = pomodoroDatabase;
            this.f6503a = dVar;
        }

        public C2234h doInBackground(C2228b... bVarArr) {
            C2234h hVar = new C2234h();
            SQLiteDatabase readableDatabase = this.pomodoroDatabase.getReadableDatabase();
            hVar.f6576b = m10150a(readableDatabase);
            for (C2228b a : bVarArr) {
                hVar.f6575a.add(m10151a(readableDatabase, a));
            }
            readableDatabase.close();
            return hVar;
        }

        private long m10150a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM stats", null);
            rawQuery.moveToFirst();
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        }

        private long m10151a(SQLiteDatabase sQLiteDatabase, C2228b bVar) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM stats WHERE date_finished >= ? AND date_finished < ?", new String[]{String.valueOf(bVar.f6544a), String.valueOf(bVar.f6545b)});
            rawQuery.moveToFirst();
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        }

        public void onPostExecute(C2234h hVar) {
            this.f6503a.mo7844a(hVar);
        }
    }

    private static class C2214d extends AsyncTask<Void, Void, List<TaskInfo>> {

        private C2220c<TaskInfo> f6505a;

        private PomodoroDatabase f6506b;

        C2214d(PomodoroDatabase bVar, C2220c<TaskInfo> cVar) {
            this.f6506b = bVar;
            this.f6505a = cVar;
        }

        public List<TaskInfo> doInBackground(Void... voidArr) {
            SQLiteDatabase readableDatabase = this.f6506b.getReadableDatabase();
            List<TaskInfo> a = PomodoroDatabaseHelper.getListTaskInfo(readableDatabase.query("tasks", DatabaseConst.databaseColumns, null, null, null, null, "list_order DESC", String.valueOf(200)));
            readableDatabase.close();
            return a;
        }

        @Override
        public void onPostExecute(List<TaskInfo> list) {
            this.f6505a.mo7850a(list);
        }
    }

    private static class C2215e extends AsyncTask<Long, Void, Void> {

        private PomodoroDatabase pomodoroDatabase;

        C2215e(PomodoroDatabase pomodoroDatabase) {
            this.pomodoroDatabase = pomodoroDatabase;
        }

        @Override
        public Void doInBackground(Long... longs) {

            SQLiteDatabase writableDatabase = this.pomodoroDatabase.getWritableDatabase();
            for (Long l : longs) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("date_finished", l);
                writableDatabase.insert("stats", null, contentValues);
            }
            writableDatabase.close();
            return null;
        }
    }

    private static class C2216f extends AsyncTask<TaskInfo, Void, Void> {

        private PomodoroDatabase f6508a;

        C2216f(PomodoroDatabase bVar) {
            this.f6508a = bVar;
        }

        public Void doInBackground(TaskInfo... taskInfos) {
            SQLiteDatabase writableDatabase = this.f6508a.getWritableDatabase();
            for (TaskInfo taskInfo : taskInfos) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", taskInfo.getTaskName());
                contentValues.put("list_order", taskInfo.mo7908h());
                contentValues.put("status", taskInfo.getTaskStatus().intValue());
                contentValues.put("list", taskInfo.getTaskType().intValue());
                contentValues.put("estimated", taskInfo.getEstimated());
                contentValues.put("done", taskInfo.getNumberOfDone());
                contentValues.put("abandoned", taskInfo.getNumberOfAbandoned());
                contentValues.put("date_added", taskInfo.mo7908h());
                taskInfo.setId(writableDatabase.insert("tasks", null, contentValues));
            }
            writableDatabase.close();
            return null;
        }
    }

    private static class C2217g extends AsyncTask<TaskInfo, Void, Void> {

        private PomodoroDatabase f6509a;

        C2217g(PomodoroDatabase bVar) {
            this.f6509a = bVar;
        }

        @Override
        protected Void doInBackground(TaskInfo... fVarArr) {
            SQLiteDatabase writableDatabase = this.f6509a.getWritableDatabase();
            TaskInfo fVar = fVarArr[0];
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", TaskStatus.NEW.intValue());
            String sb = "status = " + TaskStatus.IN_PROGRESS.intValue();
            writableDatabase.update("tasks", contentValues, sb, null);
            contentValues.put("status", TaskStatus.IN_PROGRESS.intValue());
            String sb2 = "_id = " + fVar.getId();
            writableDatabase.update("tasks", contentValues, sb2, null);
            writableDatabase.close();
            return null;
        }
    }

    private static class C2218h extends AsyncTask<TaskInfo, Void, Void> {

        private PomodoroDatabase f6510a;

        C2218h(PomodoroDatabase bVar) {
            this.f6510a = bVar;
        }

        @Override
        protected Void doInBackground(TaskInfo... lstTaskInfo) {
            SQLiteDatabase writableDatabase = this.f6510a.getWritableDatabase();
            for (TaskInfo taskInfo : lstTaskInfo) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("list_order", taskInfo.getListOrder());
                contentValues.put("name", taskInfo.getTaskName());
                contentValues.put("estimated", taskInfo.getEstimated());
                contentValues.put("done", taskInfo.getNumberOfDone());
                contentValues.put("abandoned", taskInfo.getNumberOfAbandoned());
                contentValues.put("status", taskInfo.getTaskStatus().intValue);
                writableDatabase.update("tasks", contentValues, "_id = ?", new String[]{String.valueOf(taskInfo.getId())});
            }
            writableDatabase.close();
            return null;
        }
    }

    public static void m10138a(Context context) {
        f6499a = PomodoroDatabase.getInstance(context);
    }

    public static void m10141a(TaskInfo fVar) {
        new C2216f(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, fVar);
    }

    public static void m10144b(TaskInfo fVar) {
        new C2218h(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, fVar);
    }

    public static void m10139a(C2220c<TaskInfo> cVar) {
        new C2214d(f6499a, cVar).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[]{null});
    }

    public static void m10145c(TaskInfo fVar) {
        new C2211a(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, fVar);
    }

    public static void m10146d(TaskInfo fVar) {
        new C2217g(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, fVar);
    }

    public static void m10140a(C2221d<TaskInfo> dVar) {
        new C2212b(f6499a, dVar).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[]{null});
    }

    public static void m10142a(C2228b[] bVarArr, C2221d<C2234h> dVar) {
        new C2213c(f6499a, dVar).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, bVarArr);
    }

    public static void m10137a(long j) {
        new C2215e(f6499a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, j);
    }

    static List<TaskInfo> getListTaskInfo(Cursor cursor) {
        ArrayList<TaskInfo> arrayList = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(getTaskInfoByCursor(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }

    private static TaskInfo getTaskInfoByCursor(Cursor cursor) {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setId(cursor.getLong(0));
        taskInfo.setListOrder(cursor.getLong(1));
        taskInfo.setTaskName(cursor.getString(2));
        taskInfo.setTaskStatus(TaskStatus.m10194a(cursor.getLong(3)));
        taskInfo.setTaskType(TaskType.getTaskType(cursor.getLong(4)));
        taskInfo.setEstimated(cursor.getLong(5));
        taskInfo.setNumberOfDone(cursor.getLong(6));
        taskInfo.mo7904e(cursor.getLong(7));
        taskInfo.mo7906f(cursor.getLong(8));
        return taskInfo;
    }
}
