package com.lingo.abacus.intellij.plugin.fitnesse.language.lexing;

import com.intellij.lexer.FlexAdapter;


/**
 * Adapter for JFlex generated Lexer
 *
 * @Developer: florian
 * @Date: 24-Sep-2006 18:29:59
 */
public class FitnesseLexer extends FlexAdapter {
    public FitnesseLexer() {
        super(new GeneratedFitnesseLexer());
    }
}
