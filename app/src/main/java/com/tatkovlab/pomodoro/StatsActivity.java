package com.tatkovlab.pomodoro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tatkovlab.pomodoro.p076b.C2221d;
import com.tatkovlab.pomodoro.p077c.C2233g;
import com.tatkovlab.pomodoro.p078d.C2236b;
import com.tatkovlab.pomodoro.p078d.C2236b.C2237a;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodorolite.R;

public class StatsActivity extends C2204a {

    /* renamed from: j */
    private ViewGroup f6463j;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_stats);
        m10081k();
        C2250f.m10263a().mo7965g().mo7982a((C2221d<C2233g>) new C2221d<C2233g>() {
            /* renamed from: a */
            public void mo7844a(C2233g gVar) {
                StatsActivity.this.m10080a(gVar);
            }
        });
    }

    /* renamed from: k */
    private void m10081k() {
        C2236b.m10219a((TextView) findViewById(R.id.text_header), C2237a.LATO_BOLD);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10080a(C2233g gVar) {
        this.f6463j = (ViewGroup) findViewById(R.id.stats_box);
        LayoutInflater from = LayoutInflater.from(this);
        m10078a(from, R.string.stats_label_today, gVar.f6567a);
        LayoutInflater layoutInflater = from;
        m10077a(layoutInflater, R.string.stats_label_yesterday, R.string.stats_label_yesterday_vs, gVar.f6568b, gVar.f6569c);
        m10077a(layoutInflater, R.string.stats_label_this_month, R.string.stats_label_this_month_vs, gVar.f6570d, gVar.f6571e);
        m10077a(layoutInflater, R.string.stats_label_last_month, R.string.stats_label_last_month_vs, gVar.f6572f, gVar.f6573g);
        m10078a(from, R.string.stats_label_total, gVar.f6574h);
    }

    /* renamed from: a */
    private void m10078a(LayoutInflater layoutInflater, int i, long j) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.stats_item_single_line, this.f6463j, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.label);
        textView.setText(i);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.number);
        textView2.setText(String.valueOf(j));
        C2236b.m10219a(textView, C2237a.LATO_BOLD);
        C2236b.m10219a(textView2, C2237a.LATO_BOLD);
        this.f6463j.addView(viewGroup);
    }

    /* renamed from: a */
    private void m10077a(LayoutInflater layoutInflater, int i, int i2, long j, long j2) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.stats_item_two_line, this.f6463j, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.label_top);
        textView.setText(i);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.label_bottom);
        textView2.setText(i2);
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.number_top);
        textView3.setText(String.valueOf(j));
        TextView textView4 = (TextView) viewGroup.findViewById(R.id.number_bottom);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(String.valueOf(j2));
        sb.append(")");
        textView4.setText(sb.toString());
        C2236b.m10219a(textView, C2237a.LATO_BOLD);
        C2236b.m10219a(textView2, C2237a.LATO_BOLD);
        C2236b.m10219a(textView3, C2237a.LATO_BOLD);
        C2236b.m10219a(textView4, C2237a.LATO_BOLD);
        this.f6463j.addView(viewGroup);
    }
}
