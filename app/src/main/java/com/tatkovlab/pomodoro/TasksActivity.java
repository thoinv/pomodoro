package com.tatkovlab.pomodoro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.afollestad.materialdialogs.C1164b;
import com.afollestad.materialdialogs.MaterialDialog.C1174a;
import com.afollestad.materialdialogs.C1169f.C1178e;
import com.afollestad.materialdialogs.C1169f.C1183j;
import com.afollestad.materialdialogs.C1194i;
import com.tatkovlab.pomodoro.p075a.C2205a;
import com.tatkovlab.pomodoro.p075a.C2205a.C2207a;
import com.tatkovlab.pomodoro.p075a.C2205a.C2208b;
import com.tatkovlab.pomodoro.p076b.C2220c;
import com.tatkovlab.pomodoro.p076b.C2223f;
import com.tatkovlab.pomodoro.p076b.C2223f.C2226b;
import com.tatkovlab.pomodoro.p078d.C2236b;
import com.tatkovlab.pomodoro.p078d.C2236b.C2237a;
import com.tatkovlab.pomodoro.p079e.C2250f;
import com.tatkovlab.pomodoro.p079e.C2258j;
import com.tatkovlab.pomodorolite.R;
import com.woxthebox.draglistview.DragListView;
import com.woxthebox.draglistview.DragListView.DragListListener;
import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends C2204a {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public DragListView f6465j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C2205a f6466k;

    /* renamed from: l */
    private MaterialDialog f6467l;

    /* renamed from: m */
    private MaterialDialog f6468m;

    /* renamed from: n */
    private View f6469n;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_tasks);
        m10101k();
        m10102l();
        m10104n();
        m10105o();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m10106p();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.f6467l != null && this.f6467l.isShowing()) {
            this.f6467l.dismiss();
        }
        if (this.f6468m != null && this.f6468m.isShowing()) {
            this.f6468m.dismiss();
        }
    }

    /* renamed from: k */
    private void m10101k() {
        C2236b.m10219a((TextView) findViewById(R.id.text_header), C2237a.LATO_BOLD);
    }

    /* renamed from: l */
    private void m10102l() {
        this.f6469n = findViewById(R.id.placeholder_no_tasks);
        C2236b.m10219a((TextView) findViewById(R.id.placeholder_no_tasks_text), C2237a.PANGOLIN_REGULAR);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m10103m() {
        int i = 0;
        boolean z = this.f6466k == null || this.f6466k.getItemCount() == 0;
        View view = this.f6469n;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* renamed from: n */
    private void m10104n() {
        findViewById(R.id.add_task_btn).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TasksActivity.this.startActivity(new Intent(TasksActivity.this, AddTaskActivity.class));
            }
        });
    }

    /* renamed from: o */
    private void m10105o() {
        this.f6465j = (DragListView) findViewById(R.id.tasks_list);
        this.f6465j.setLayoutManager(new LinearLayoutManager(this));
        this.f6465j.setCanDragHorizontally(false);
        this.f6466k = new C2205a(new ArrayList(), R.layout.list_item_task, R.id.drag_handle, false);
        this.f6465j.setAdapter(this.f6466k, true);
        this.f6465j.setDragListListener(new DragListListener() {
            public void onItemDragStarted(int i) {
            }

            public void onItemDragging(int i, float f, float f2) {
            }

            public void onItemDragEnded(int i, int i2) {
                long currentTimeMillis = System.currentTimeMillis();
                List itemList = TasksActivity.this.f6466k.getItemList();
                for (int i3 = 0; i3 < itemList.size(); i3++) {
                    C2223f fVar = (C2223f) itemList.get(i3);
                    fVar.mo7897b(currentTimeMillis);
                    TasksActivity.this.m10107q().mo7989e(fVar);
                    currentTimeMillis--;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10091b(C2223f fVar) {
        m10107q().mo7985a(fVar);
        onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10094c(final C2223f fVar) {
        this.f6467l = new C1174a(this).mo5488a((CharSequence) fVar.mo7898c()).mo5487a(C1194i.LIGHT).mo5501e(R.array.task_long_press_options).mo5485a((C1178e) new C1178e() {
            /* renamed from: a */
            public void mo5518a(MaterialDialog fVar, View view, int i, CharSequence charSequence) {
                switch (i) {
                    case 0:
                        TasksActivity.this.m10099e(fVar);
                        return;
                    case 1:
                        TasksActivity.this.m10100f(fVar);
                        return;
                    case 2:
                        TasksActivity.this.mo7845a(fVar);
                        return;
                    default:
                        return;
                }
            }
        }).mo5498c();
    }

    /* renamed from: a */
    public void mo7845a(final C2223f fVar) {
        this.f6468m = new MaterialDialog(this).mo5488a((CharSequence) getString(R.string.delete_task_confirmation_header)).mo5494b((CharSequence) getString(R.string.delete_task_confirmation_body, new Object[]{fVar.mo7898c()})).mo5499d((int) R.drawable.dialog_delete).mo5504h(R.string.delete_task_confirmation_confirm).mo5502f(R.string.delete_task_confirmation_cancel).mo5487a(C1194i.LIGHT).mo5486a((C1183j) new C1183j() {
            /* renamed from: a */
            public void mo5522a(MaterialDialog fVar, C1164b bVar) {
                TasksActivity.this.m10097d(fVar);
            }
        }).mo5498c();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10097d(C2223f fVar) {
        this.f6466k.getItemList().remove(fVar);
        this.f6466k.notifyDataSetChanged();
        m10107q().mo7988d(fVar);
        m10103m();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10099e(C2223f fVar) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        intent.putExtra("edit_task_key", fVar);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10100f(C2223f fVar) {
        m10107q().mo7987c(fVar);
        m10106p();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10088a(boolean z, int i) {
        C2223f fVar = (C2223f) this.f6466k.getItemList().get(i);
        fVar.mo7894a(z ? C2226b.FINISHED : C2226b.NEW);
        m10107q().mo7989e(fVar);
        this.f6466k.notifyDataSetChanged();
    }

    /* renamed from: p */
    private void m10106p() {
        m10107q().mo7984a((C2220c<C2223f>) new C2220c<C2223f>() {
            /* renamed from: a */
            public void mo7850a(List<C2223f> list) {
                TasksActivity.this.f6466k = new C2205a(list, R.layout.list_item_task, R.id.drag_handle, false);
                TasksActivity.this.f6466k.mo7859a((C2207a) new C2207a() {
                    /* renamed from: a */
                    public void mo7851a(C2223f fVar) {
                        TasksActivity.this.m10091b(fVar);
                    }
                });
                TasksActivity.this.f6466k.mo7862b((C2207a) new C2207a() {
                    /* renamed from: a */
                    public void mo7851a(C2223f fVar) {
                        TasksActivity.this.m10094c(fVar);
                    }
                });
                TasksActivity.this.f6466k.mo7860a((C2208b) new C2208b() {
                    /* renamed from: a */
                    public void mo7852a(boolean z, int i) {
                        TasksActivity.this.m10088a(z, i);
                    }
                });
                TasksActivity.this.f6465j.setAdapter(TasksActivity.this.f6466k, true);
                TasksActivity.this.m10103m();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public C2258j m10107q() {
        return C2250f.m10263a().mo7964f();
    }
}
