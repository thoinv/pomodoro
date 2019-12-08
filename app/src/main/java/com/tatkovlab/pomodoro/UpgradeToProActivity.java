package com.tatkovlab.pomodoro;

import android.widget.Button;

import com.tatkovlab.pomodoro.p078d.FontHelper;
import com.tatkovlab.pomodoro.p078d.FontHelper.Fonts;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodorolite.R;

import butterknife.BindView;
import butterknife.OnClick;

public class UpgradeToProActivity extends BaseActivity {

    @BindView(R.id.button_upgrade_to_premium)
    Button btUpgradeToPremiumButton;

    @BindView(R.id.button_maybe_later)
    Button btMaybeLater;

    private static final int[] labels = {R.id.label_top_header, R.id.label_app_name, R.id.label_tasks, R.id.label_stats, R.id.label_support};

    @Override
    protected void initViews() {
        m10115k();
        m10116l();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_upgrade_to_pro;
    }

    private void m10115k() {
        for (int findViewById : labels) {
            FontHelper.setTypeface(findViewById(findViewById), Fonts.LATO_BOLD);
        }
    }

    private void m10116l() {
        FontHelper.setTypeface(btUpgradeToPremiumButton, Fonts.LATO_BOLD);
        FontHelper.setTypeface(btMaybeLater, Fonts.LATO_BOLD);
    }

    @OnClick(R.id.button_upgrade_to_premium)
    void onButtonUpgradeClicked() {
        C2250f.m10263a().getInstance().mo7939b(UpgradeToProActivity.this);
    }

    @OnClick(R.id.button_maybe_later)
    void onButtonMaybeLaterClicked() {
        UpgradeToProActivity.this.onBackPressed();
    }
}
