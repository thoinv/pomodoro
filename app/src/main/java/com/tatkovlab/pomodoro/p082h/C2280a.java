package com.tatkovlab.pomodoro.p082h;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p077c.C2227a;
import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodorolite.R;

/* renamed from: com.tatkovlab.pomodoro.h.a */
public class C2280a {

    /* renamed from: a */
    private int[] f6657a = {R.id.text_dialog_title, R.id.text_dialog_body, R.id.button_primary, R.id.button_secondary, R.id.button_skip};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C2284a f6658b;

    /* renamed from: c */
    private View f6659c;

    /* renamed from: com.tatkovlab.pomodoro.h.a$a */
    public interface C2284a {
        /* renamed from: a */
        void mo7804a();

        /* renamed from: b */
        void mo7805b();

        /* renamed from: c */
        void mo7806c();
    }

    public C2280a(View view, boolean z, C2284a aVar) {
        this.f6659c = view;
        this.f6658b = aVar;
        m10432a();
        m10434b();
        m10433a(z);
        m10435b(z);
    }

    /* renamed from: a */
    private void m10432a() {
        for (int findViewById : this.f6657a) {
            FontHelper.setTypeface((TextView) this.f6659c.findViewById(findViewById), Fonts.LATO_BOLD);
        }
    }

    /* renamed from: b */
    private void m10434b() {
        C2227a c = C2227a.m10196c();
        ((TextView) this.f6659c.findViewById(R.id.text_dialog_title)).setText(c.mo7918a());
        ((ImageView) this.f6659c.findViewById(R.id.image_dialog_body)).setImageResource(c.mo7919b());
    }

    /* renamed from: a */
    private void m10433a(boolean z) {
        ((TextView) this.f6659c.findViewById(R.id.text_dialog_body)).setText(z ? R.string.break_dialog_body_short_break : R.string.break_dialog_body_long_break);
    }

    /* renamed from: b */
    private void m10435b(final boolean z) {
        Button button = (Button) this.f6659c.findViewById(R.id.button_primary);
        int i = R.string.button_long_break;
        button.setText(z ? R.string.button_short_break : R.string.button_long_break);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (z) {
                    C2280a.this.f6658b.mo7804a();
                } else {
                    C2280a.this.f6658b.mo7805b();
                }
            }
        });
        Button button2 = (Button) this.f6659c.findViewById(R.id.button_secondary);
        if (!z) {
            i = R.string.button_short_break;
        }
        button2.setText(i);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (z) {
                    C2280a.this.f6658b.mo7805b();
                } else {
                    C2280a.this.f6658b.mo7804a();
                }
            }
        });
        ((Button) this.f6659c.findViewById(R.id.button_skip)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2280a.this.f6658b.mo7806c();
            }
        });
    }
}
