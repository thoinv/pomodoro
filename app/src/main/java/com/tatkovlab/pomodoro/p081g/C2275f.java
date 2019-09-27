package com.tatkovlab.pomodoro.p081g;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tatkovlab.pomodoro.p081g.C2264a.C2267a;

@TargetApi(16)
/* renamed from: com.tatkovlab.pomodoro.g.f */
public class C2275f implements C2268b {

    /* renamed from: a */
    private final Context f6644a;

    /* renamed from: b */
    private final int f6645b;

    /* renamed from: c */
    private int f6646c = 100;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MediaPlayer f6647d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MediaPlayer f6648e;

    /* renamed from: f */
    private C2264a f6649f;

    /* renamed from: g */
    private OnCompletionListener f6650g = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
            C2275f.this.f6647d = C2275f.this.f6648e;
            C2275f.this.m10416c();
        }
    };

    public C2275f(Context context, int i) {
        this.f6644a = context;
        this.f6645b = i;
        this.f6647d = MediaPlayer.create(context, i);
        this.f6647d.setWakeMode(this.f6644a, 1);
        m10416c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10416c() {
        this.f6648e = MediaPlayer.create(this.f6644a, this.f6645b);
        this.f6648e.setWakeMode(this.f6644a, 1);
        m10412a(this.f6648e, this.f6646c);
        this.f6647d.setNextMediaPlayer(this.f6648e);
        this.f6647d.setOnCompletionListener(this.f6650g);
    }

    /* renamed from: a */
    public void mo8002a() {
        m10418e();
        mo8003a(this.f6646c);
        this.f6647d.start();
    }

    /* renamed from: b */
    public void mo8005b() {
        if (this.f6647d != null) {
            this.f6647d.stop();
        }
        m10417d();
    }

    /* renamed from: a */
    public void mo8004a(long j) {
        m10418e();
        this.f6649f = new C2264a(this.f6646c, 10, new C2267a() {
            /* renamed from: a */
            public void mo8001a(int i) {
                C2275f.this.m10412a(C2275f.this.f6647d, i);
                C2275f.this.m10412a(C2275f.this.f6648e, i);
            }

            /* renamed from: a */
            public void mo8000a() {
                C2275f.this.mo8005b();
            }
        });
    }

    /* renamed from: d */
    private void m10417d() {
        if (this.f6647d != null) {
            this.f6647d.release();
            this.f6647d = null;
        }
        if (this.f6648e != null) {
            this.f6648e.release();
            this.f6648e = null;
        }
    }

    /* renamed from: a */
    public void mo8003a(int i) {
        this.f6646c = i;
        m10412a(this.f6647d, i);
        m10412a(this.f6648e, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10412a(MediaPlayer mediaPlayer, int i) {
        if (mediaPlayer != null) {
            float f = ((float) i) / 100.0f;
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        }
    }

    /* renamed from: e */
    private void m10418e() {
        if (this.f6649f != null) {
            this.f6649f.mo7997a();
        }
    }
}
