package com.lingo.abacus.intellij.plugin.fitnesse.language.parsing;

import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.lang.Language;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseWikiLanguageSupportLoader;
import org.jetbrains.annotations.NotNull;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 01-Oct-2006 22:19:27
 */
public class FitnessePSIFile extends PsiFileBase implements PsiElement {
    public FitnessePSIFile(FileViewProvider viewProvider, Language language) {
        super(viewProvider,language);
    }

    @NotNull
    public FileType getFileType() {
        return FitnesseWikiLanguageSupportLoader.FITNESSE;
    }

    public String toString() {
       return "FITNESSEFile:" + getName();
     }

     public boolean processDeclarations(PsiScopeProcessor processor,
                                        PsiSubstitutor substitutor,
                                        PsiElement lastParent,
                                        PsiElement place) {
       final PsiElement[] children = getChildren();
       for (PsiElement child : children) {
         if (child == lastParent) break;
         if (!child.processDeclarations(processor, (ResolveState) substitutor, lastParent, place)) return false;
       }
       return true;
     }

     public void accept(PsiElementVisitor visitor) {
       if (visitor instanceof FitnesseElementVisitor) {
         ((FitnesseElementVisitor)visitor).visitFitnesseElement(this); 
       }
       else {
         super.accept(visitor);
       }
     }
}
