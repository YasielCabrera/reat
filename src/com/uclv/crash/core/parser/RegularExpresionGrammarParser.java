// Generated from D:\WORK\PROJ\REAT - Regular Expresions & Authomatas transformer\RegExAt\src\com\u005Cuclv\crash\core\RegularExpresionGrammar.g4 by ANTLR 4.4
package com.uclv.crash.core.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RegularExpresionGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, TK_ID=3, ZERO_OR_MANY_OP=4, ONE_OR_MANY_OP=5, CONCAT_OP=6, 
		OR_OP=7, WS=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "TK_ID", "'*'", "'+'", "'.'", "'|'", "WS"
	};
	public static final int
		RULE_start = 0, RULE_exp = 1;
	public static final String[] ruleNames = {
		"start", "exp"
	};

	@Override
	public String getGrammarFileName() { return "RegularExpresionGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RegularExpresionGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(5); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(4); exp(0);
				}
				}
				setState(7); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 || _la==TK_ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpManyIdsContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TK_ID() { return getToken(RegularExpresionGrammarParser.TK_ID, 0); }
		public ExpManyIdsContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitExpManyIds(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpBracketContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpBracketContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitExpBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpDotContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode CONCAT_OP() { return getToken(RegularExpresionGrammarParser.CONCAT_OP, 0); }
		public ExpDotContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitExpDot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpOrContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode OR_OP() { return getToken(RegularExpresionGrammarParser.OR_OP, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpOrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitExpOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAsteriskContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ZERO_OR_MANY_OP() { return getToken(RegularExpresionGrammarParser.ZERO_OR_MANY_OP, 0); }
		public ExpAsteriskContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitExpAsterisk(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPlusContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ONE_OR_MANY_OP() { return getToken(RegularExpresionGrammarParser.ONE_OR_MANY_OP, 0); }
		public ExpPlusContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitExpPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIdContext extends ExpContext {
		public TerminalNode TK_ID() { return getToken(RegularExpresionGrammarParser.TK_ID, 0); }
		public ExpIdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegularExpresionGrammarVisitor ) return ((RegularExpresionGrammarVisitor<? extends T>)visitor).visitExpId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new ExpManyIdsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(10); match(TK_ID);
				setState(11); exp(2);
				}
				break;
			case 2:
				{
				_localctx = new ExpBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12); match(T__1);
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(13); exp(0);
					}
					}
					setState(16); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 || _la==TK_ID );
				setState(18); match(T__0);
				}
				break;
			case 3:
				{
				_localctx = new ExpIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20); match(TK_ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(33);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpDotContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(23);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(24); match(CONCAT_OP);
						setState(25); exp(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(26);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(27); match(OR_OP);
						setState(28); exp(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpAsteriskContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(29);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(30); match(ZERO_OR_MANY_OP);
						}
						break;
					case 4:
						{
						_localctx = new ExpPlusContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(31);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(32); match(ONE_OR_MANY_OP);
						}
						break;
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 5);
		case 1: return precpred(_ctx, 4);
		case 2: return precpred(_ctx, 7);
		case 3: return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n)\4\2\t\2\4\3\t"+
		"\3\3\2\6\2\b\n\2\r\2\16\2\t\3\3\3\3\3\3\3\3\3\3\6\3\21\n\3\r\3\16\3\22"+
		"\3\3\3\3\3\3\5\3\30\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3$\n"+
		"\3\f\3\16\3\'\13\3\3\3\2\3\4\4\2\4\2\2.\2\7\3\2\2\2\4\27\3\2\2\2\6\b\5"+
		"\4\3\2\7\6\3\2\2\2\b\t\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\3\3\2\2\2\13"+
		"\f\b\3\1\2\f\r\7\5\2\2\r\30\5\4\3\4\16\20\7\3\2\2\17\21\5\4\3\2\20\17"+
		"\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\24\3\2\2\2\24\25"+
		"\7\4\2\2\25\30\3\2\2\2\26\30\7\5\2\2\27\13\3\2\2\2\27\16\3\2\2\2\27\26"+
		"\3\2\2\2\30%\3\2\2\2\31\32\f\7\2\2\32\33\7\b\2\2\33$\5\4\3\b\34\35\f\6"+
		"\2\2\35\36\7\t\2\2\36$\5\4\3\7\37 \f\t\2\2 $\7\6\2\2!\"\f\b\2\2\"$\7\7"+
		"\2\2#\31\3\2\2\2#\34\3\2\2\2#\37\3\2\2\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2"+
		"\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2\7\t\22\27#%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}