// Generated from D:\WORK\PROJ\REAT - Regular Expresions & Authomatas transformer\RegExAt\src\com\u005Cuclv\crash\core\RegularExpresionGrammar.g4 by ANTLR 4.4
package com.uclv.crash.core.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegularExpresionGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegularExpresionGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code expManyIds}
	 * labeled alternative in {@link RegularExpresionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpManyIds(@NotNull RegularExpresionGrammarParser.ExpManyIdsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expBracket}
	 * labeled alternative in {@link RegularExpresionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpBracket(@NotNull RegularExpresionGrammarParser.ExpBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expDot}
	 * labeled alternative in {@link RegularExpresionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDot(@NotNull RegularExpresionGrammarParser.ExpDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link RegularExpresionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpOr(@NotNull RegularExpresionGrammarParser.ExpOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegularExpresionGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull RegularExpresionGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAsterisk}
	 * labeled alternative in {@link RegularExpresionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAsterisk(@NotNull RegularExpresionGrammarParser.ExpAsteriskContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expPlus}
	 * labeled alternative in {@link RegularExpresionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPlus(@NotNull RegularExpresionGrammarParser.ExpPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expId}
	 * labeled alternative in {@link RegularExpresionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpId(@NotNull RegularExpresionGrammarParser.ExpIdContext ctx);
}