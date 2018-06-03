/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.core;

import com.uclv.crash.core.Group.Entry;
import java.util.List;

/**
 *
 * @author Yasiel Cabrera
 */
public class Test {
    public static void main(String[] args) {
//        Automata a = new Automata();
//        a.addState(0);
//        a.addState(1);
//        a.addState(2);
//        a.addState(3);
//        a.addState(4);
//        a.addState(5);
//        a.addState(6);
//        a.addTransition(0, 1, '0');
//        a.addTransition(0, 3, '1');
//        a.addTransition(1, 1, '0');
//        a.addTransition(1, 2, '1');
//        a.addTransition(4, 1, '0');
//        a.addTransition(3, 4, '1');
//        a.addTransition(2, 3, '0');
//        a.addTransition(4, 2, '1');
//        a.addTransition(2, 4, '1');
//        a.addTransition(5, 2, '0');
//        a.addTransition(6, 4, '1');
//        a.addTransition(5, 6, '0');
//        a.addTransition(6, 5, '1');
//        a.setStartState(0);
//        a.addFinalState(2);
//        a.addFinalState(4);
//        
        //AutomataUtil.printA(a);
        
        
        //AutomataUtil.printA(a.transformToMDFA());
        
        String a = "a*b*";
        AutomataUtil.printA(RegularExpresionTraductor.translate(a));
    }
    
    public static void printG(List<Group> gr, List<Character> al){
        System.out.print("    ");
        for(Character c : al){
            System.out.print(c+" ");
        }
        System.out.println("\n----------------");
        for(Group g : gr){
            for(Entry e : g.entrys){
                System.out.print(e.state.getId()+" | ");
                for(Integer i : e.list){
                    System.out.print(i+" ");
                }
                System.out.println("");
            }
            System.out.println("-----------------");
        }
    }
}
