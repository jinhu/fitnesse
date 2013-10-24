package com.lingo.abacus.intellij.plugin.fitnesse;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

import com.intellij.CommonBundle;

public class FitnesseBundle {
    private static Reference<ResourceBundle> ourBundle;

    @NonNls
    private static final String BUNDLE = "com.lingo.abacus.intellij.plugin.fitnesse.FitnesseBundle";

    private FitnesseBundle() {
    }

    public static String message(@NonNls
    @PropertyKey(resourceBundle = BUNDLE)String key,
                                 Object... params) {
        return CommonBundle.message(FitnesseBundle.getBundle(), key, params);
    }

    private static ResourceBundle getBundle() {
        ResourceBundle bundle = null;
        if (FitnesseBundle.ourBundle != null) bundle = FitnesseBundle.ourBundle.get();
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(FitnesseBundle.BUNDLE);
            FitnesseBundle.ourBundle = new SoftReference<ResourceBundle>(bundle);
        }
        return bundle;
    }
}
