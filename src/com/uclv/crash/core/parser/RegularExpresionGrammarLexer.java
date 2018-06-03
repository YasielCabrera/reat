// Generated from D:\WORK\PROJ\REAT - Regular Expresions & Authomatas transformer\RegExAt\src\com\u005Cuclv\crash\core\RegularExpresionGrammar.g4 by ANTLR 4.4
package com.uclv.crash.core.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RegularExpresionGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, TK_ID=3, ZERO_OR_MANY_OP=4, ONE_OR_MANY_OP=5, CONCAT_OP=6, 
		OR_OP=7, WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "TK_ID", "LETRA", "DIGITO", "SYMBOL", "ZERO_OR_MANY_OP", 
		"ONE_OR_MANY_OP", "CONCAT_OP", "OR_OP", "WS"
	};


	public RegularExpresionGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RegularExpresionGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\62\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\5\4 \n\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\2\2\r\3\3\5\4\7\5\t\2\13"+
		"\2\r\2\17\6\21\7\23\b\25\t\27\n\3\2\5\4\2C\\c|\f\2##&&((*\60<=??AA]]_"+
		"a}\177\5\2\13\f\17\17\"\"/\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2"+
		"\2\5\33\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13#\3\2\2\2\r%\3\2\2\2\17\'\3"+
		"\2\2\2\21)\3\2\2\2\23+\3\2\2\2\25-\3\2\2\2\27/\3\2\2\2\31\32\7*\2\2\32"+
		"\4\3\2\2\2\33\34\7+\2\2\34\6\3\2\2\2\35 \5\t\5\2\36 \5\13\6\2\37\35\3"+
		"\2\2\2\37\36\3\2\2\2 \b\3\2\2\2!\"\t\2\2\2\"\n\3\2\2\2#$\4\62;\2$\f\3"+
		"\2\2\2%&\t\3\2\2&\16\3\2\2\2\'(\7,\2\2(\20\3\2\2\2)*\7-\2\2*\22\3\2\2"+
		"\2+,\7\60\2\2,\24\3\2\2\2-.\7~\2\2.\26\3\2\2\2/\60\t\4\2\2\60\61\b\f\2"+
		"\2\61\30\3\2\2\2\4\2\37\3\3\f\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}