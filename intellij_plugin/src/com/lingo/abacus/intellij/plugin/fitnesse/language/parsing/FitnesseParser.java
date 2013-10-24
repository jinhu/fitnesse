package com.lingo.abacus.intellij.plugin.fitnesse.language.parsing;

import com.intellij.lang.PsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.StatementParsing;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 01-Oct-2006 18:46:42
 */
public class FitnesseParser implements PsiParser {


    public ASTNode parse(IElementType root, PsiBuilder builder) {
       final PsiBuilder.Marker rootMarker = builder.mark();
       while (!builder.eof()) { 
         StatementParsing.parseSourceElement(builder);
       }
       rootMarker.done(root);
       return builder.getTreeBuilt();
     }
}
