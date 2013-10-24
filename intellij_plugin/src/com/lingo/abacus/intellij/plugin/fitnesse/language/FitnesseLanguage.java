package com.lingo.abacus.intellij.plugin.fitnesse.language;

import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.lingo.abacus.intellij.plugin.fitnesse.language.highlighting.FitnesseHighlighter;
import com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.FitnesseParserDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 24-Sep-2006 15:47:50
 */
public class FitnesseLanguage extends Language {
    public FitnesseLanguage(String id) {
        super(id);
    }



    /**
     * Override this method to provide syntax highlighting (coloring) capabilities for your language implementation. By
     * syntax highlighting we mean highlighting of keywords, comments, braces etc. where lexing the file content is enough
     * to identify proper highlighting attributes.
     * <p/>
     * Default implementation doesn't highlight anything.
     *
     * @param project     might be necessary to gather various project settings from.
     * @param virtualFile might be necessary to collect file specific settings
     *
     * @return <code>FitnesseHighlighter</code> interface implementation for this particular language.
     */
    @NotNull
    public SyntaxHighlighter getSyntaxHighlighter(Project project, final VirtualFile virtualFile) {
        return new FitnesseHighlighter();
    }


    /**
     * Override this method to provide parsing implementation. Parsed tree (AST) and program structure interface (PSI)
     * based on AST is necessary for most of IDEA smart functions like in-editor error highlighting, advanced syntax
     * highlighting, error-checking, intention actions, inspections, folding, finding usages, refactoring, file structure
     * view etc.
     *
     * @return <code>ParserDefinition</code> interface implementation for this particular language or <code>null</code> if
     *         no parsing capabilities provided.
     */
    @Nullable
    public ParserDefinition getParserDefinition() {
        return new FitnesseParserDefinition();
    }
}
