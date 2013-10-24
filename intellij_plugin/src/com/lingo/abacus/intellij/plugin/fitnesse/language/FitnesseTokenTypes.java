package com.lingo.abacus.intellij.plugin.fitnesse.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.lang.Language;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseWikiLanguageSupportLoader;
import com.lingo.abacus.intellij.plugin.fitnesse.language.FitnesseLanguage;
import com.lingo.abacus.intellij.plugin.fitnesse.language.lexing.FitnesseElementType;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 24-Sep-2006 17:08:56
 */
public class FitnesseTokenTypes {
    private static final Language LANGUAGE = FitnesseWikiLanguageSupportLoader.FITNESSE.getLanguage();

    public static final IElementType WIKIWORD = new IElementType("WIKIWORD",LANGUAGE);

    public static final IElementType COMMENT= new FitnesseElementType("COMMENT", LANGUAGE);
    public static final IElementType COMMENT_TEXT = new IElementType("COMMENT_TEXT",LANGUAGE);
    public static final IElementType COMMENT_END = new IElementType("COMMENT_END",LANGUAGE);

    public static final IElementType WHITE_SPACE= new FitnesseElementType("WHITE_SPACE", LANGUAGE);
    public static final IElementType BAD_CHARACTER= new FitnesseElementType("BAD_CHARACTER", LANGUAGE);
    public static final IElementType IDENTIFIER = new FitnesseElementType("IDENTIFIER", LANGUAGE);

    public static final IElementType TABLE = new IElementType("TABLE",LANGUAGE);
    public static final IElementType TABLE_TEXT = new IElementType("TABLE_TEXT",LANGUAGE);
    public static final IElementType TABLE_START = new IElementType("TABLE_START", LANGUAGE);
    public static final IElementType TABLE_FIELD_DELIM = new IElementType("TABLE_FIELD_DELIM", LANGUAGE);
    public static final IElementType TABLE_RECORD_DELIM = new IElementType("TABLE_RECORD_DELIM",LANGUAGE);
    public static final IElementType TABLE_END_OF_TABLE = new IElementType("TABLE_END_OF_TABLE",LANGUAGE);
    public static final IElementType TABLE_EQUAL = new IElementType("TABLE_EQUAL",LANGUAGE);
    public static final IElementType TABLE_QUESTION = new IElementType("TABLE_QUESTION",LANGUAGE);

    public static final IElementType IDENT = new IElementType("IDENT",LANGUAGE);
    public static final IElementType DIGIT = new IElementType("DIGIT",LANGUAGE);

    public static final IElementType KEYWORD = new IElementType("KEYWORD",LANGUAGE);
    public static final IElementType KEYWORD_PARAM = new IElementType("KEYWORD_PARAM", LANGUAGE);
    public static final IElementType KEYWORD_END = new IElementType("KEYWORD_END",LANGUAGE);
    public static final IElementType DEFINE_BLOCK = new IElementType("DEFINE_BLOCK",LANGUAGE);
    public static final IElementType DEFINE_KEY = new IElementType("DEFINE_KEY",LANGUAGE);
    public static final IElementType DEFINE_VALUE = new IElementType("DEFINE_VALUE",LANGUAGE);

    public static final IElementType MARKUP = new IElementType("MARKUP",LANGUAGE);
    public static final IElementType MARKUP_PARAM = new IElementType("MARKUP_PARAM",LANGUAGE);
    public static final IElementType MARKUP_END = new IElementType("MARKUP_END",LANGUAGE);

    public static final IElementType ITALICS = new IElementType("ITALICS",LANGUAGE);
    public static final IElementType BOLD = new IElementType("BOLD",LANGUAGE);
    public static final IElementType STRIKEOUT = new IElementType("STRIKEOUT",LANGUAGE);
    public static final IElementType CENTER = new IElementType("CENTER",LANGUAGE);
    public static final IElementType HEADER1 = new IElementType("HEADER1",LANGUAGE);
    public static final IElementType HEADER2 = new IElementType("HEADER2",LANGUAGE);
    public static final IElementType HEADER3 = new IElementType("HEADER3",LANGUAGE);

    public static final IElementType NEWLINE = new IElementType("NEWLINE",LANGUAGE);
    public static final IElementType OTHER = new IElementType("OTHER",LANGUAGE);
    public static final IElementType UNLEXED_CONTENT = new IElementType("UNLEXED_CONTENT",LANGUAGE);
    public static final IElementType UNEXPECTED_CONTENT = new IElementType("UNEXPECTED_CONTENT",LANGUAGE);

    public static final IElementType PREFORMATTED_START = new IElementType("PREFORMATTED_START",LANGUAGE);
    public static final IElementType PREFORMATTED_CONTENT = new IElementType("PREFORMATTED_CONTENT",LANGUAGE);
    public static final IElementType PREFORMATTED_END = new IElementType("PREFORMATTED_END",LANGUAGE);

    public static final IElementType COLAPSABLE_START = new IElementType("COLAPSABLE_START",LANGUAGE);
    public static final IElementType COLAPSABLE_END = new IElementType("COLAPSABLE_END",LANGUAGE);
    public static final IElementType COLAPSABLE_CONTENT = new IElementType("COLAPSABLE_CONTENT",LANGUAGE);
    public static final IElementType LIST = new IElementType("LIST",LANGUAGE);

    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(FitnesseLanguage.class));
    public static final TokenSet COMMENTS = TokenSet.create(COMMENT,COMMENT_TEXT);
}