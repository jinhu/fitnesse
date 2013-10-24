package com.lingo.abacus.intellij.plugin.fitnesse.runner;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnessePluginResources;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Fitnesse Server Configuration Type
 *
 * @Developer: florian
 * @Date: 26-Oct-2006 00:17:26
 */
public class FitnesseRunConfigurationType implements ConfigurationType {
    private final ConfigurationFactory myFactory;

    public FitnesseRunConfigurationType() {
        myFactory = new FitnesseConfigurationFactory(this);
    }


    public String getDisplayName() {
        return FitnessePluginResources.getFitnessePluginName();
    }

    public String getConfigurationTypeDescription() {
        return FitnessePluginResources.getFitnessePluginDescription();
    }

    public Icon getIcon() {
        return FitnessePluginResources.getSmallIcon();
    }

    @NotNull
    @Override
    public String getId() {
        return "12345667834523542";
    }

    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{myFactory};
    }

    /**
     * Unique name of this component. If there is another component with the same name or name is null internal
     * assertion will occur.
     *
     * @return the name of this component
     */
    @NonNls
    @NotNull
    public String getComponentName() {
        return FitnessePluginResources.getFitnessePluginName() + ":RunConfigurationType";
    }

    /**
     * Component should do initialization and communication with another components in this method.
     */
    public void initComponent() {

    }

    /**
     * Component should dispose system resources or perform another cleanup in this method.
     */
    public void disposeComponent() {

    }
}
