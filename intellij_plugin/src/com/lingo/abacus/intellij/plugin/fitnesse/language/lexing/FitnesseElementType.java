package com.lingo.abacus.intellij.plugin.fitnesse.language.lexing;

import com.intellij.psi.tree.IElementType;
import com.intellij.lang.Language;

/**
 * Fitnesse Element Type
 *
 * @Developer: florian
 * @Date: 24-Sep-2006 17:06:26
 */
public class FitnesseElementType extends IElementType {
    /**
     * Creates and registers a new element type for the specified language.
     *
     * @param debugName the name of the element type, used for debugging purposes.
     * @param language  the language with which the element type is associated.
     */
    public FitnesseElementType(String debugName, Language language) {
        super(debugName, language);
    }


    public String toString() {
        return "FT:"+super.toString();
    }
}
