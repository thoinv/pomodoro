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

public class C2280a {

    private int[] f6657a = {R.id.text_dialog_title, R.id.text_dialog_body, R.id.button_primary, R.id.button_secondary, R.id.button_skip};

    private C2284a f6658b;

    private View f6659c;

    public interface C2284a {
        void mo7804a();

        void mo7805b();

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

    private void m10432a() {
        for (int findViewById : this.f6657a) {
            FontHelper.setTypeface((TextView) this.f6659c.findViewById(findViewById), Fonts.LATO_BOLD);
        }
    }

    private void m10434b() {
        C2227a c = C2227a.m10196c();
        ((TextView) this.f6659c.findViewById(R.id.text_dialog_title)).setText(c.getMessageStringResourceId());
        ((ImageView) this.f6659c.findViewById(R.id.image_dialog_body)).setImageResource(c.getMessageDrawableResourceId());
    }

    private void m10433a(boolean z) {
        ((TextView) this.f6659c.findViewById(R.id.text_dialog_body)).setText(z ? R.string.break_dialog_body_short_break : R.string.break_dialog_body_long_break);
    }

    private void m10435b(final boolean z) {
        Button button = this.f6659c.findViewById(R.id.button_primary);
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
        Button button2 = this.f6659c.findViewById(R.id.button_secondary);
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
        this.f6659c.findViewById(R.id.button_skip).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2280a.this.f6658b.mo7806c();
            }
        });
    }
}
