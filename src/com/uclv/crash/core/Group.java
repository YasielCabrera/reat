/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasiel Cabrera
 */
public class Group {

    public List<Entry> entrys;

    public Group() {
        entrys = new ArrayList<>();
    }

    public void addState(State s) {
        entrys.add(new Entry(s));
    }
    
    /**
     * Divide el grupo en subgrupos donde en cada subgrupo solo estan los estados i-distingibles.
     * @return 
     */
    public List<Group> split(){
        List<Group> list = new ArrayList<>();
        
        List<Entry> oldEnt = (List<Entry>) ((ArrayList<Entry>)entrys).clone();
        
        for(int i = 0; i < oldEnt.size(); i++){
            Group g = new Group();
            g.addState(oldEnt.get(i).state);
            for(int j = i+1; j < oldEnt.size();){
                if(oldEnt.get(i).equals(oldEnt.get(j))){
                    g.addState(oldEnt.get(j).state);
                    oldEnt.remove(j);
                }else{
                    j++;
                }
            }
            
            list.add(g);
        }
        
        return list;
    }

    /**
     * Adiciona a que grupo se dirije cada estado con cada caracter del alfabeto
     *
     * @param groups lista de todos lo grupos
     * @param whoIAm dentro de la lista de los grupos, indica que posicion ocupa
     * este grupo
     * @param alphabet el alfabeto del automata
     */
    public void build(List<Group> groups, int whoIAm, List<Character> alphabet) {
        for (Entry e : entrys) {//actualizo a que grupo va cada estado con cada simbolo del alfabeto            
            for (int i = 0; i < alphabet.size(); i++) {//por cada simbolo del alfabeto tengo que poner a que grupo va
                char ccha = alphabet.get(i);
                int whereIdGo = -1;
                for (SimplifiedTransition st : e.state.getTransitions()) {//busco con el caracter actual a que estado va
                    if (st.getInput() == ccha) {
                        whereIdGo = st.getTarget().getId();
                        break;
                    }
                }
                if (whereIdGo == -1) {//no hay transision con el caracter ccha
                    e.list.add(whoIAm);//me quedo en el mismo grupo...
                } else {
                    for (int j = 0; j < groups.size(); j++) {//adiciono a que grupo va con el caracter actual
                        if (groups.get(j).hasState(whereIdGo)) {
                            e.list.add(j);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Comprueba si este grupo tiene un estado con el id especificado
     *
     * @param id identificador del estado que se esta buscando
     * @return true si el estado esta en el grupo, false en caso contrario.
     */
    public boolean hasState(int id) {
        return entrys.stream().anyMatch((e) -> (e.state.getId() == id));
    }
    
    public Entry getRepresent(){
        return entrys.get(0);
    }

    public class Entry {

        public State state;
        public List<Integer> list;

        public Entry(State s) {
            state = s;
            list = new ArrayList<>();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Entry) {
                Entry q = (Entry) obj;
                return list.equals(q.list);
            }
            return false;
        }

        @Override
        protected Object clone() {
            Entry n = new Entry((State) state.clone());
            n.list = (List<Integer>) ((ArrayList<Integer>)list).clone();
            return n;
        }
    }
}
