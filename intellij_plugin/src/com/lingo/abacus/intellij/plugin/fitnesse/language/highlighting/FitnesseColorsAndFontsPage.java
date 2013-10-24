package com.lingo.abacus.intellij.plugin.fitnesse.language.highlighting;

import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseWikiLanguageSupportLoader;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseBundle;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

/**
 * Class Descriptio
 *
 * @Developer: florian
 * @Date: 08-Oct-2006 22:54:47
 */
@SuppressWarnings({"UnresolvedPropertyKey"})
public class FitnesseColorsAndFontsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] ATTRS;

    static {
        ATTRS = new AttributesDescriptor[]{
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.wikiword"), FitnesseHighlighter.FT_WIKIWORD),

                new AttributesDescriptor(FitnesseBundle.message("fitnesse.comment"), FitnesseHighlighter.FT_COMMENT),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.comment_text"), FitnesseHighlighter.FT_COMMENT_TEXT),

                new AttributesDescriptor(FitnesseBundle.message("fitnesse.table"), FitnesseHighlighter.FT_TABLE),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.table_text"), FitnesseHighlighter.FT_TABLE_TEXT),

                new AttributesDescriptor(FitnesseBundle.message("fitnesse.keyword"), FitnesseHighlighter.FT_KEYWORD),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.keyword_param"), FitnesseHighlighter.FT_KEYWORD_PARAM),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.define_key"), FitnesseHighlighter.FT_DEFINE_KEY),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.define_value"), FitnesseHighlighter.FT_DEFINE_VALUE),

                new AttributesDescriptor(FitnesseBundle.message("fitnesse.markup"), FitnesseHighlighter.FT_MARKUP),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.markup_param"), FitnesseHighlighter.FT_MARKUP_PARAM),

                new AttributesDescriptor(FitnesseBundle.message("fitnesse.letter_mod"), FitnesseHighlighter.FT_LETTER_MOD),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.layout"), FitnesseHighlighter.FT_LAYOUT),

                new AttributesDescriptor(FitnesseBundle.message("fitnesse.preformatted"), FitnesseHighlighter.FT_PREFORMATTED),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.colapsable"), FitnesseHighlighter.FT_COLAPSABLE),
                new AttributesDescriptor(FitnesseBundle.message("fitnesse.list"), FitnesseHighlighter.FT_LIST)


        };
    }

    private static final ColorDescriptor[] COLORS = new ColorDescriptor[0];

    @NotNull
    public String getDisplayName() {
        //noinspection HardCodedStringLiteral
        return "Fitnesse Wiki Markup";
    }

    public Icon getIcon() {
        return FitnesseWikiLanguageSupportLoader.FITNESSE.getIcon();
    }

    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;
    }

    @NotNull
    public ColorDescriptor[] getColorDescriptors() {
        return COLORS;
    }

    @NotNull
    public SyntaxHighlighter getHighlighter() {
        return null;// FitnesseWikiLanguageSupportLoader.FITNESSE.getHighlighter()
    }

    @NotNull
    public String getDemoText() {
        return "#\n" +
                "# This is Demo file for Fitnesse wiki syntax highlighting.\n" +
                "# Copyright @2006\n" +
                "#\n" +
                "--This is striked -out text--\n" +
                "\n" +
                "!path ..\\lib\\application.jar\n" +
                "\n" +
                "!1 ''Section 1 in Italics''\n" +
                "!contents -R\n" +
                "!see TestDocumentation\n" +
                "!include EnvironmentTest\n" +
                "!fixture QuantumFixture\n" +
                "!define pi {3.14159}\n" +
                "\n" +
                "!img ..\\images\\test_diag.jpg\n" +
                "\n" +
                "!c For more details go to: http://www.company.com\n" +
                "!c see footnote .#CodeReferance for details\n" +
                "\n" +
                "!2 '''Section 2 in Bold'''\n" +
                " * List Of Tests\n" +
                "  1 TestQuantumAccelerator\n" +
                "  2 Test54321Sequence\n" +
                "   * TestLaunch\n" +
                "   * TestRockeySectionRelease\n" +
                "\n" +
                "!3 The Test\n" +
                "\n" +
                "|RectangleFixture|\n" +
                "|width|height|=Area?|\n" +
                "|300|20|area1|\n" +
                "|35|2|area2|\n" +
                "\n" +
                "|AnOtherFixture|\n" +
                "|Area=|Height|volume?|\n" +
                "|area1|20|120000|\n" +
                "|area2|20|1400|\n" +
                "\n" +
                "!anchor CodeReferance\n" +
                "!*> Code referance\n" +
                "{{{\n" +
                "  protected void wormwholeSetUp() throws QuantumException {\n" +
                "        super.setUp();\n" +
                "        Singularity singularity = new RandomSingularity();\n" +
                "        singularity.ignite;\n" +
                "    }\n" +
                "}}}\n" +
                "*!\n" +
                "!note See Specification for details\n" +
                "----\n" +
                "!lastmodified";
    }

    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }
}
