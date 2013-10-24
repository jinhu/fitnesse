package com.lingo.abacus.intellij.plugin.fitnesse;

import com.intellij.openapi.fileChooser.FileChooserDialog;
import com.intellij.openapi.fileChooser.FileChooserFactory;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.project.ProjectManager;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.*;

/**
 * Class Descriptio
*
* @Developer: florian
* @Date: 25-Oct-2006 23:38:28
*/
public class Chooser implements Runnable {
    private JTextField fieldToUpdate;
    private MouseEvent mouseEvent;

    public Chooser(JTextField field, MouseEvent mouseEvent) {
        this.mouseEvent = mouseEvent;
        this.fieldToUpdate = field;
    }

    public void run() {
        Component parent = (Component) mouseEvent.getSource();
        FileChooserDialog dialog = FileChooserFactory.getInstance()
                .createFileChooser(
                        new FileChooserDescriptor(false, true, false, false, false, false),
                        parent);

        VirtualFile[] files = dialog.choose(null, ProjectManager.getInstance().getDefaultProject());
        if (files.length>0) {
            VirtualFile homeLocation = files[0];

            fieldToUpdate.setText(homeLocation.getPath());
        }

    }
}
