package com.lingo.abacus.intellij.plugin.fitnesse.gui;

import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseWikiLanguageSupportLoader;
import com.lingo.abacus.intellij.plugin.fitnesse.Chooser;
import com.intellij.openapi.fileChooser.FileChooserFactory;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDialog;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VirtualFile;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

/**
 * Fitnesse Integration Plugin Configuration.
 *
 * Enable / Disable .txt file parsing.
 *
 * @Developer: florian
 * @Date: 16-Oct-2006 23:05:02
 */
public class FitnesseConfiguration {
    private JCheckBox enable;

    private JPanel rootComponent;

    public FitnesseConfiguration() {


    }

    public JComponent getRootComponent() {
        return rootComponent;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.add(new FitnesseConfiguration().getRootComponent());
        frame.pack();
        frame.setVisible(true);
    }

    public void setData(FitnesseWikiLanguageSupportLoader data) {
        enable.setSelected(data.isParsingEnabled());

    }

    public void getData(FitnesseWikiLanguageSupportLoader data) {
        data.setParsingEnabled(enable.isSelected());

    }

    public boolean isModified(FitnesseWikiLanguageSupportLoader data) {
        if (enable.isSelected() != data.isParsingEnabled()) return true;
        return false;
    }


}
