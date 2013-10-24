package com.lingo.abacus.intellij.plugin.fitnesse.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.openapi.util.WriteExternalException;
import com.lingo.abacus.intellij.plugin.fitnesse.gui.FitnesseRunSettingsEditor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Fitnesse Configuration
 *
 * todo: default port value is not returned on creation of new window
 *
 * @Developer: florian
 * @Date: 25-Oct-2006 23:55:45
 */
public class FitnesseRunConfiguration extends RunConfigurationBase implements RunConfiguration, LocatableConfiguration {
    //editor settingsa
    public String homePath = "";
    public String rootPath = "";
    public String libPath = "";
    public String jdkHome;
    public String port ="8080";
    public String mainClass = "fitnesse.FitNesse";

    //context
    private Module myModule;
    private String myModuleName;
    private Sdk sdk;


    protected FitnesseRunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);

    }

    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new FitnesseRunSettingsEditor(getProject(), this);
    }

    public JDOMExternalizable createRunnerSettings(ConfigurationInfoProvider provider) {
        return null;
    }

    @Nullable
    @Override
    public SettingsEditor<JDOMExternalizable> getRunnerSettingsEditor(ProgramRunner programRunner) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    /**
     * this is called when run
     *
     * @param context
     * @param runnerInfo
     * @param runnerSettings
     * @param configurationSettings
     *
     * @return
     */
    public RunProfileState getState(DataContext context, RunnerInfo runnerInfo, RunnerSettings runnerSettings,
                                    ConfigurationPerRunnerSettings configurationSettings) throws ExecutionException {

        
        //just to throw execution exception
        return new FitnesseRunnableState(
                runnerSettings,
                configurationSettings,
                this,
                getProject(),
                sdk);

    }


    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void checkConfiguration() throws RuntimeConfigurationException {

    }


    public Module[] getModules() {
        List<Module> modules = new ArrayList<Module>();
        Module[] allModules = ModuleManager.getInstance(getProject()).getModules();
        for (Module module : allModules) {
            modules.add(module);
        }
        return modules.toArray(new Module[modules.size()]);
    }

    public boolean isGeneratedName() {
        return false;
    }

    public String suggestedName() {
        return "Fitnesse Server";
    }


    public String getHomePath() {
        return homePath;
    }

    public void setHomePath(String homePath) {
        this.homePath = homePath;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getLibPath() {
        return libPath;
    }

    public void setLibPath(String libPath) {
        this.libPath = libPath;
    }


    public int getPort() {
        return new Integer(port);
    }

    public void setPort(int port) {
        this.port = port+"";
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void readExternal(Object element) throws InvalidDataException {
        //DefaultJDOMExternalizer.readExternal(this, element);
    }

    public void writeExternal(Object element) throws WriteExternalException {
        //DefaultJDOMExternalizer.writeExternal(this, element);
    }

    /**
     *
     * @return null if no valid jdk has been registered
     */
    public Sdk getJdk() {
        if(sdk==null){
            registerJdkHome(jdkHome);
        }
        return sdk;
    }

    /**
     *
     * @param home if null no jdk is registered and getJDK will return null
     */
    public void registerJdkHome(String home) {
        jdkHome = home;
        if (home != null) {
            sdk = JavaSdk.getInstance().createJdk("FitnesseJdk", home, false);
        }
    }

    private class RunnerInfo {
    }
}
