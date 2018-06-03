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

import com.uclv.crash.core.Group.Entry;
import com.uclv.crash.gui.partials.afdstep.Step;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.swing.RowFilter;

/**
 *
 * @author Yasiel Cabrera Alonso
 */
public class Automata {

    /**
     * Conjunto de estados.
     */
    private final List<State> states;
    /**
     * Estado inicial.
     */
    private State startState;
    /**
     * Conjunto de estados dze aceptación.
     */
    private final List<State> finalStates;

    /**
     * Crea un automata vacio.
     */
    public Automata() {
        states = new ArrayList<>();
        finalStates = new ArrayList<>();
    }

    /**
     * Pone un nuevo estado inicial.
     *
     * @param startState
     */
    public void setStartState(State startState) {
        this.startState = startState;
        if (!states.contains(startState)) {
            states.add(startState);
        }
    }

    /**
     * Crea un nuevo estado inicial a partir de un id. Si existe un estado con
     * el identificador especificado, entonces se utiliza ese y no se crea otro.
     *
     * @param id identificador del estado
     */
    public void setStartState(int id) {
        State start = null;
        for (State s : states) {
            if (s.getId() == id) {
                start = s;
                break;
            }
        }
        if (start == null) {
            start = new State(id);
            states.add(start);
        }
        startState = start;
    }

    /**
     * Agrega un nuevo estado al conjunto de los estados finales.
     *
     * @param finalState
     */
    public void addFinalState(State finalState) {
        if (!finalStates.contains(finalState)) {
            if (!states.contains(finalState)) {
                states.add(finalState);
            }
            finalStates.add(finalState);
        }
    }

    /**
     * Adiciona un nuevo estado al conjunto de los estados finales. En caso de
     * existir en dicho conjunto no se hace nada. Se adiciona tambien al
     * conjunto de estados si no existe.
     *
     * @param finalState identificador del nuevo estado.
     */
    public void addFinalState(int finalState) {
        for (State s : finalStates) {
            if (s.getId() == finalState) {
                return;
            }
        }

        for (State s : states) {
            if (s.getId() == finalState) {
                finalStates.add(s);
                return;
            }
        }

        State s = new State(finalState);
        states.add(s);
        finalStates.add(s);
    }

    /**
     * Adiciona un nuevo estado al conjunto de estados del automata.
     *
     * @param state Nuevo estado a insertar.
     */
    public void addState(State state) {
        if (!states.contains(state)) {
            states.add(state);
        } else {
            //throw new RuntimeException("Duplicate State");
        }
    }

    /**
     * Adiciona un nuevo estado. Si existe un estado con el id especificado, no
     * se hace nada.
     *
     * @param state identificador del nuevo estado.
     */
    public void addState(int state) {
        for (State s : states) {
            if (s.getId() == state) {
                return;
            }
        }

        this.addState(new State(state));
    }

    /**
     * Agrega una nueva transicion al automata.
     *
     * @param from desde que estado parte la transicion
     * @param to hasta que estado llega la transicion
     * @param symbol csimbolo con el que se hace la transicion
     */
    public void addTransition(State from, State to, char symbol) {
        if (!states.contains(from)) {
            states.add(from);
        }
        if (!states.contains(to)) {
            states.add(to);
        }

        from.addTransition(to, symbol);
    }

    /**
     * Agrega una nueva transicion.
     *
     * @param idFrom identificador del estado del que parte la transicion
     * @param idTo identificador del estado al que llega la transicion
     * @param symbol simbolo con el que se hace la transicion
     * @return true si se puede agregar la transicion, false si algunos de los
     * estados no existe.
     */
    public boolean addTransition(int idFrom, int idTo, char symbol) {
        State from = find(idFrom);
        State to = find(idTo);

        if (from == null || to == null) {
            return false;
        } else {
            from.addTransition(to, symbol);
            return true;
        }
    }

    /**
     * Crea una lista del conjunto de transiciones del automata.
     *
     * @return Todas las transiciones del automata.
     */
    public List<Transition> getTransitions() {
        List<Transition> list = new ArrayList<>();
        for (State s : states) {
            for (SimplifiedTransition st : s.getTransitions()) {
                list.add(new Transition(s, st.getTarget(), st.getInput()));
            }
        }
        return list;
    }

    /**
     * Busca el estado con el id especificado y lo devuelve.
     *
     * @param stateId Identificador del estado que se desea encontrar
     * @return Devuelve el estado si se encuentra o null si no esta en este
     * automata.
     */
    public State find(int stateId) {
        for (State s : states) {
            if (s.getId() == stateId) {
                return s;
            }
        }
        return null;
    }

    /**
     * Devuelve el alfabeto del automata.
     *
     * @return Una lista con el alfabeto del automata.
     */
    public List<Character> getAlphabet() {
        List<Character> alphabet = new ArrayList<>();

        for (State s : states) {
            for (SimplifiedTransition st : s.getTransitions()) {
                if (st.getInput() != SimplifiedTransition.EMPTY_INPUT && !alphabet.contains(st.getInput())) {
                    alphabet.add(st.getInput());
                }
            }
        }

        return alphabet;
    }

    /**
     * Dice si este automata es determinista o no. Se dice que es determinista
     * si para cualquier estado con un simbolo solo se puede llegar a un solo
     * estado.
     *
     * @return true si es determinista, false si es no determinista
     */
    public boolean isDeterministic() {
        return !isNotDeterministic();
    }

    /**
     * Dice si este automata es no determinista o determinista. Se dice que un
     * automata es no determinista si desde al menos un estado con un simbolo se
     * puede llegar a mas de un estado.
     *
     * @return true si es no determinista, false si es determinista.
     */
    public boolean isNotDeterministic() {
        for (State s : states) {
            for (int i = 0; i < s.getTransitions().size(); i++) {
                for (int j = i + 1; j < s.getTransitions().size(); j++) {
                    if (s.getTransitions().get(i).getInput() == s.getTransitions().get(j).getInput()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void rightJoin(Automata automataB) {
        if (finalStates.size() != 1 || automataB.finalStates.size() != 1) {
            throw new RuntimeException("Mulitple or none final states");
        }
        Automata automataA = this;

        State oldFinal = automataA.finalStates.get(0);
        automataA.finalStates.clear();
        automataA.finalStates.add(automataB.finalStates.get(0));

        int zt = states.size();
        int zb = automataB.states.size();

        if (automataA.states.size() <= automataB.states.size()) {
            //se sustituye el estado final por el estado inicial del automata B
            //actualizando las transiciones de modo que las transiciones que llevavan al antiguo
            //estado final se dirijan al estado inicial del automata B
            State newFinal = automataB.startState;
            for (State s : automataA.states) {
                for (SimplifiedTransition st : s.getTransitions()) {
                    if (st.getTarget().equals(oldFinal)) {
                        st.setTarget(newFinal);
                    }
                }
            }
            //se elimina oficialmente el estado final de los estados del automata A
            automataA.states.remove(oldFinal);

            //se agregan los estados del automata B al automata A
            for (State s : automataB.getStates()) {
                automataA.addState(s);
            }
        } else {//el automata B tiene menos estados, por lo que es mejor eliminar su estado inicial y dejar el estado final del automata A
            //se pasan todas las transiciones del estado inicial del automata B al estado final del automata A
            for (SimplifiedTransition st : automataB.startState.getTransitions()) {
                oldFinal.addTransition(st.getTarget(), st.getInput());
            }

            //se pasan todos los estados del automata B para el A, exceptuando el inicial del B
            for (State s : automataB.getStates()) {
                if (!s.equals(automataB.startState)) {
                    automataA.addState(s);
                }
            }
        }
    }

    /**
     * Reconoce una cadena en el automata.
     *
     * @param s Cadena a reconocer
     * @param list
     * @return true si el automata reconoce la cadena s, false en caso
     * contrario.
     */
    public boolean recognizeAFND(String s, List<Step> list) {
        Step first = new Step(-1, 2);
        first.getData()[0] = -1;
        first.getData()[1] = "Inicia en el estado inicial: " + startState.getId();
        list.add(first);
        return recognizeAFND(s, startState, 0, list);
    }

    private boolean recognizeAFND(String s, State current, int ind, List<Step> list) {

        if (ind == s.length() && finalStates.contains(current)) {
            Step step = new Step(-1, 2);
            step.getData()[0] = ind;
            step.getData()[1] = "Acepta la cadena";
            list.add(step);
            return true;
        }

        for (SimplifiedTransition st : current.getTransitions()) {
            if (st.getInput() == SimplifiedTransition.EMPTY_INPUT) {
                Step step = new Step(-1, 2);
                step.getData()[0] = ind;
                step.getData()[1] = "Estado: " + st.getTarget().getId();
                list.add(step);
                
                return recognizeAFND(s, st.getTarget(), ind, list);
            } else if (ind < s.length() && st.getInput() == s.charAt(ind)) {
                Step step = new Step(-1, 2);
                step.getData()[0] = ind;
                step.getData()[1] = "Estado: " + st.getTarget().getId();
                list.add(step);
                return recognizeAFND(s, st.getTarget(), ind + 1, list);
            }
        }
        Step step = new Step(-1, 2);
        step.getData()[0] = ind;
        step.getData()[1] = "No acepta";
        list.add(step);
        return false;
    }

    /**
     * Reconoce una cadena en el automata.
     *
     * @param s Cadena a reconocer
     * @param list
     * @return true si el automata reconoce la cadena s, false en caso
     * contrario.
     */
    public boolean recognizeAFD(String s, List<Step> list) {
        Step first = new Step(-1, 2);
        first.getData()[0] = -1;
        first.getData()[1] = "Inicia en el estado inicial: " + startState.getId();
        list.add(first);
        return recognizeAFD(s, startState, 0, list);
    }

    private boolean recognizeAFD(String s, State current, int ind, List<Step> list) {
        
        if (ind == s.length() && finalStates.contains(current)) {
            Step step = new Step(-1, 2);
            step.getData()[0] = ind;
            step.getData()[1] = "Acepta la cadena";
            list.add(step);
            return true;
        }

        for (SimplifiedTransition st : current.getTransitions()) {
            if (ind < s.length() && st.getInput() == s.charAt(ind)) {
                Step step = new Step(-1, 2);
                step.getData()[0] = ind;
                step.getData()[1] = "Estado: " + st.getTarget().getId();
                list.add(step);
                return recognizeAFD(s, st.getTarget(), ind + 1, list);
            }
        }
        Step step = new Step(-1, 2);
        step.getData()[0] = ind;
        step.getData()[1] = "No acepta";
        list.add(step);
        return false;
    }

    /**
     * Convierte un automata no determinista en uno determinista.
     *
     * @param list
     * @return Devuelve un AFD.
     */
    public Automata transformToDFA(List<Step> list) {
        Automata answer = new Automata();
        List<Character> alphabet = getAlphabet();
        State.restartGenerator();

        List<List<State>> eC = new ArrayList<>();
        List<State> nS = new ArrayList<>();
        List<Boolean> mark = new ArrayList<>();
        int not_mark = 0;

        //step1 & 2
        State nS0 = new State();
        nS.add(nS0);
        mark.add(false);
        not_mark++;
        eC.add(e_clausura(this.startState.getId()));

        Step step1 = new Step(1, 2);
        step1.getData()[0] = this.startState;//estado inicial original
        step1.getData()[1] = e_clausura(this.startState.getId());//e-clausura del estado inicial
        list.add(step1);
        Step step2 = new Step(2, 1);
        step2.getData()[0] = eC.get(0);//lista de los nuevos estados
        list.add(step2);
        Step step3 = new Step(3, 1);
        step3.getData()[0] = eC.get(0);
        list.add(step3);

        //step4
        Step step4 = new Step(4, 4);
        step4.getData()[0] = not_mark;
        step4.getData()[1] = ((ArrayList) mark).clone();
        step4.getData()[2] = ((ArrayList) eC).clone();
        step4.getData()[3] = ((ArrayList) nS).clone();
        list.add(step4);
        while (not_mark > 0) {
            System.out.println("-->" + nS.size());
            //search for unmark state
            int i;
            List<State> T = null;
            for (i = 0; i < mark.size(); i++) {
                if (!mark.get(i)) {
                    T = eC.get(i);
                    break;
                }
            }

            //step 5
            mark.set(i, true);
            not_mark--;
            Step step5 = new Step(5, 2);
            step5.getData()[0] = eC.get(i);
            step5.getData()[1] = nS.get(i).getId();
            list.add(step5);

            for (char a : alphabet) {
                //step 6
                Step step6 = new Step(6, 2);
                step6.getData()[0] = a;
                step6.getData()[1] = alphabet;
                list.add(step6);

                //step 7
                List<State> A = mover(T, a);
                Step step7 = new Step(7, 3);
                step7.getData()[0] = T;
                step7.getData()[1] = a;
                step7.getData()[2] = A;
                list.add(step7);

                //step 8
                List<State> U = e_clausura(A);
                Step step8 = new Step(8, 2);
                step8.getData()[0] = A;
                step8.getData()[1] = U;
                list.add(step8);

                //step 9
                boolean con = eC.contains(U);
                Step step9 = new Step(9, 5);
                step9.getData()[0] = con;
                step9.getData()[1] = U;
                step9.getData()[2] = ((ArrayList) eC).clone();
                step9.getData()[3] = ((ArrayList) nS).clone();
                step9.getData()[4] = ((ArrayList) mark).clone();
                list.add(step9);
                if (!con) {
                    //step 10
                    eC.add(U);
                    nS.add(new State());
                    mark.add(false);
                    not_mark++;

                    Step step10 = new Step(10, 4);
                    step10.getData()[0] = U;
                    step10.getData()[1] = ((ArrayList) eC).clone();
                    step10.getData()[2] = ((ArrayList) nS).clone();
                    step10.getData()[3] = ((ArrayList) mark).clone();
                    list.add(step10);
                }

                //step 11
                //looking for U index
                int j;
                for (j = 0; j < eC.size(); j++) {
                    if (eC.get(j).equals(U)) {
                        break;
                    }
                }
                nS.get(i).addTransition(nS.get(j), a);

                Step step11 = new Step(11, 4);
                step11.getData()[0] = T;
                step11.getData()[1] = a;
                step11.getData()[2] = U;
                List<Transition> trans = new ArrayList<>();
                nS.stream().forEach((s) -> {
                    s.getTransitions().stream().forEach((st) -> {
                        trans.add(new Transition(s, st.getTarget(), st.getInput()));
                    });
                });
                step11.getData()[3] = trans;
                list.add(step11);
            }

            //step4
            Step step4n = new Step(4, 4);
            step4n.getData()[0] = not_mark;
            step4n.getData()[1] = ((ArrayList) mark).clone();
            step4n.getData()[2] = ((ArrayList) eC).clone();
            step4n.getData()[3] = ((ArrayList) nS).clone();
            list.add(step4n);
        }

        //building the automata:
        answer.startState = nS0;
        for (State s : nS) {
            answer.addState(s);
        }
        //adding final states -> step 4
        for (int i = 0; i < eC.size(); i++) {
            List<State> lc = eC.get(i);
            for (State s : finalStates) {
                if (lc.contains(s)) {
                    answer.addFinalState(nS.get(i));
                }
            }
        }
        //step 12
        Step step12 = new Step(12, 1);
        step12.getData()[0] = answer.getFinalStates();
        list.add(step12);

        return answer;
    }

    public List<State> e_clausura(int n) {
        List<State> clausura = new ArrayList<>();
        State T = search(n);
        if (T == null) {
            return clausura;
        }
        clausura.add(T);

        Stack<State> stack = new Stack<>();
        stack.push(T);

        while (!stack.isEmpty()) {
            State U = stack.pop();
            for (SimplifiedTransition st : U.getTransitions()) {
                if (st.input == SimplifiedTransition.EMPTY_INPUT) {
                    State V = st.getTarget();
                    if (!clausura.contains(V)) {
                        clausura.add(V);
                        if (!stack.contains(V) && !V.equals(U)) {
                            stack.push(V);
                        }
                    }
                }
            }
        }

        AutomataUtil.sort(clausura);
        return clausura;
    }

    public List<State> e_clausura(List<State> l) {
        List<State> clausura = new ArrayList<>();
        for (State s : l) {
            List<State> c = e_clausura(s.getId());
            for (State s2 : c) {
                if (!clausura.contains(s2)) {
                    clausura.add(s2);
                }
            }
        }

        AutomataUtil.sort(clausura);
        return clausura;
    }

    public List<State> mover(List<State> TList, char a) {
        List<State> move = new ArrayList<>();

        for (State T : TList) {
            for (SimplifiedTransition st : T.getTransitions()) {
                if (st.getInput() == a && !move.contains(st.getTarget())) {
                    move.add(st.getTarget());
                }
            }
        }

        return move;
    }

    public Automata transformToMDFA(List<Step> list) {
        List<Character> alphabet = getAlphabet();

        //step 1 entontrar estados inaccesibles;
        Stack<Integer> toinspect = new Stack<>();
        toinspect.push(findIndex(startState));
        final boolean visited[] = new boolean[states.size()];

        while (!toinspect.isEmpty()) {
            int stIndex = toinspect.pop();
            if (!visited[stIndex]) {
                visited[stIndex] = true;

                states.get(stIndex).getTransitions().stream().forEach((st) -> {
                    toinspect.push(findIndex(st.getTarget()));
                });
            }
        }

        Step step1 = new Step(1, 1);
        List<Integer> deleted = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                deleted.add(states.get(i).getId());
            }
        }
        step1.getData()[0] = deleted;
        list.add(step1);

        //construyendo el nuevo automata resultante...
        Automata nA = new Automata();
        nA.setStartState(startState.getId());
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                State s = states.get(i);
                if (finalStates.contains(s)) {
                    nA.addFinalState(s.getId());
                } else {
                    nA.addState(s.getId());
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                State s = states.get(i);
                for (SimplifiedTransition st : s.getTransitions()) {
                    int p = findIndex(st.getTarget());
                    if (visited[p]) {
                        nA.addTransition(s.getId(), st.getTarget().getId(), st.getInput());
                    }
                }
            }
        }

        //paso 2, contruir k = 0
        List<Group> k0 = new ArrayList<>();
        Group nf = new Group();
        nA.states.stream().filter((s) -> (!nA.finalStates.contains(s))).forEach((s) -> {
            nf.addState(s);
        });
        k0.add(nf);
        Group fina = new Group();
        nA.finalStates.stream().forEach((s) -> {
            fina.addState(s);
        });
        k0.add(fina);

        for (int i = 0; i < k0.size(); i++) {//terminar de contruir los grupos...
            k0.get(i).build(k0, i, alphabet);
        }

        Step step2 = new Step(2, 2);
        step2.getData()[0] = k0;
        step2.getData()[1] = alphabet;
        list.add(step2);

        List<Group> kPlusOne;

        do {
            kPlusOne = new ArrayList<>();
            for (Group g : k0) {//hago la nueva division de todos los grupos
                List<Group> spl = g.split();
                for (Group gspl : spl) {
                    kPlusOne.add(gspl);
                }
            }
            for (int i = 0; i < kPlusOne.size(); i++) {//terminar de contruir los grupos...
                kPlusOne.get(i).build(kPlusOne, i, alphabet);
            }

            Step step3 = new Step(3, 3);
            step3.getData()[0] = k0;
            step3.getData()[1] = kPlusOne;
            step3.getData()[2] = alphabet;
            list.add(step3);

            Step step4 = new Step(4, 1);
            step4.getData()[0] = k0.size() == kPlusOne.size();
            list.add(step4);

            if (k0.size() == kPlusOne.size()) {
                break;//Pk-1 = Pk terminar pfinal = pk 
            }
            k0 = kPlusOne;
        } while (true);

        Automata fin = new Automata();
        for (int i = 0; i < kPlusOne.size(); i++) {//adicionar los estados
            fin.addState(i);
        }

        for (int i = 0; i < kPlusOne.size(); i++) {//se construyen las transiciones
            Entry rep = kPlusOne.get(i).getRepresent();
            for (int j = 0; j < rep.list.size(); j++) {
                fin.addTransition(i, rep.list.get(j), alphabet.get(j));
            }
        }

        for (int i = 0; i < kPlusOne.size(); i++) {//se agrega el estado inicial
            if (kPlusOne.get(i).hasState(startState.getId())) {
                fin.setStartState(i);
                break;
            }
        }

        for (int i = 0; i < kPlusOne.size(); i++) {//se agregan los estados finales
            Group g = kPlusOne.get(i);
            for (int j = 0; j < nA.finalStates.size(); j++) {
                if (g.hasState(nA.finalStates.get(j).getId())) {
                    fin.addFinalState(i);
                    break;
                }
            }
        }

        Step step5 = new Step(5, 1);
        step5.getData()[0] = fin;
        list.add(step5);

        //AutomataUtil.printA(nA);
        return fin;
    }

    private int findIndex(State s) {
        for (int i = 0; i < states.size(); i++) {
            if (s.equals(states.get(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca el estado que tiene el identificador especificado.
     *
     * @param id Identificador del estado que se desea buscar.
     * @return Retorna el estado con el identificador especificado o null si no
     * existe.
     */
    public State search(int id) {
        for (State s : states) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    ///SETTERS AND GETTERS...
    public List<State> getStates() {
        return states;
    }

    public State getStartState() {
        return startState;
    }

    public List<State> getFinalStates() {
        return finalStates;
    }

}
