package com.lingo.abacus.intellij.plugin.fitnesse.gui;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.lingo.abacus.intellij.plugin.fitnesse.Chooser;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseFileUtil;
import com.lingo.abacus.intellij.plugin.fitnesse.runner.FitnesseRunConfiguration;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Editor Configuration
 *
 * todo: change selection of jdk using alrady configured jdks
 *
 * @Developer: florian
 * @Date: 27-Oct-2006 00:04:11
 */
public class FitnesseRunSettingsEditor extends SettingsEditor<FitnesseRunConfiguration> {
    //GUI Elements
    private JPanel rootComponent;
    private JTextField home;
    private JButton homeChooserBtn;
    private JTextField root;
    private JButton rootChooserBtn;
    private JTextField lib;
    private JButton libChooserBtn;
    private JTextField jdk;
    private JButton jdkBtn;
    private JTextField port;
    private JTextField mainClass;

    //Context
    private RunConfiguration config;
    private Project project;
    private FitnesseRunConfiguration configuration;

    /**
     * Constructor
     *
     * @param project
     * @param configuration
     */
    public FitnesseRunSettingsEditor(Project project, FitnesseRunConfiguration configuration) {
        this.project = project;
        this.configuration = configuration;

        rootChooserBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ApplicationManager.getApplication()
                            .invokeLater(new Chooser(root, mouseEvent), ModalityState.defaultModalityState());
                    ApplicationManager.getApplication().invokeLater(new Runnable() {
                        public void run() {
                            final String parent = FitnesseFileUtil.getVirtualFile(root.getText()).getParent().getPath();
                            if (home.getText() == null || home.getText().equals("")) {
                                home.setText(parent);
                            }
                            if(lib.getText() == null || lib.getText().equals(""))
                            lib.setText(parent + System.getProperty("seperator")+"lib");
                        }
                    });
                }
            }
        });

        homeChooserBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ApplicationManager.getApplication()
                            .invokeLater(new Chooser(home, mouseEvent), ModalityState.defaultModalityState());
                }
            }
        });

        libChooserBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ApplicationManager.getApplication()
                            .invokeLater(new Chooser(lib, mouseEvent), ModalityState.defaultModalityState());
                }
            }
        });
        jdkBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ApplicationManager.getApplication()
                            .invokeLater(new Chooser(jdk, mouseEvent), ModalityState.defaultModalityState());
                }
            }
        });
    }


    protected void resetEditorFrom(FitnesseRunConfiguration conf) {
        home.setText(conf.getHomePath());
        root.setText(conf.getRootPath());
        lib.setText(conf.getLibPath());

        Sdk projectJdk = conf.getJdk();
        if (projectJdk != null) {
            jdk.setText(projectJdk.getHomeDirectory().getPath());
        } else{
            jdk.setText("");
        }
        port.setText(conf.getPort()+"");
        mainClass.setText((conf.getMainClass()));
    }

    protected void applyEditorTo(FitnesseRunConfiguration conf) throws ConfigurationException {
        try {
            conf.setHomePath(home.getText());
            conf.setRootPath(root.getText());
            conf.setLibPath(lib.getText());
            conf.registerJdkHome(jdk.getText());
            conf.setPort(new Integer(port.getText()));
            conf.setMainClass(mainClass.getText());
        } catch (NumberFormatException e) {
            //otherwise there is no real problem... just a parsing problem
            if (port.getText() != null && port.getText() != "") {
                throw new ConfigurationException("port is not set correctly");
            }
        }
    }

    @NotNull
    protected JComponent createEditor() {
        return rootComponent;
    }

    protected void disposeEditor() {

    }


}
