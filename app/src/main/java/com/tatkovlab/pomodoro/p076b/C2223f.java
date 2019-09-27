package com.tatkovlab.pomodoro.p076b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.tatkovlab.pomodoro.b.f */
public class C2223f implements Parcelable {
    public static final Creator<C2223f> CREATOR = new Creator<C2223f>() {
        /* renamed from: a */
        public C2223f createFromParcel(Parcel parcel) {
            C2223f fVar = new C2223f();
            fVar.f6513a = parcel.readLong();
            fVar.f6514b = parcel.readLong();
            fVar.f6515c = parcel.readString();
            fVar.f6516d = parcel.readLong();
            fVar.f6517e = parcel.readLong();
            fVar.f6518f = parcel.readLong();
            fVar.f6519g = C2226b.m10194a(parcel.readLong());
            fVar.f6520h = C2225a.m10192a(parcel.readLong());
            fVar.f6521i = parcel.readLong();
            return fVar;
        }

        /* renamed from: a */
        public C2223f[] newArray(int i) {
            return new C2223f[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f6513a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f6514b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f6515c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f6516d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f6517e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f6518f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C2226b f6519g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2225a f6520h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f6521i;

    /* renamed from: com.tatkovlab.pomodoro.b.f$a */
    public enum C2225a {
        TODAY(1),
        ARCHIVE(2);
        

        /* renamed from: c */
        final long f6525c;

        private C2225a(long j) {
            this.f6525c = j;
        }

        /* renamed from: a */
        public long mo7916a() {
            return this.f6525c;
        }

        /* renamed from: a */
        public static C2225a m10192a(long j) {
            switch ((int) j) {
                case 1:
                    return TODAY;
                case 2:
                    return ARCHIVE;
                default:
                    return null;
            }
        }
    }

    /* renamed from: com.tatkovlab.pomodoro.b.f$b */
    public enum C2226b {
        NEW(1),
        IN_PROGRESS(2),
        FINISHED(3);
        

        /* renamed from: d */
        final long f6530d;

        private C2226b(long j) {
            this.f6530d = j;
        }

        /* renamed from: a */
        public long mo7917a() {
            return this.f6530d;
        }

        /* renamed from: a */
        public static C2226b m10194a(long j) {
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

    /* renamed from: a */
    public long mo7891a() {
        return this.f6513a;
    }

    /* renamed from: a */
    public void mo7892a(long j) {
        this.f6513a = j;
    }

    /* renamed from: b */
    public long mo7896b() {
        return this.f6514b;
    }

    /* renamed from: b */
    public void mo7897b(long j) {
        this.f6514b = j;
    }

    /* renamed from: c */
    public String mo7898c() {
        return this.f6515c;
    }

    /* renamed from: a */
    public void mo7895a(String str) {
        this.f6515c = str;
    }

    /* renamed from: d */
    public long mo7900d() {
        return this.f6516d;
    }

    /* renamed from: c */
    public void mo7899c(long j) {
        this.f6516d = j;
    }

    /* renamed from: e */
    public long mo7903e() {
        return this.f6517e;
    }

    /* renamed from: d */
    public void mo7901d(long j) {
        this.f6517e = j;
    }

    /* renamed from: f */
    public long mo7905f() {
        return this.f6518f;
    }

    /* renamed from: e */
    public void mo7904e(long j) {
        this.f6518f = j;
    }

    /* renamed from: g */
    public C2226b mo7907g() {
        return this.f6519g;
    }

    /* renamed from: a */
    public void mo7894a(C2226b bVar) {
        this.f6519g = bVar;
    }

    /* renamed from: h */
    public long mo7908h() {
        return this.f6521i;
    }

    /* renamed from: f */
    public void mo7906f(long j) {
        this.f6521i = j;
    }

    /* renamed from: i */
    public C2225a mo7909i() {
        return this.f6520h;
    }

    /* renamed from: a */
    public void mo7893a(C2225a aVar) {
        this.f6520h = aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6515c);
        sb.append(" ");
        sb.append(this.f6516d);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6513a);
        parcel.writeLong(this.f6514b);
        parcel.writeString(this.f6515c);
        parcel.writeLong(this.f6516d);
        parcel.writeLong(this.f6517e);
        parcel.writeLong(this.f6518f);
        parcel.writeLong(this.f6519g.mo7917a());
        parcel.writeLong(this.f6520h.mo7916a());
        parcel.writeLong(this.f6521i);
    }
}
