package com.tatkovlab.pomodoro.p078d;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class FontHelper {

    private static Map<Fonts, Typeface> fonts = new HashMap();

    public enum Fonts {
        LATO_BOLD("Lato-Bold.ttf"),
        PANGOLIN_REGULAR("Pangolin-Regular.ttf");


        private String fontFileName;

        Fonts(String str) {
            this.fontFileName = str;
        }

        public String getFontFileName() {
            return this.fontFileName;
        }
    }

    public static void setTypeface(TextView textView, Fonts aVar) {
        textView.setTypeface(createTypefaceFromAsset(aVar, textView.getContext()));
    }

    private static Typeface createTypefaceFromAsset(Fonts aVar, Context context) {
        Typeface typeface = fonts.get(aVar);
        if (typeface != null) {
            return typeface;
        }
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), aVar.getFontFileName());
        fonts.put(aVar, createFromAsset);
        return createFromAsset;
    }
}
