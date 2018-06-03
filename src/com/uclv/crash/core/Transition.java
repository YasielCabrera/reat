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
public class Transition extends SimplifiedTransition {

    /**
     * Estado actual desde el cual se realiza la transición.
     */
    private State start;

    /**
     * Se crea una transición desde el estado start hasta el estado target con
     * el caracter input.
     *
     * @param start Estado desde el que parte la transición.
     * @param target Estado destino de la transición.
     * @param input Caracter de entrada con el que se hace la transición.
     */
    public Transition(State start, State target, char input) {
        super(target, input);
        this.start = start;
    }

    /**
     * e-transición desde el estado start hasta target
     *
     * @param start Estado desde el que parte la e-transición.
     * @param target Estado destino de la e-transición.
     */
    public Transition(State start, State target) {
        this(start, target, EMPTY_INPUT);
    }

    /**
     * Compara dos transiciones.
     *
     * @param obj Segunda transición para comparar.
     * @return True si ambas transiciones parten del mismo estado inicial y con
     * el mismo caracter de entrada llegan al mismo estado, Flase en caso
     * contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transition) {
            Transition t = (Transition) obj;
            return input == t.input && start.equals(t.start) && target.equals(t.target);
        }
        return false;
    }

    ////GETTERS AND SETTERS....
    public State getStart() {
        return start;
    }

    public void setStart(State start) {
        this.start = start;
    }

}
