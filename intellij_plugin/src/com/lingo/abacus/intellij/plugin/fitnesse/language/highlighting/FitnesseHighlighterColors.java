package com.lingo.abacus.intellij.plugin.fitnesse.language.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;

import java.awt.*;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 08-Oct-2006 23:12:06
 */
public interface FitnesseHighlighterColors {
    Color DARK_GREEN = new Color(0.00f, 0.60f, 0.00f);
    Color ORANGE = new Color(0.80f, 0.40f, 0.00f);
    Color LIGHT_ORANGE = new Color(1.00f, 0.60f, 0.00f);
    Color DARK_PURPLE = new Color(0.40f, 0.00f, 0.40f);
    Color DARK_GREY = new Color(0.40f, 0.40f, 0.40f);
    Color BEIGE = new Color(0.80f, 1.00f, 0.60f);
    Color DARK_BEIGE = new Color(0.60f, 0.60f, 0.00f);
    Color BROWN = new Color(0.60f, 0.40f, 0.00f);
    Color RED = Color.RED;
    Color DARK_BLUE = new Color(0.00f, 0.00f, 0.60f);
    Color MEDIUM_BLUE = new Color(0.00f, 0.00f, 0.80f);
    Color PINK = Color.PINK;

    int BOLD = Font.BOLD;
    int ITALIC = Font.ITALIC;

    TextAttributesKey COMMENT = TextAttributesKey
            .createTextAttributesKey("FITNESSE.COMMENT", new TextAttributes(DARK_GREEN, null, null, null, BOLD));
    TextAttributesKey COMMENT_TEXT = TextAttributesKey
            .createTextAttributesKey("FITNESSE.COMMENT_TEXT", new TextAttributes(DARK_GREEN, null, null, null, ITALIC));
    Color DEFAULT_GREEN = Color.GREEN;
    TextAttributesKey TABLE = TextAttributesKey
            .createTextAttributesKey("FITNESSE.TABLE", new TextAttributes(BROWN, BEIGE, null, null, BOLD));
    TextAttributesKey TABLE_TEXT = TextAttributesKey
            .createTextAttributesKey("FITNESSE.TABLE_TEXT", new TextAttributes(RED, BEIGE, null, null, 0));
    TextAttributesKey MARKUP = TextAttributesKey
            .createTextAttributesKey("FITNESSE.MARKUP", new TextAttributes(ORANGE, null, null, null, BOLD));
    TextAttributesKey KEYWORD = TextAttributesKey
            .createTextAttributesKey("FITNESSE.KEYWORD", new TextAttributes(DARK_BLUE, null, null, null, BOLD));
    TextAttributesKey MOD = TextAttributesKey
            .createTextAttributesKey("FITNESSE.MOD", new TextAttributes(DARK_BEIGE, BEIGE, null, null, 0));
    TextAttributesKey LAYOUT = TextAttributesKey
            .createTextAttributesKey("FITNESSE.LAYOUT", new TextAttributes(DARK_BEIGE, null, null, null, 0));
    TextAttributesKey KEYWORD_PARAM = TextAttributesKey
            .createTextAttributesKey("FITNESSE.KEYWORD_PARAM",
                    new TextAttributes(MEDIUM_BLUE, null, null, null, ITALIC));
    TextAttributesKey MARKUP_PARAM = TextAttributesKey
            .createTextAttributesKey("FITNESSE.MARKUP_PARAM",
                    new TextAttributes(LIGHT_ORANGE, null, null, null, ITALIC));
    TextAttributesKey DEFINE_KEY = TextAttributesKey
            .createTextAttributesKey("FITNESSE.DEFINE_KEY", new TextAttributes(MEDIUM_BLUE, null, null, null, 0));
    TextAttributesKey DEFINE_VALUE = TextAttributesKey
            .createTextAttributesKey("FITNESSE.DEFINE_VALUE", new TextAttributes(PINK, null, null, null, 0));
    TextAttributesKey WIKIWORD = TextAttributesKey
            .createTextAttributesKey("FITNESSE.WIKIWORD", new TextAttributes(ORANGE, null, null, null, 0));
    TextAttributesKey PREFORMATTED = TextAttributesKey
            .createTextAttributesKey("FITNESSE.PREFORMATTED", new TextAttributes(DARK_PURPLE, null, null, null, 0));
    TextAttributesKey COLAPSABLE = TextAttributesKey
            .createTextAttributesKey("FITNESSE.COLAPSABLE", new TextAttributes(DARK_GREY, null, null, null, ITALIC));
    TextAttributesKey LIST = TextAttributesKey.createTextAttributesKey("FITNESSE.LIST", new TextAttributes(
            LIGHT_ORANGE, null, null, null, BOLD));
}
