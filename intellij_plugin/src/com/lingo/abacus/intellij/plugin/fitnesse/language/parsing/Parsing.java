package com.lingo.abacus.intellij.plugin.fitnesse.language.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 01-Oct-2006 18:48:56
 */
public class Parsing {
    protected Parsing() {
    }

    protected static void checkMatches(final PsiBuilder builder, final IElementType token, final String message) {
        if (builder.getTokenType() == token) {
            builder.advanceLexer();
        } else {
            builder.error(message);
        }
    }
}
