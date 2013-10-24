package com.lingo.abacus.intellij.plugin.fitnesse.language.filetype;

import com.intellij.openapi.fileTypes.FileNameMatcher;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 18-Oct-2006 23:26:54
 */
public class FitnesseMatcher implements FileNameMatcher {
    public boolean accept(@NonNls @NotNull String fileName) {
        String[] elements = fileName.split("\\.");
        if (elements != null && elements.length>0 && elements[elements.length-1].equals("txt")) {
            return true;
        } else {
            return false;
        }
    }

    @NonNls
    @NotNull
    public String getPresentableString() {
        return null;
    }

    public static List<FileNameMatcher> getList() {
        ArrayList list = new ArrayList(1);
        list.add(new FitnesseMatcher());
        return list;
    }
}
