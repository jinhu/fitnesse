package com.lingo.abacus.intellij.plugin.fitnesse.language.parsing;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.lingo.abacus.intellij.plugin.fitnesse.language.FitnesseTokenTypes;
import com.lingo.abacus.intellij.plugin.fitnesse.language.lexing.FitnesseLexer;
import com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.element.CommentElement;
import com.lingo.abacus.intellij.plugin.fitnesse.language.parsing.element.TableElement;
import org.jetbrains.annotations.NotNull;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 01-Oct-2006 17:41:45
 */
public class FitnesseParserDefinition implements ParserDefinition {
    /**
     * Returns the lexing for lexing files in the specified project. This lexing does not need to support incremental
     * relexing - it is always called for the entire file.
     *
     * @param project the project to which the lexing is connected.
     *
     * @return the lexing instance.
     */
    @NotNull
    public Lexer createLexer(Project project) {
        return new FitnesseLexer();
    }

    /**
     * Returns the parsing for parsing files in the specified project.
     *
     * @param project the project to which the parsing is connected.
     *
     * @return the parsing instance.
     */
    public PsiParser createParser(Project project) {
        return new FitnesseParser();
    }

    /**
     * Returns the element type of the node describing a file in the specified language.
     *
     * @return the file node element type.
     */
    public IFileElementType getFileNodeType() {
        return FitnesseTokenTypes.FILE;
    }

    /**
     * Returns the set of token types which are treated as whitespace by the PSI builder. Tokens of those types are
     * automatically skipped by PsiBuilder. Whitespace elements on the bounds of nodes built by PsiBuilder are
     * automatically excluded from the text range of the nodes.
     *
     * @return the set of whitespace token types.
     */
    @NotNull
    public TokenSet getWhitespaceTokens() {
        return TokenSet.create(FitnesseTokenTypes.WHITE_SPACE);
    }

    /**
     * Returns the set of token types which are treated as comments by the PSI builder. Tokens of those types are
     * automatically skipped by PsiBuilder. Also, To Do patterns are searched in the text of tokens of those types.
     *
     * @return the set of comment token types.
     */
    @NotNull
    public TokenSet getCommentTokens() {
        return FitnesseTokenTypes.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Creates a PSI element for the specified AST node. The AST tree is a simple, semantic-free tree of AST nodes which
     * is built during the PsiBuilder parsing pass. The PSI tree is built over the AST tree and includes elements of
     * different types for different language constructs.
     *
     * @param node the node for which the PSI element should be returned.
     *
     * @return the PSI element matching the element type of the AST node.
     */
    @NotNull
    public PsiElement createElement(ASTNode node) {
        IElementType type = node.getElementType();
        if (type == FitnesseTokenTypes.COMMENT) {
            return new CommentElement(node);
        } else if (type == FitnesseTokenTypes.TABLE) {
            return new TableElement(node);
        } else {
            return new ASTWrapperPsiElement(node);
        }
    }

    /**
     * Creates a PSI element for the specified virtual file.
     *
     * @param viewProvider
     *
     * @return the PSI file element.
     */
    public PsiFile createFile(FileViewProvider viewProvider) {
        return null; //new FitnessePSIFile(viewProvider, FitnesseWikiLanguageSupportLoader.FITNESSE.getLanguage());
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return null;
    }
}
