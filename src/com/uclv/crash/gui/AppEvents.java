/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui;

import com.uclv.crash.gui.utils.ActionDelegate;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Yasiel Cabrera
 */
public class AppEvents {

    /**
     * inicializa todos los eventos en los respectivos componentes
     */
    public static void initializeEvents() {
        homeEvents();
        newEvents();
        saveEvents();
        workspaceEvents();
        settingsEvents();
        helpEvents();
    }

    /**
     * Adiciona los eventos necesarios al boton de home
     */
    private static void homeEvents() {
        addBasicEvent(App.REFERENCE.getHomeBttn(), new ActionDelegate() {

            @Override
            public void doSomething() {
                AppActions.showHome();
            }
        }, App.REFERENCE.getHomeIndicator(), App.HOME_SECTION);
    }

    private static void newEvents(){
        addBasicEvent(App.REFERENCE.getNewBttn(), new ActionDelegate() {

            @Override
            public void doSomething() {
                AppActions.showNew();
            }
        }, App.REFERENCE.getNewIndicator(), App.NEW_SECTION);
    }
    
    private static void saveEvents(){
        addBasicEvent(App.REFERENCE.getSaveBttn(), new ActionDelegate() {

            @Override
            public void doSomething() {
                AppActions.showSave();
            }
        }, App.REFERENCE.getSaveIndicator(), App.SAVE_SECTION);
    }
    
    private static void workspaceEvents(){
        addBasicEvent(App.REFERENCE.getWorkspaceBttn(), new ActionDelegate() {

            @Override
            public void doSomething() {
                AppActions.showWorkSpace();
            }
        }, App.REFERENCE.getWorkspaceIndicator(), App.WORKSPACE_SECTION);
    }
    
    private static void settingsEvents(){
        addBasicEvent(App.REFERENCE.getSettingsBttn(), new ActionDelegate() {

            @Override
            public void doSomething() {
                AppActions.showSettings();
            }
        }, App.REFERENCE.getSettingsIndicator(), App.SETTINGS_SECTION);
    }
    
    private static void helpEvents(){
        addBasicEvent(App.REFERENCE.getHelpBttn(), new ActionDelegate() {

            @Override
            public void doSomething() {
                AppActions.showHelp();
            }
        }, App.REFERENCE.getHelpIndicator(), App.HELP_SECTION);
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
                if (App.REFERENCE.activeSection != section) {
                    indicator.setVisible(false);
                }
            }
        });
    }
}
