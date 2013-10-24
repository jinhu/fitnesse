package com.lingo.abacus.intellij.plugin.fitnesse;

import com.intellij.openapi.util.IconLoader;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseBundle;

import javax.swing.*;
import java.net.URL;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 26-Oct-2006 00:20:22
 */
public class FitnessePluginResources {
    private static final String FITNESSE_PLUGIN_NAME = "FitNesse Integration";

    public static Icon getSmallIcon() {
        URL resource = FitnessePluginResources.class.getClassLoader().getResource("com/lingo/abacus/intellij/plugin/fitnesse/fitnesse.png");
        return IconLoader.getIcon(new ImageIcon(resource, FITNESSE_PLUGIN_NAME).getImage());
    }
    public static Icon getSettingsIcon(){
        URL resource = FitnessePluginResources.class.getClassLoader()
                .getResource("com/lingo/abacus/intellij/plugin/fitnesse/fitnesse_settings.png");
        return IconLoader.getIcon(new ImageIcon(resource, FITNESSE_PLUGIN_NAME).getImage());
    }

    public static String getFitnessePluginName() {
        return FitnesseBundle.message("fitnesse.plugin.name");
    }

    public static String getFitnessePluginDescription() {
        return FitnesseBundle.message("fitnesse.plugin.description");
    }
}
