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

/**
 *
 * @author Yasiel Cabrera Alonso
 */
public class SimplifiedTransition {
    
    public static final char EMPTY_INPUT = '\0';
    
    /**
     * caracter con el cual se realiza la transicion. Si el valor de este campo
     * es '\0' se toma como cadena vacia.
     */
    protected char input;
    /**
     * Estado al cual se debe ir desde el estado en cuestion con el caracter de
     * entrada.
     */
    protected State target;

    /**
     * Se crea una transición hasta el estado target con el caracter input.
     *
     * @param target estado al cual se mueve el automata.
     * @param input caracter de entrada con el que se realiza la transición.
     */
    public SimplifiedTransition(State target, char input) {
        this.target = target;
        this.input = input;
    }

    /**
     * e-transición hasta el estado indicado.
     *
     * @param target
     */
    public SimplifiedTransition(State target) {
        this.target = target;
        input = EMPTY_INPUT;
    }

    /**
     * Compara dos transiciones.
     *
     * @param obj Transicion con la que se comparará.
     * @return True si ambas transiciones tienen el mismo catacter de entrada y
     * llegan al mismo estado.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimplifiedTransition) {
            SimplifiedTransition st = (SimplifiedTransition) obj;
            return input == st.input && target.equals(st.target);
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    ///GETTER AND SETTERS....
    public char getInput() {
        return input;
    }

    public void setInput(char input) {
        this.input = input;
    }

    public State getTarget() {
        return target;
    }

    public void setTarget(State target) {
        this.target = target;
    }

}
