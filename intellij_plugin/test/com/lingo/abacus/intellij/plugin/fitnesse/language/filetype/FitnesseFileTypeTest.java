package com.lingo.abacus.intellij.plugin.fitnesse.language.filetype;
/**
 * Class Descriptio
 * @Developer: florian
 * @Date: 16-Oct-2006 21:04:52
 *
 */

import junit.framework.*;
import com.lingo.abacus.intellij.plugin.fitnesse.language.filetype.FitnesseFileType;

import javax.swing.*;

public class FitnesseFileTypeTest extends TestCase {
    FitnesseFileType filetype;

    protected void setUp() throws Exception {
        super.setUp();
        filetype = new FitnesseFileType();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        filetype = null;
    }

    public void testGetIcon() throws Exception {
        Icon icon = filetype.getIcon();

        assertTrue(icon.getIconHeight()>0);
    }
}