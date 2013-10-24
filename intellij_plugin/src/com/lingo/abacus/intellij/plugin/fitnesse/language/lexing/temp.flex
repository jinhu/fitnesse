package com.lingo.abacus.intellij.plugin.fitnesse.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;


%%

%{
    public GeneratedFitnesseLexer() {
      this((java.io.Reader)null);
    }

    public GeneratedFitnesseLexer(boolean highlightMode) {
      this((java.io.Reader)null);
      isHighlightModeOn = highlightMode;
    }

    boolean isHighlightModeOn = false;
%}

%class GeneratedFitnesseLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}
%debug

WHITE_SPACE_CHAR=[\ \n\r\t\f]
IDENTIFIER=[:jletter:] [:jletterdigit:]*

%state DIV
%state COMMENT

%%
{WHITE_SPACE_CHAR}+   { return FitnesseTokenTypes.WHITE_SPACE; }
<YYINITIAL> "#"([^\-]|(\-[^\-])|(\-\-[^>]))* "//" {WHITE_SPACE_CHAR}*  {
  yybegin(COMMENT); yypushback(yylength());
}

<YYINITIAL> "#"([^\-]|(\-[^\-])|(\-\-[^>]))* {
  yybegin(YYINITIAL); return FitnesseTokenTypes.COMMENT;
}

<COMMENT> "#" { yybegin(YYINITIAL); return FitnesseTokenTypes.COMMENT; }
<COMMENT> [^] { yybegin(YYINITIAL); yypushback(1); }


"#"                 { yybegin(COMMENT); return FitnesseTokenTypes.COMMENT; }
{IDENTIFIER}        { yybegin(DIV); return FitnesseTokenTypes.IDENTIFIER; }
.                   { yybegin(YYINITIAL); System.out.println("Illegal character: <" + yytext() + ">");}

