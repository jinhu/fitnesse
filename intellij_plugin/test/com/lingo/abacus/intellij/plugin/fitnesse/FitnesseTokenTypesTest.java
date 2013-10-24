package com.lingo.abacus.intellij.plugin.fitnesse;
/**
 * Class Descriptio
 * @Developer: florian
 * @Date: 15-Oct-2006 17:04:12
 *
 */

import junit.framework.*;
import com.lingo.abacus.intellij.plugin.fitnesse.language.highlighting.FitnesseHighlighter;
import com.lingo.abacus.intellij.plugin.fitnesse.language.highlighting.FitnesseColorsAndFontsPage;
import com.intellij.psi.tree.IElementType;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;

import java.util.Map;
import java.util.Iterator;

public class FitnesseTokenTypesTest extends TestCase {
    FitnesseColorsAndFontsPage page;
    private static AttributesDescriptor[] ATTRS;

    protected void setUp() throws Exception {
        super.setUp();
        page = new FitnesseColorsAndFontsPage();
        ATTRS =page.getAttributeDescriptors();
    }

    public void TestTokenTypes(){
        FitnesseHighlighter fh = new FitnesseHighlighter();
        Map<IElementType,TextAttributesKey> keys1 = fh.getKeys1();
        Iterator<TextAttributesKey> types = keys1.values().iterator();
        while (types.hasNext()) {
            TextAttributesKey type = types.next();
            for (int i = 0; i < ATTRS.length; i++) {
                AttributesDescriptor descriptor = ATTRS[i];
                assertEquals("attribuute key missing",descriptor.getKey(),type);

            }
        }

    }

}