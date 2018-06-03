/*
 * Copyright (C) 2018 Yasiel Cabrera Alonso
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.uclv.crash.core;

import com.uclv.crash.core.parser.RegularExpresionGrammarBaseVisitor;
import com.uclv.crash.core.parser.RegularExpresionGrammarLexer;
import com.uclv.crash.core.parser.RegularExpresionGrammarParser;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Yasiel Cabrera Alonso
 */
public class RegularExpresionTraductor extends RegularExpresionGrammarBaseVisitor<Automata> {

    public static Automata translate(String source) {
        ANTLRInputStream input = new ANTLRInputStream(source);
        RegularExpresionGrammarLexer lexer = new RegularExpresionGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RegularExpresionGrammarParser parser = new RegularExpresionGrammarParser(tokens);
        Object tree = parser.start();
        RegularExpresionTraductor int_visitor = new RegularExpresionTraductor();        
        
        State.restartGenerator();
        System.out.println("Starting translation...");
        try {
            Automata a = int_visitor.visit((ParseTree) tree);
            System.out.println("End of translation.");
            return a;
        } catch (Throwable tw) {
            System.out.println("End of with errors.");
            return null;
        }

    }

    @Override
    public Automata visitStart(RegularExpresionGrammarParser.StartContext ctx) {
        System.out.println("startNode");

        Automata a = visit(ctx.exp(0));
        for (int i = 1; i < ctx.exp().size(); i++) {
            Automata b = visit(ctx.exp().get(i));
            a.rightJoin(b);
        }
        return a;
    }

    @Override
    public Automata visitExpAsterisk(RegularExpresionGrammarParser.ExpAsteriskContext ctx) {
        Automata a = new Automata();
        State s0 = new State();

        Automata b = visit(ctx.exp());
        List<State> l = b.getStates();
        State start = b.getStartState();
        State end = b.getFinalStates().get(0);
        end.addTransition(start);
        s0.addTransition(start);

        State sf = new State();
        end.addTransition(sf);
        s0.addTransition(sf);

        a.setStartState(s0);
        a.addFinalState(sf);
        for (State s : l) {
            a.addState(s);
        }

        return a;
    }

    @Override
    public Automata visitExpPlus(RegularExpresionGrammarParser.ExpPlusContext ctx) {
        Automata a = new Automata();
        State s0 = new State();

        Automata b = visit(ctx.exp());
        List<State> l = b.getStates();
        State start = b.getStartState();
        State end = b.getFinalStates().get(0);
        end.addTransition(start);
        s0.addTransition(start);

        State sf = new State();
        end.addTransition(sf);

        a.setStartState(s0);
        a.addFinalState(sf);
        for (State s : l) {
            a.addState(s);
        }

        return a;
    }

    @Override
    public Automata visitExpDot(RegularExpresionGrammarParser.ExpDotContext ctx) {
        Automata a = visit(ctx.exp(0));
        a.rightJoin(visit(ctx.exp(1)));

        return a;
    }

    @Override
    public Automata visitExpOr(RegularExpresionGrammarParser.ExpOrContext ctx) {
        Automata a = new Automata();
        State s0 = new State();
        Automata S = visit(ctx.exp(0));
        Automata R = visit(ctx.exp(1));
        State sf = new State();

        State start1 = S.getStartState();
        State start2 = R.getStartState();
        State end1 = S.getFinalStates().get(0);
        State end2 = R.getFinalStates().get(0);

        List<State> statesS = S.getStates();
        List<State> statesR = R.getStates();

        s0.addTransition(start1);
        s0.addTransition(start2);
        end1.addTransition(sf);
        end2.addTransition(sf);

        a.setStartState(s0);
        for (State s : statesS) {
            a.addState(s);
        }
        for (State s : statesR) {
            a.addState(s);
        }
        a.addFinalState(sf);

        return a;
    }

    @Override
    public Automata visitExpBracket(RegularExpresionGrammarParser.ExpBracketContext ctx) {
        
        Automata a = visit(ctx.exp().get(0));
        for (int i = 1; i < ctx.exp().size(); i++) {
            Automata b = visit(ctx.exp().get(i));
            a.rightJoin(b);
        }
        return a;
    }

    @Override
    public Automata visitExpManyIds(RegularExpresionGrammarParser.ExpManyIdsContext ctx) {
        Automata a = new Automata();

        State s0 = new State();
        State s1 = new State();

        char input = ctx.TK_ID().getText().charAt(0);
        s0.addTransition(s1, input);
        a.setStartState(s0);
        a.addFinalState(s1);

        Automata exp = visit(ctx.exp());

        a.rightJoin(exp);

        return a;
    }

    @Override
    public Automata visitExpId(RegularExpresionGrammarParser.ExpIdContext ctx) {
        Automata a = new Automata();

        State s0 = new State();
        State s1 = new State();

        char input = ctx.TK_ID().getText().charAt(0);
        s0.addTransition(s1, input);

        a.setStartState(s0);
        a.addFinalState(s1);

        return a;
    }

}
