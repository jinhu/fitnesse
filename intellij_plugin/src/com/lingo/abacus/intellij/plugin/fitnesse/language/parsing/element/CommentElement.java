package com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.element;

import com.intellij.psi.PsiElementVisitor;
import com.intellij.lang.ASTNode;
import com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.FitnesseElementVisitor;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 04-Oct-2006 20:41:33
 */
public class CommentElement extends FitnesseElement {
    public CommentElement(ASTNode node) {
        super(node);
    }


    public void accept(PsiElementVisitor visitor) {
        if (visitor instanceof FitnesseElementVisitor) {
            ((FitnesseElementVisitor) visitor).visitCommentElement(this);
        } else {
            super.accept(visitor);
        }
    }
}
