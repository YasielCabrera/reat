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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasiel Cabrera Alonso
 */
public class State {

    private int id;

    /**
     * Transiciones que parten desde este estado.
     */
    private List<SimplifiedTransition> transitions;

    public State() {
        transitions = new ArrayList<>();
        id = State.giveMeID();
    }
    
    public State(int id) {
        transitions = new ArrayList<>();
        this.id = id;
    }
    
    private State(int id, ArrayList<SimplifiedTransition> transitions){
        this.id = id;
        this.transitions = (List<SimplifiedTransition>) transitions.clone();
    }

    /**
     * Añade una nueva transición si no existe.
     * @param target
     * @param input 
     */
    public void addTransition(State target, char input) {
        SimplifiedTransition trans = new SimplifiedTransition(target, input);
        if (!transitions.contains(trans)) {
            transitions.add(trans);
        }
    }
    
    /**
     * Añade una nueva transición si no existe.
     * @param target
     */
    public void addTransition(State target) {
        this.addTransition(target, '\0');
    }

    /**
     * Compara dos estados
     *
     * @param obj Segundo estado para comparar
     * @return True si ambos estados tienen el mismo id y todas las transiciones
     * son iguales, falso en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State t = (State) obj;
            return t.id == id && t.transitions.equals(transitions);
        }
        return false;
    }

    @Override
    protected Object clone() {
        return new State(id, (ArrayList<SimplifiedTransition>) transitions);
    }

    
    /////UTIL TO CREATE NEW STATES...
    /**
     * Contador global para crear los ids de los estados.
     */
    private static int idGenerator = 0;

    /**
     * Crea ids para los estados
     *
     * @return Devuelve un entero con un numero (int) para el identificador del
     * estado.
     */
    public static int giveMeID() {
        return State.idGenerator++;
    }

    /**
     * Reinicia en 0 la cuenta de los identificadores para los estados.
     */
    public static void restartGenerator() {
        State.idGenerator = 0;
    }
    /////END UTILS

    ///GETTERS AND SETTERS....
    public List<SimplifiedTransition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<SimplifiedTransition> transitions) {
        this.transitions = transitions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

}
