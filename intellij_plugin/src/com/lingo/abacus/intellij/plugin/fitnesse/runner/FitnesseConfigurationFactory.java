package com.lingo.abacus.intellij.plugin.fitnesse.runner;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnessePluginResources;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 26-Oct-2006 01:28:48
 */
public class FitnesseConfigurationFactory extends ConfigurationFactory {
    public FitnesseConfigurationFactory(FitnesseRunConfigurationType type) {
        super(type);
    }

    public RunConfiguration createTemplateConfiguration(Project project) {
        return new FitnesseRunConfiguration(project,this, FitnessePluginResources.getFitnessePluginName());  
    }
}
