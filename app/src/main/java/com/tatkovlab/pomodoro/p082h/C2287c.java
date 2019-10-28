package com.tatkovlab.pomodoro.p082h;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.tatkovlab.pomodoro.TasksActivity;
import com.tatkovlab.pomodoro.p079e.C2242a;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodorolite.R;

public class C2287c implements OnClickListener {
    public void onClick(View view) {

        view.getContext().startActivity(new Intent(view.getContext(), TasksActivity.class));
//        new MaterialDialog.Builder(view.getContext()).title(R.string.add_task_dialog_header)
//                .titleColor(ContextCompat.getColor(view.getContext(), R.color.dark_brown))
//                .contentColor(ContextCompat.getColor(view.getContext(), R.color.dark_brown))
//                .positiveColor(ContextCompat.getColor(view.getContext(), R.color.dark_brown))
//                .theme(Theme.LIGHT)
//                .positiveText(R.string.save)
//                .inputRange(1, 50)
//                .input(R.string.add_task_dialog_hint, 0,
//                new MaterialDialog.InputCallback() {
//                    @Override
//                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
//                        C2250f.m10263a().mo7963e().mo7944a(input.toString(), 0);
//                    }
//                }).show();
    }
}
