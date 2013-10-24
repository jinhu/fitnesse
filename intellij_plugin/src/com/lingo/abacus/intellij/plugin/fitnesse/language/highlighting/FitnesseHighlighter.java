package com.lingo.abacus.intellij.plugin.fitnesse.language.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.lingo.abacus.intellij.plugin.fitnesse.language.FitnesseTokenTypes;
import com.lingo.abacus.intellij.plugin.fitnesse.language.lexing.FitnesseLexer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 24-Sep-2006 15:50:33
 */
public class FitnesseHighlighter extends SyntaxHighlighterBase {
    private static Map<IElementType, TextAttributesKey> keys1;
    private static Map<IElementType, TextAttributesKey> keys2;

    /**
     * Returns the lexing used for highlighing the file. The lexing is invoked incrementally when the file is changed,
     * so it must be capable of saving/restoring state and resuming lexing from the middle of the file.
     *
     * @return The lexing implementation.
     */
    @NotNull
    public Lexer getHighlightingLexer() {
        return new FitnesseLexer();
    }

    static final TextAttributesKey FT_WIKIWORD = TextAttributesKey.createTextAttributesKey("FITNESSE.WIKIWORD",FitnesseHighlighterColors.WIKIWORD.getDefaultAttributes());

    static final TextAttributesKey FT_COMMENT = TextAttributesKey.createTextAttributesKey("FITNESSE.COMMENT",FitnesseHighlighterColors.COMMENT.getDefaultAttributes());
    static final TextAttributesKey FT_COMMENT_TEXT = TextAttributesKey.createTextAttributesKey("FITNESSE.COMMENT_TEXT",FitnesseHighlighterColors.COMMENT_TEXT.getDefaultAttributes());

    static final TextAttributesKey FT_TABLE = TextAttributesKey.createTextAttributesKey("FITNESSE.TABLE",FitnesseHighlighterColors.TABLE.getDefaultAttributes());
    static final TextAttributesKey FT_TABLE_TEXT = TextAttributesKey.createTextAttributesKey("FITNESSE.TABLE_TEXT",FitnesseHighlighterColors.TABLE_TEXT.getDefaultAttributes());

    static final TextAttributesKey FT_MARKUP = TextAttributesKey.createTextAttributesKey("FITNESSE.MARKUP",FitnesseHighlighterColors.MARKUP.getDefaultAttributes());
    static TextAttributesKey FT_MARKUP_PARAM = TextAttributesKey.createTextAttributesKey("FITNESSE.MARKUP_PARAM", FitnesseHighlighterColors.MARKUP_PARAM.getDefaultAttributes());

    static final TextAttributesKey FT_KEYWORD = TextAttributesKey.createTextAttributesKey("FITNESSE.KEYWORD", FitnesseHighlighterColors.KEYWORD.getDefaultAttributes());
    static final TextAttributesKey FT_KEYWORD_PARAM = TextAttributesKey.createTextAttributesKey("FITNESSE.KEYWORD_PARAM", FitnesseHighlighterColors.KEYWORD_PARAM.getDefaultAttributes());
    static final TextAttributesKey FT_DEFINE_KEY = TextAttributesKey.createTextAttributesKey("FITNESSE.DEFINE_KEY", FitnesseHighlighterColors.DEFINE_KEY.getDefaultAttributes());
    //static final TextAttributesKey FT_DEFINE_BLOCK = TextAttributesKey.createTextAttributesKey("FITNESSE.DEFINE_BLOCK", FitnesseHighlighterColors.DEFINE_BLOCK.getDefaultAttributes());
    static final TextAttributesKey FT_DEFINE_VALUE = TextAttributesKey.createTextAttributesKey("FITNESSE.DEFINE_VALUE", FitnesseHighlighterColors.DEFINE_VALUE.getDefaultAttributes());


    static final TextAttributesKey FT_LETTER_MOD = TextAttributesKey.createTextAttributesKey("FITNESSE.LETTER_MOD",FitnesseHighlighterColors.MOD.getDefaultAttributes());
    static final TextAttributesKey FT_LAYOUT = TextAttributesKey.createTextAttributesKey("FITNESSE.LAYOUT",FitnesseHighlighterColors.LAYOUT.getDefaultAttributes());

    public static final TextAttributesKey FT_PREFORMATTED = TextAttributesKey.createTextAttributesKey("FITNESSE.PREFORMATTED",FitnesseHighlighterColors.PREFORMATTED.getDefaultAttributes());
    public static final TextAttributesKey FT_COLAPSABLE = TextAttributesKey.createTextAttributesKey("FITNESSE.COLAPSABLE",FitnesseHighlighterColors.COLAPSABLE.getDefaultAttributes());
    public static final TextAttributesKey FT_LIST = TextAttributesKey.createTextAttributesKey("FITNESSE.LIST", FitnesseHighlighterColors.LIST.getDefaultAttributes());


    static {
        keys1 = new HashMap<IElementType, TextAttributesKey>();
        keys2 = new HashMap<IElementType, TextAttributesKey>();


        keys1.put(FitnesseTokenTypes.WIKIWORD, FT_WIKIWORD);

        keys1.put(FitnesseTokenTypes.COMMENT, FT_COMMENT);
        keys1.put(FitnesseTokenTypes.COMMENT_TEXT, FT_COMMENT_TEXT);

        keys1.put(FitnesseTokenTypes.TABLE_FIELD_DELIM, FT_TABLE);
        keys1.put(FitnesseTokenTypes.TABLE_TEXT, FT_TABLE_TEXT);

        keys1.put(FitnesseTokenTypes.MARKUP, FT_MARKUP);
        keys1.put(FitnesseTokenTypes.MARKUP_PARAM, FT_MARKUP_PARAM);
        keys1.put(FitnesseTokenTypes.KEYWORD, FT_KEYWORD);
        keys1.put(FitnesseTokenTypes.KEYWORD_PARAM, FT_KEYWORD_PARAM);
        keys1.put(FitnesseTokenTypes.DEFINE_KEY, FT_DEFINE_KEY);
        keys1.put(FitnesseTokenTypes.DEFINE_BLOCK, FT_KEYWORD);
        keys1.put(FitnesseTokenTypes.DEFINE_VALUE, FT_DEFINE_VALUE);

        keys1.put(FitnesseTokenTypes.ITALICS, FT_LETTER_MOD);
        keys1.put(FitnesseTokenTypes.BOLD, FT_LETTER_MOD);
        keys1.put(FitnesseTokenTypes.STRIKEOUT, FT_LETTER_MOD);

        keys1.put(FitnesseTokenTypes.HEADER1, FT_LAYOUT);
        keys1.put(FitnesseTokenTypes.HEADER2, FT_LAYOUT);
        keys1.put(FitnesseTokenTypes.HEADER3, FT_LAYOUT);

        keys1.put(FitnesseTokenTypes.PREFORMATTED_START, FT_PREFORMATTED);
        keys1.put(FitnesseTokenTypes.PREFORMATTED_CONTENT, FT_PREFORMATTED);
        keys1.put(FitnesseTokenTypes.PREFORMATTED_END, FT_PREFORMATTED);

        keys1.put(FitnesseTokenTypes.COLAPSABLE_START, FT_COLAPSABLE);
        keys1.put(FitnesseTokenTypes.COLAPSABLE_CONTENT, FT_COLAPSABLE);
        keys1.put(FitnesseTokenTypes.COLAPSABLE_END, FT_COLAPSABLE);

        keys1.put(FitnesseTokenTypes.LIST, FT_LIST);


    }

    /**
     * Returns the list of text attribute keys used for highlighting the specified token type. The attributes of all
     * attribute keys returned for the token type are successively merged to obtain the color and attributes of the
     * token.
     *
     * @param tokenType The token type for which the highlighting is requested.
     *
     * @return The array of text attribute keys.
     */
    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(keys1.get(tokenType), keys2.get(tokenType));
    }

    public Map<IElementType, TextAttributesKey> getKeys1() {
        return (Map<IElementType, TextAttributesKey>) ((HashMap) keys1).clone();
    }

    public Map<IElementType, TextAttributesKey> getKeys2() {
        return (Map<IElementType, TextAttributesKey>) ((HashMap) keys2).clone();
    }
}
