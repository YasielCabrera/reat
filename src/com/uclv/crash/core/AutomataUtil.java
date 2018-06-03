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

import java.util.List;

/**
 *
 * @author Yasiel Cabrera Alonso
 */
public class AutomataUtil {

    /**
     * Ordena una lista de estados por el id
     *
     * @param list
     */
    public static void sort(List<State> list) {
        State temp;
        for (int i = 1; i < list.size(); i++) {
            temp = list.get(i);
            int j = i - 1;
            while (j >= 0 && temp.getId() < list.get(j).getId()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, temp);
        }
    }

    /**
     * Pinta un automata en un AutomataViewer para ser mostrado graficamente
     *
     * @param aut
     * @param viewer
     */
    public static void paintAutomata(Automata aut, AutomataViewer viewer) {
        List<State> states = aut.getStates();
        List<State> finals = aut.getFinalStates();
        State start = aut.getStartState();

        List<Transition> trans = aut.getTransitions();

        states.stream().forEach((s) -> {
            if (s.equals(start)) {
                //add the start state
                if (finals.contains(start)) {
                    viewer.insertStartFinalVertex(Integer.toString(s.getId()));
                } else {
                    viewer.insertStartVertex(Integer.toString(s.getId()));
                }
            } else if (finals.contains(s)) {
                //add a final state
                viewer.insertFinalVertex(Integer.toString(s.getId()));
            } else {
                //add a normal state
                viewer.insertVertex(Integer.toString(s.getId()));
            }
        });

        trans.stream().forEach((edge) -> {
            viewer.insertEdge(
                    Character.toString(edge.getInput()),
                    Integer.toString(edge.getStart().getId()),
                    Integer.toString(edge.getTarget().getId())
            );
        });
    }

    /**
     * Imprime un automata. Utilizado para debuguear...
     *
     * @param A
     */
    public static void printA(Automata A) {
        System.out.println("Start : " + A.getStartState().getId());
        System.out.print("FinalStates : ");
        for (int i = 0; i < A.getFinalStates().size(); i++) {
            System.out.print(" " + A.getFinalStates().get(i).getId());
        }
        System.out.println();

        System.out.println("States:");
        for (State s : A.getStates()) {
            System.out.println("\t" + s.getId());
            for (SimplifiedTransition st : s.getTransitions()) {
                System.out.println("\t\t->" + st.getTarget().getId() + " " + st.getInput());
            }
        }
    }

}
