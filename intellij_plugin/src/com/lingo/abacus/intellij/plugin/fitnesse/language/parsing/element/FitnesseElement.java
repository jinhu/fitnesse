package com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.element;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseWikiLanguageSupportLoader;
import com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.FitnesseElementVisitor;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 04-Oct-2006 21:20:11
 */
public abstract class FitnesseElement extends ASTWrapperPsiElement implements PsiElement {
    public FitnesseElement(ASTNode node) {
        super(node);
    }

     public Language getLanguage() {
       return FitnesseWikiLanguageSupportLoader.FITNESSE.getLanguage();
     }

     public void accept(PsiElementVisitor visitor) {
       if (visitor instanceof FitnesseElementVisitor) {
         ((FitnesseElementVisitor)visitor).visitFitnesseElement(this);
       }
       else {
         super.accept(visitor);
       }
     }

     public SearchScope getUseScope() {
       //This is true as long as we have no inter-file references
       return new LocalSearchScope(getContainingFile());
     }
}
