package com.tatkovlab.pomodoro.p082h;

import android.app.Activity;
import android.view.View;
import com.tatkovlab.pomodoro.p083i.C2297c;
import com.tatkovlab.pomodorolite.R;

public class C2285b {

    private Activity activity;

    private View rootView;

    public enum C2286a {
        RED(R.drawable.bg_gradient_red, R.color.status_bar_red),
        GREEN(R.drawable.bg_gradient_green, R.color.status_bar_green);
        

        private int f6670c;

        private int f6671d;

        C2286a(int i, int i2) {
            this.f6670c = i;
            this.f6671d = i2;
        }

        public int mo8018a() {
            return this.f6670c;
        }

        public int mo8019b() {
            return this.f6671d;
        }
    }

    public C2285b(Activity activity) {
        this.activity = activity;
        this.rootView = activity.findViewById(R.id.root_view);
    }

    public void mo8017a(C2286a aVar) {
        this.rootView.setBackgroundResource(aVar.mo8018a());
        C2297c.m10467a(this.activity, this.activity.getResources().getColor(aVar.mo8019b()));
    }
}
