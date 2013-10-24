package com.lingo.abacus.intellij.plugin.fitnesse.runner;

import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.process.DefaultJavaProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.vfs.VirtualFile;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseBundle;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseFileUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 27-Oct-2006 01:30:56
 */
public class FitnesseRunnableState implements PatchedRunnableState {
    private final RunnerSettings runnerSettings;
    private final ConfigurationPerRunnerSettings configurationSetting;
    private final FitnesseRunConfiguration configuration;
    private final Project project;
    private String debugPort = "";
    protected ArrayList<File> myFilesToDelete = new ArrayList<File>();
    private static final String WORKING_DIR_PREFIX = " -d ";
    private static final String ROOT_PREFIX = " -r ";
    private static final String PORT_PREFIX = " -p ";
    private static final String QUOTE = "\"";
    private Sdk projectJdk;

    public FitnesseRunnableState(RunnerSettings runnerSettings,
                                 ConfigurationPerRunnerSettings configurationSetting,
                                 FitnesseRunConfiguration configuration,
                                 Project project,
                                 Sdk projectJdk) {

        this.runnerSettings = runnerSettings;
        this.configurationSetting = configurationSetting;
        this.configuration = configuration;
        this.project = project;
        this.projectJdk = projectJdk;
    }

    @Nullable
    @Override
    public ExecutionResult execute(Executor executor, @NotNull ProgramRunner programRunner) throws ExecutionException {
        if (projectJdk == null) throw new ExecutionException(FitnesseBundle.message("run.configuration.invalid.jdk"));
        final ConsoleView console = TextConsoleBuilderFactory.getInstance().createBuilder(project).getConsole();
        final ProcessHandler processHandler = getExecutionProcess();


        console.attachToProcess(processHandler);
        ProcessTerminatedListener.attach(processHandler);
        return new DefaultExecutionResult(console,
                processHandler);

    }

    private ProcessHandler getExecutionProcess() throws ExecutionException {
        JavaParameters params = new JavaParameters();
        params.setMainClass(configuration.getMainClass());
        params.setJdk(projectJdk);
        params.setWorkingDirectory(configuration.getHomePath());
        setApplicationParameters(params);
        setClassPath(params);

        return new DefaultJavaProcessHandler(params);
    }

    private void setApplicationParameters(JavaParameters params) {
        final ParametersList list = params.getProgramParametersList();
        final VirtualFile root = FitnesseFileUtil.getVirtualFile(configuration.getRootPath());
        final int port = configuration.getPort();

        list.addParametersString(WORKING_DIR_PREFIX + QUOTE + root.getParent().getPath() + QUOTE + ROOT_PREFIX + QUOTE +
                root.getName() + QUOTE + PORT_PREFIX + port);
    }

    /**
     * Set classpath
     *
     * @param params
     */
    private void setClassPath(JavaParameters params) {
        final VirtualFile libs = FitnesseFileUtil.getVirtualFile(configuration.getLibPath());
        final VirtualFile home = FitnesseFileUtil.getVirtualFile(configuration.getHomePath());
        FitnesseFileUtil.addClathPath(params.getClassPath(), libs, FitnesseFileUtil.JAR_ZIP_FILTER);
        FitnesseFileUtil.addClathPath(params.getClassPath(), home, FitnesseFileUtil.FITNESSE_JAR_FILTER);
    }



    public RunnerSettings getRunnerSettings() {
        return runnerSettings;
    }

    public ConfigurationPerRunnerSettings getConfigurationSettings() {
        return configurationSetting;
    }


    public Module[] getModulesToCompile() {
        Module[] modules = configuration.getModules();
        if (modules == null) {
            return Module.EMPTY_ARRAY;
        } else {
            return modules;
        }
    }

    public RunnerSettings getPatcher() {
        return runnerSettings;
    }
}
