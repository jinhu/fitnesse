package com.lingo.abacus.intellij.plugin.fitnesse.language.filetype;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseBundle;
import com.lingo.abacus.intellij.plugin.fitnesse.language.FitnesseLanguage;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnessePluginResources;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 24-Sep-2006 15:38:59
 */
public class FitnesseFileType extends LanguageFileType {


    public FitnesseFileType() {
        super(new FitnesseLanguage(FitnessePluginResources.getFitnessePluginName()));
    }

    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     *
     * @return The file type name.
     */

    @NotNull
    @NonNls
    public String getName() {
        return FitnessePluginResources.getFitnessePluginName();
    }

    /**
     * Returns the user-readable description of the file type.
     *
     * @return The file type description.
     */

    @NotNull
    public String getDescription() {
        return FitnesseBundle.message("fitnesse.filetype.description");
    }

    /**
     * Returns the default extension for files of the type.
     *
     * @return The extension, not including the leading '.'.
     */

    @NotNull
    @NonNls
    public String getDefaultExtension() {
        return "txt";
    }

    /**
     * Returns the icon used for showing files of the type.
     *
     * @return The icon instance, or null if no icon should be shown.
     */

    @Nullable
    public Icon getIcon() {
        return FitnessePluginResources.getSmallIcon();
    }


}
