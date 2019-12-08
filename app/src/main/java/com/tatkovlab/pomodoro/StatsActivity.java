package com.tatkovlab.pomodoro;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tatkovlab.pomodoro.p076b.C2221d;
import com.tatkovlab.pomodoro.p077c.C2233g;
import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodorolite.R;

import butterknife.BindView;

public class StatsActivity extends BaseActivity {

    @BindView(R.id.stats_box)
    ViewGroup statsBox;

    @BindView(R.id.text_header)
    TextView tvHeader;

    @Override
    protected void initViews() {
        m10081k();
        C2250f.m10263a().mo7965g().mo7982a(new C2221d<C2233g>() {
            public void mo7844a(C2233g gVar) {
                StatsActivity.this.m10080a(gVar);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_stats;
    }

    private void m10081k() {
        FontHelper.setTypeface(tvHeader, Fonts.LATO_BOLD);
    }

    public void m10080a(C2233g gVar) {
        LayoutInflater from = LayoutInflater.from(this);
        m10078a(from, R.string.stats_label_today, gVar.today);
        m10077a(from, R.string.stats_label_yesterday, R.string.stats_label_yesterday_vs, gVar.yesterday, gVar.yesterdayVsSameDayLastWeek);
        m10077a(from, R.string.stats_label_this_month, R.string.stats_label_this_month_vs, gVar.monthSoFar, gVar.f6571e);
        m10077a(from, R.string.stats_label_last_month, R.string.stats_label_last_month_vs, gVar.f6572f, gVar.f6573g);
        m10078a(from, R.string.stats_label_total, gVar.f6574h);
    }

    private void m10078a(LayoutInflater layoutInflater, int i, long j) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.stats_item_single_line, this.statsBox, false);
        TextView textView = viewGroup.findViewById(R.id.label);
        textView.setText(i);
        TextView textView2 = viewGroup.findViewById(R.id.number);
        textView2.setText(String.valueOf(j));
        FontHelper.setTypeface(textView, Fonts.LATO_BOLD);
        FontHelper.setTypeface(textView2, Fonts.LATO_BOLD);
        this.statsBox.addView(viewGroup);
    }

    private void m10077a(LayoutInflater layoutInflater, int i, int i2, long j, long j2) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.stats_item_two_line, this.statsBox, false);
        TextView textView = viewGroup.findViewById(R.id.label_top);
        textView.setText(i);
        TextView textView2 = viewGroup.findViewById(R.id.label_bottom);
        textView2.setText(i2);
        TextView textView3 = viewGroup.findViewById(R.id.number_top);
        textView3.setText(String.valueOf(j));
        TextView textView4 = viewGroup.findViewById(R.id.number_bottom);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(j2);
        sb.append(")");
        textView4.setText(sb.toString());
        FontHelper.setTypeface(textView, Fonts.LATO_BOLD);
        FontHelper.setTypeface(textView2, Fonts.LATO_BOLD);
        FontHelper.setTypeface(textView3, Fonts.LATO_BOLD);
        FontHelper.setTypeface(textView4, Fonts.LATO_BOLD);
        this.statsBox.addView(viewGroup);
    }
}
