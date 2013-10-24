package com.lingo.abacus.intellij.plugin.fitnesse.lexing;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.lingo.abacus.intellij.plugin.fitnesse.FitnesseTokenTypes;


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
%eof{  FitnesseTokenTypes.EOF;
%eof}
//%debug

ALPHA=[A-Za-z]
DIGIT=[0-9]
NONNEWLINE_WHITE_SPACE_CHAR=[\ \t\b\012]
NEWLINE=\r|\n|\r\n
ESCAPE_SEQUENCE=\\[^\r\n]
//WHITE_SPACE_CHAR=[\n\r\ \t\b\012]
ITALICS="''"([^\\\'\'\r\n]|{ESCAPE_SEQUENCE})*("''"|\\)?
BOLD="'''"([^\\\'\'\'\r\n]|{ESCAPE_SEQUENCE})*("'''"|\\)?
STRIKEOUT="--"({ESCAPE_SEQUENCE})*("--"|\\)?
//DOUBLE_QUOTED_LITERAL=\"([^\\\"\r\n]|{ESCAPE_SEQUENCE})*(\"|\\)?
COMMENT=("#")
//TEXT=([^*/\n]|[^*\n])*
Ident = ({ALPHA}|{DIGIT}|_|":\\")+
WIKIWORD = "^"*(([A-Z][a-z]+([A-Z][a-z]+)([A-Z][a-z]+|[0-9]+)*)|([A-Z][a-z]+([0-9]+)([A-Z][a-z]+)([A-Z][a-z]+|[0-9]+)*))



%state COMMENT
%state TABLE
%state TABLE_RECORD
%state KEYWORD
%state MARKUP
%state DEFINE
%state CURRLY_DEFINE
%state PAREN_DEFINE
%state PREFORMATTED
%state COLAPSABLE

%%

<YYINITIAL> {
  {WIKIWORD} {return FitnesseTokenTypes.WIKIWORD;}
  (([^]|[\n\r]+)[ ]+([0-9]|"*"))  {return FitnesseTokenTypes.LIST;}
  {NONNEWLINE_WHITE_SPACE_CHAR}+ {return FitnesseTokenTypes.OTHER;}
  {DIGIT}+ {return FitnesseTokenTypes.DIGIT;}
  {Ident} {return FitnesseTokenTypes.IDENT; }
  //{ALPHA}+ {return FitnesseTokenTypes.ALPHA;}
  //comments
  {COMMENT} { yybegin(COMMENT); return FitnesseTokenTypes.COMMENT;}

  //table
  ^\| { yybegin(TABLE_RECORD); yypushback(1); return FitnesseTokenTypes.TABLE_START;}

  "!1" {return FitnesseTokenTypes.HEADER1;}
  "!2" {return FitnesseTokenTypes.HEADER2;}
  "!3" {return FitnesseTokenTypes.HEADER3;}


  //KEYWORDS
  "!include" {yybegin(KEYWORD); return FitnesseTokenTypes.KEYWORD;}
  "!path" {yybegin(KEYWORD); return FitnesseTokenTypes.KEYWORD;}
  "!define" {yybegin(DEFINE); return FitnesseTokenTypes.KEYWORD;}
  "!contents" {return FitnesseTokenTypes.KEYWORD;}
  "!contents -R" {return FitnesseTokenTypes.KEYWORD;}
  "!lastmodified" {return FitnesseTokenTypes.KEYWORD;}
  "!fixture" {yybegin(KEYWORD); return FitnesseTokenTypes.KEYWORD;}
  "!see" {yybegin(KEYWORD); return FitnesseTokenTypes.KEYWORD;}
  "!note" {yybegin(KEYWORD); return FitnesseTokenTypes.KEYWORD;}
  "!anchor" {yybegin(KEYWORD); return FitnesseTokenTypes.KEYWORD;}

  //MARKUP
  {ITALICS} {return FitnesseTokenTypes.ITALICS;}
  {BOLD} {return FitnesseTokenTypes.BOLD;}
  "---"[-]* {return FitnesseTokenTypes.MARKUP;}
  {STRIKEOUT} {return FitnesseTokenTypes.STRIKEOUT;}
  "!c" {return FitnesseTokenTypes.CENTER;}
  //"^" {return FitnesseTokenTypes.MARKUP;}
  "!-" {return FitnesseTokenTypes.MARKUP;}
  "-!" {return FitnesseTokenTypes.MARKUP;}
  ".#"[^ ]+ {return FitnesseTokenTypes.MARKUP;}
  "!img" {yybegin(MARKUP); return FitnesseTokenTypes.MARKUP;}
  "!img-l" {yybegin(MARKUP); return FitnesseTokenTypes.MARKUP;}
  "!img-r" {yybegin(MARKUP); return FitnesseTokenTypes.MARKUP;}
  "http://"[^*\n\r ]+ {return FitnesseTokenTypes.MARKUP;}
  "{{{" {yybegin(PREFORMATTED); return FitnesseTokenTypes.PREFORMATTED_START;}
  "!""*"+(">"{0,1})[^\n\r]+ {return FitnesseTokenTypes.COLAPSABLE_START;}
  "*"+"!"      {return FitnesseTokenTypes.COLAPSABLE_END;}


  . {  return FitnesseTokenTypes.UNLEXED_CONTENT;}
}

    <COMMENT> {
      [^\n\r]+ {return FitnesseTokenTypes.COMMENT_TEXT; }
      {NEWLINE} {yybegin(YYINITIAL); yypushback(yylength()); return FitnesseTokenTypes.COMMENT_END;}

    }

    <TABLE> {
      "|"          {yybegin(TABLE_RECORD); return FitnesseTokenTypes.TABLE_FIELD_DELIM;}
      .            {yybegin(YYINITIAL); yypushback(1); return FitnesseTokenTypes.TABLE_END_OF_TABLE;}
    }
    <TABLE_RECORD>{
      "|"                       {return FitnesseTokenTypes.TABLE_FIELD_DELIM;}
      "?"                       {return FitnesseTokenTypes.TABLE_QUESTION;}
      "="                       {return FitnesseTokenTypes.TABLE_EQUAL;}
      {NEWLINE}                 {yybegin(TABLE); yypushback(yylength()); return FitnesseTokenTypes.TABLE_RECORD_DELIM;}
      [^\n\r|]+                  {return FitnesseTokenTypes.TABLE_TEXT;}

    }

    <KEYWORD> {
      [^\n\r]+                  {return FitnesseTokenTypes.KEYWORD_PARAM;}
      {NEWLINE}                 {yybegin(YYINITIAL); yypushback(yylength()); return FitnesseTokenTypes.KEYWORD_END;}
    }

    //!Define
    <DEFINE> {
      
      [^\n\r! !{!(]+                   {return FitnesseTokenTypes.DEFINE_KEY;}
      " {"                 {yybegin(CURRLY_DEFINE);return FitnesseTokenTypes.DEFINE_BLOCK;}
      " ("                 {yybegin(PAREN_DEFINE);return FitnesseTokenTypes.DEFINE_BLOCK;}
    }
    <CURRLY_DEFINE>{
      "}"                  {yybegin(YYINITIAL);return FitnesseTokenTypes.DEFINE_BLOCK;}
      [^\n\r!}]+                   {return FitnesseTokenTypes.DEFINE_VALUE;}

    }
    <PAREN_DEFINE>{
      ")"                  {yybegin(YYINITIAL); return FitnesseTokenTypes.DEFINE_BLOCK;}
      [^\n\r!)]+                   {return FitnesseTokenTypes.DEFINE_VALUE;}
    }

    //markup
    <MARKUP> {
      [^*\n\r ]+                  {yybegin(YYINITIAL); return FitnesseTokenTypes.MARKUP_PARAM;}
     
    }

    <PREFORMATTED> {
      "}}}"                       {yybegin(YYINITIAL);return FitnesseTokenTypes.PREFORMATTED_END;}
      [^*\n\r ]+              {return FitnesseTokenTypes.PREFORMATTED_CONTENT;}
    }

    
{NEWLINE} {return FitnesseTokenTypes.NEWLINE;}

. { return FitnesseTokenTypes.UNEXPECTED_CONTENT;}
