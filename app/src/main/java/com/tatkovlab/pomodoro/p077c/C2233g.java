package com.tatkovlab.pomodoro.p077c;

import androidx.annotation.NonNull;

public class C2233g {

    public long today;

    public long yesterday;

    public long yesterdayVsSameDayLastWeek;

    public long monthSoFar;

    public long f6571e;

    public long f6572f;

    public long f6573g;

    public long f6574h;

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Today: ");
        sb.append(this.today);
        sb.append("\nYesterday: ");
        sb.append(this.yesterday);
        sb.append("\nYesterday vs. same day last week: ");
        sb.append(this.yesterdayVsSameDayLastWeek);
        sb.append("\nThis month so far: ");
        sb.append(this.monthSoFar);
        sb.append("\nThis month so far vs. same day last month: ");
        sb.append(this.f6571e);
        sb.append("\nLast month: ");
        sb.append(this.f6572f);
        sb.append("\nLast month vs. month before: ");
        sb.append(this.f6573g);
        sb.append("\nTotal: ");
        sb.append(this.f6574h);
        return sb.toString();
    }
}
