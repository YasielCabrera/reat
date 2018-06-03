/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui.partials;

import com.uclv.crash.gui.App;
import com.uclv.crash.gui.utils.ActionDelegate;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Yasiel Cabrera
 */
public class EditorEvents {
    
    public static void initializeEvents(){
        afndEvents();
        afdEvents();
        afdminEvents();
        recogniseEvents();
    }

    private static void afndEvents(){
        addBasicEvent(WorkEditor.REFERENCE.getAfndBttn(), 
                EditorActions::afndOnClickActions , 
                WorkEditor.REFERENCE.getAfndIndicator(), 
                WorkEditor.AFND_SECTION);
    }
    
    private static void afdEvents(){
        addBasicEvent(WorkEditor.REFERENCE.getAfdBttn(), 
                EditorActions::afdOnClickActions , 
                WorkEditor.REFERENCE.getAfdIndicator(), 
                WorkEditor.AFD_SECTION);
    }
    
    private static void afdminEvents(){
        addBasicEvent(WorkEditor.REFERENCE.getAfdminBttn(), 
                EditorActions::afdminOnClickActions , 
                WorkEditor.REFERENCE.getAfdminIndicator(), 
                WorkEditor.AFDM_SECTION);
    }
    
    private static void recogniseEvents(){
        addBasicEvent(WorkEditor.REFERENCE.getRecogniseBttn(), 
                EditorActions::recogniseOnClickActions , 
                WorkEditor.REFERENCE.getRecogniseIndicator(), 
                WorkEditor.RECOGNISE_SECTION);
    }

    
    /**
     * Añade los eventos basicos del ToolBar de la App
     *
     * @param comp componente al cual se le van a agregar los eventos
     * @param action accion principal a ejecutar
     * @param indicator indicador que pertenece al componente al cual se le va a
     * agregar los eventos
     * @param section id de la seccion que se va a comprobar
     */
    private static void addBasicEvent(JComponent comp, ActionDelegate action, JLabel indicator, int section) {
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                action.doSomething();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                indicator.setVisible(true);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (WorkEditor.REFERENCE.activeSection != section) {
                    indicator.setVisible(false);
                }
            }
        });
    }
}
