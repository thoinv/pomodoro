package com.afollestad.materialdialogs.folderselector;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.View;
import android.webkit.MimeTypeMap;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileChooserDialog extends DialogFragment implements MaterialDialog.ListCallback {

    private final static String DEFAULT_TAG = "[MD_FILE_SELECTOR]";

    private File parentFolder;
    private File[] parentContents;
    private boolean canGoUp = true;
    private FileCallback mCallback;

    public interface FileCallback {
        void onFileSelection(@NonNull FileChooserDialog dialog, @NonNull File file);
    }

    public FileChooserDialog() {
    }

    String[] getContentsArray() {
        if (parentContents == null) return new String[]{};
        String[] results = new String[parentContents.length + (canGoUp ? 1 : 0)];
        if (canGoUp) results[0] = "...";
        for (int i = 0; i < parentContents.length; i++)
            results[canGoUp ? i + 1 : i] = parentContents[i].getName();
        return results;
    }

    File[] listFiles(String mimeType) {
        File[] contents = parentFolder.listFiles();
        List<File> results = new ArrayList<>();
        if (contents != null) {
            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
            for (File fi : contents) {
                if (fi.isDirectory()) {
                    results.add(fi);
                } else {
                    if (fileIsMimeType(fi, mimeType, mimeTypeMap)) {
                        results.add(fi);
                    }
                }
            }
            Collections.sort(results, new FileSorter());
            return results.toArray(new File[results.size()]);
        }
        return null;
    }

    boolean fileIsMimeType(File file, String mimeType, MimeTypeMap mimeTypeMap) {
        if (mimeType == null || mimeType.equals("*/*")) {
            return true;
        } else {
            // get the file mime type
            String filename = file.toURI().toString();
            int dotPos = filename.lastIndexOf('.');
            if (dotPos == -1) {
                return false;
            }
            String fileExtension = filename.substring(dotPos + 1);
            String fileType = mimeTypeMap.getMimeTypeFromExtension(fileExtension);
            if (fileType == null) {
                return false;
            }
            // check the 'type/subtype' pattern
            if (fileType.equals(mimeType)) {
                return true;
            }
            // check the 'type/*' pattern
            int mimeTypeDelimiter = mimeType.lastIndexOf('/');
            if (mimeTypeDelimiter == -1) {
                return false;
            }
            String mimeTypeMainType = mimeType.substring(0, mimeTypeDelimiter);
            String mimeTypeSubtype = mimeType.substring(mimeTypeDelimiter + 1);
            if (!mimeTypeSubtype.equals("*")) {
                return false;
            }
            int fileTypeDelimiter = fileType.lastIndexOf('/');
            if (fileTypeDelimiter == -1) {
                return false;
            }
            String fileTypeMainType = fileType.substring(0, fileTypeDelimiter);
            if (fileTypeMainType.equals(mimeTypeMainType)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("ConstantConditions")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
            return new MaterialDialog.Builder(getActivity())
                    .title(R.string.md_error_label)
                    .content(R.string.md_storage_perm_error)
                    .positiveText(android.R.string.ok)
                    .build();
        }

        if (getArguments() == null || !getArguments().containsKey("builder"))
            throw new IllegalStateException("You must create a FileChooserDialog using the Builder.");
        if (!getArguments().containsKey("current_path"))
            getArguments().putString("current_path", getBuilder().mInitialPath);
        parentFolder = new File(getArguments().getString("current_path"));
        parentContents = listFiles(getBuilder().mMimeType);
        return new MaterialDialog.Builder(getActivity())
                .title(parentFolder.getAbsolutePath())
                .items(getContentsArray())
                .itemsCallback(this)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .autoDismiss(false)
                .negativeText(getBuilder().mCancelButton)
                .positiveText(getBuilder().mChooseButton)
                .build();
    }

    @Override
    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence s) {
        if (canGoUp && i == 0) {
            parentFolder = parentFolder.getParentFile();
            if (parentFolder.getAbsolutePath().equals("/storage/emulated"))
                parentFolder = parentFolder.getParentFile();
            canGoUp = parentFolder.getParent() != null;
        } else {
            parentFolder = parentContents[canGoUp ? i - 1 : i];
            canGoUp = true;
            if (parentFolder.getAbsolutePath().equals("/storage/emulated"))
                parentFolder = Environment.getExternalStorageDirectory();
        }
        if (parentFolder.isFile()) {
            mCallback.onFileSelection(this, parentFolder);
            dismiss();
        } else {
            parentContents = listFiles(getBuilder().mMimeType);
            MaterialDialog dialog = (MaterialDialog) getDialog();
            dialog.setTitle(parentFolder.getAbsolutePath());
            getArguments().putString("current_path", parentFolder.getAbsolutePath());
            dialog.setItems(getContentsArray());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (FileCallback) activity;
    }

    public void show(FragmentActivity context) {
        final String tag = getBuilder().mTag;
        Fragment frag = context.getSupportFragmentManager().findFragmentByTag(tag);
        if (frag != null) {
            ((DialogFragment) frag).dismiss();
            context.getSupportFragmentManager().beginTransaction()
                    .remove(frag).commit();
        }
        show(context.getSupportFragmentManager(), tag);
    }

    public static class Builder implements Serializable {

        @NonNull
        protected final transient AppCompatActivity mContext;
        @StringRes
        protected int mChooseButton;
        @StringRes
        protected int mCancelButton;
        protected String mInitialPath;
        protected String mMimeType;
        protected String mTag;

        public <ActivityType extends AppCompatActivity & FileCallback> Builder(@NonNull ActivityType context) {
            mContext = context;
            mCancelButton = android.R.string.cancel;
            mChooseButton = R.string.md_choose_label;
            mInitialPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            mMimeType = null;
        }

        @NonNull
        public Builder cancelButton(@StringRes int text) {
            mCancelButton = text;
            return this;
        }

        @NonNull
        public Builder chooseButton(@StringRes int text) {
            mChooseButton = text;
            return this;
        }

        @NonNull
        public Builder initialPath(@Nullable String initialPath) {
            if (initialPath == null)
                initialPath = File.separator;
            mInitialPath = initialPath;
            return this;
        }

        @NonNull
        public Builder mimeType(@Nullable String type) {
            mMimeType = type;
            return this;
        }

        @NonNull
        public Builder tag(@Nullable String tag) {
            if (tag == null)
                tag = DEFAULT_TAG;
            mTag = tag;
            return this;
        }

        @NonNull
        public FileChooserDialog build() {
            FileChooserDialog dialog = new FileChooserDialog();
            Bundle args = new Bundle();
            args.putSerializable("builder", this);
            dialog.setArguments(args);
            return dialog;
        }

        @NonNull
        public FileChooserDialog show() {
            FileChooserDialog dialog = build();
            dialog.show(mContext);
            return dialog;
        }
    }

    @NonNull
    public String getInitialPath() {
        return getBuilder().mInitialPath;
    }

    @SuppressWarnings("ConstantConditions")
    @NonNull
    private Builder getBuilder() {
        return (Builder) getArguments().getSerializable("builder");
    }

    private static class FileSorter implements Comparator<File> {
        @Override
        public int compare(File lhs, File rhs) {
            if (lhs.isDirectory() && !rhs.isDirectory()) {
                return -1;
            } else if (!lhs.isDirectory() && rhs.isDirectory()) {
                return 1;
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        }
    }
}