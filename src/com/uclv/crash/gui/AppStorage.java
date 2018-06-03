/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui;

import com.uclv.crash.core.Automata;
import com.uclv.crash.core.AutomataViewer;
import com.uclv.crash.gui.partials.afdstep.AFD;
import com.uclv.crash.gui.partials.AFND;
import com.uclv.crash.gui.partials.SettingsOp;
import com.uclv.crash.gui.partials.Help;
import com.uclv.crash.gui.partials.Save;
import com.uclv.crash.gui.partials.RegularExpresion;
import com.uclv.crash.gui.partials.New;
import com.uclv.crash.gui.partials.WorkEditor;
import com.uclv.crash.gui.partials.afdminstep.AFDMin;

/**
 *
 * @author Yasiel Cabrera Alonso
 */
public class AppStorage {
    //GLOBAL OBJECTS....
    private static com.uclv.crash.gui.Settings settings;
    /**
     * Expresion regular actual que se esta mostrando
     */
    private static String regularExpresion;
    /**
     * Automata finito no determinista generado o creado
     */
    private static Automata afnd;
    /**
     * automata finito determinista generado o creado
     */
    private static Automata afd;
    /**
     * automata finito determinista minimo generado a partir del afd.
     */
    private static Automata afdmin;
    
    
    private static AutomataViewer afndViewer;
    
    private static AutomataViewer afdViewer;
    
    private static AutomataViewer afdMinViewer;
    
    
    
    //FROM APP FRAME
    
    /**
     * Panel del WorkEditor
     */
    private static final WorkEditor WORK_EDITOR = new WorkEditor();
    /**
     * Panel donde se editan la ER
     */
    private static final RegularExpresion REGULAR_EXPRESION = new RegularExpresion();
    /**
     * Panel donde se muestran las opciones de crear automata o ER
     */
    private static final New NEW = new New();
    /**
     * Panel con las opciones de guardar los automatas y ER
     */
    private static final Save SAVE = new Save();
    /**
     * Panel que muestra ayuda de la aplicacion
     */
    public static final Help HELP = new Help();
    
    
    //FORM WORKEDITOR
    /**
     * Panel que muestra un AFND en el WordEditor
     */
    private static final AFND AFND = new AFND();
    /**
     * Panel que muestra un AFD en el WordEditor
     */
    private static final AFD AFD = new AFD();
    
    private static final AFDMin AFD_MIN = new AFDMin();
    
    //GETTERS AND SETTERS........
    
    public static AFDMin getAFD_MIN() {
        return AFD_MIN;
    }

    public static AFD getAFD() {
        return AFD;
    }

    public static AFND getAFND() {
        return AFND;
    }

    public static Help getHELP() {
        return HELP;
    }

    public static Save getSAVE() {
        return SAVE;
    }

    public static New getNEW() {
        return NEW;
    }

    public static RegularExpresion getREGULAR_EXPRESION() {
        return REGULAR_EXPRESION;
    }

    public static WorkEditor getWORK_EDITOR() {
        return WORK_EDITOR;
    }

    public static String getRegularExpresion() {
        return regularExpresion;
    }

    public static void setRegularExpresion(String regularExpresion) {
        AppStorage.regularExpresion = regularExpresion;
    }

    public static Automata getAfnd() {
        return afnd;
    }

    public static void setAfnd(Automata afnd) {
        AppStorage.afnd = afnd;
    }

    public static Automata getAfd() {
        return afd;
    }

    public static void setAfd(Automata afd) {
        AppStorage.afd = afd;
    }

    public static Automata getAfdmin() {
        return afdmin;
    }

    public static void setAfdmin(Automata afdmin) {
        AppStorage.afdmin = afdmin;
    }

    public static AutomataViewer getAfndViewer() {
        return afndViewer;
    }

    public static void setAfndViewer(AutomataViewer afndViewer) {
        AppStorage.afndViewer = afndViewer;
    }

    public static AutomataViewer getAfdViewer() {
        return afdViewer;
    }

    public static void setAfdViewer(AutomataViewer afdViewer) {
        AppStorage.afdViewer = afdViewer;
    }

    public static AutomataViewer getAfdMinViewer() {
        return afdMinViewer;
    }

    public static void setAfdMinViewer(AutomataViewer afdMinViewer) {
        AppStorage.afdMinViewer = afdMinViewer;
    }

    public static com.uclv.crash.gui.Settings getSettings() {
        return settings;
    }

    public static void setSettings(com.uclv.crash.gui.Settings settings) {
        AppStorage.settings = settings;
    }
    
    
    
}
