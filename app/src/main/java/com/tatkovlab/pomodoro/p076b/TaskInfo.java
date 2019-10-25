package com.tatkovlab.pomodoro.p076b;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Locale;

public class TaskInfo implements Parcelable {
    public static final Creator<TaskInfo> CREATOR = new Creator<TaskInfo>() {
        public TaskInfo createFromParcel(Parcel parcel) {
            TaskInfo fVar = new TaskInfo();
            fVar.id = parcel.readLong();
            fVar.listOrder = parcel.readLong();
            fVar.taskName = parcel.readString();
            fVar.estimated = parcel.readLong();
            fVar.numberOfDone = parcel.readLong();
            fVar.f6518f = parcel.readLong();
            fVar.taskStatus = TaskStatus.m10194a(parcel.readLong());
            fVar.taskType = TaskType.getTaskType(parcel.readLong());
            fVar.f6521i = parcel.readLong();
            return fVar;
        }

        public TaskInfo[] newArray(int i) {
            return new TaskInfo[i];
        }
    };

    public long id;

    public long listOrder;

    public String taskName;

    public long estimated;

    public long numberOfDone;

    public long f6518f;

    public TaskStatus taskStatus;

    public TaskType taskType;

    public long f6521i;

    public enum TaskType {
        TODAY(1),
        ARCHIVE(2);
        

        final long intValue;

        TaskType(long intValue) {
            this.intValue = intValue;
        }

        public long intValue() {
            return this.intValue;
        }

        public static TaskType getTaskType(long intValue) {
            switch ((int) intValue) {
                case 1:
                    return TODAY;
                case 2:
                    return ARCHIVE;
                default:
                    return null;
            }
        }
    }

    public enum TaskStatus {
        NEW(1),
        IN_PROGRESS(2),
        FINISHED(3);
        

        final long intValue;

        TaskStatus(long j) {
            this.intValue = j;
        }

        public long intValue() {
            return this.intValue;
        }

        public static TaskStatus m10194a(long j) {
            switch ((int) j) {
                case 1:
                    return NEW;
                case 2:
                    return IN_PROGRESS;
                case 3:
                    return FINISHED;
                default:
                    return null;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(long j) {
        this.listOrder = j;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String str) {
        this.taskName = str;
    }

    public long getEstimated() {
        return this.estimated;
    }

    public void setEstimated(long estimated) {
        this.estimated = estimated;
    }

    public long getNumberOfDone() {
        return this.numberOfDone;
    }

    public void setNumberOfDone(long j) {
        this.numberOfDone = j;
    }

    public long getNumberOfAbandoned() {
        return this.f6518f;
    }

    public void mo7904e(long j) {
        this.f6518f = j;
    }

    public TaskStatus getTaskStatus() {
        return this.taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public long mo7908h() {
        return this.f6521i;
    }

    public void mo7906f(long j) {
        this.f6521i = j;
    }

    public TaskType getTaskType() {
        return this.taskType;
    }

    public void setTaskType(TaskType aVar) {
        this.taskType = aVar;
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "%s %d", this.taskName, this.estimated);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeLong(this.listOrder);
        parcel.writeString(this.taskName);
        parcel.writeLong(this.estimated);
        parcel.writeLong(this.numberOfDone);
        parcel.writeLong(this.f6518f);
        parcel.writeLong(this.taskStatus.intValue());
        parcel.writeLong(this.taskType.intValue());
        parcel.writeLong(this.f6521i);
    }
}
