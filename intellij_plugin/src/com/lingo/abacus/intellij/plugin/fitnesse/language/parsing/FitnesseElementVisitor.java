package com.lingo.abacus.intellij.plugin.fitnesse.language.parsing;

import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReferenceExpression;
import com.intellij.psi.PsiElement;
import com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.element.FitnesseElement;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 01-Oct-2006 22:22:02
 */
public class FitnesseElementVisitor extends PsiElementVisitor {
    /**
     * PsiReferenceExpression is PsiReferenceElement and PsiExpression at the same time. If we'd call both
     * visitReferenceElement and visitExpression in default implementation of this method we can easily stuck with
     * exponential algorithm if the derived visitor extends visitElement() and accepts children there.
     * PsiRecursiveElement visitor works that around and implements this method accordingly. All other visitor must
     * decide themselves what implementation (visitReferenceElement() or visitExpreission() or non or LOG.error()) is
     * appropriate for them.
     *
     * @param expression
     */
    public void visitReferenceExpression(PsiReferenceExpression expression) {
        visitExpression(expression);
    }

    private void visitExpression(PsiReferenceExpression expression) {
        //To change body of created methods use File | Settings | File Templates.
    }


    public void visitCommentElement(FitnesseElement fitnesse) {
     visitElement(fitnesse);
    }

    public void visitFitnesseElement(PsiElement fitnesseFile) {
      visitElement(fitnesseFile);
        
    }
}
