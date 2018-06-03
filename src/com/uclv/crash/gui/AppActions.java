/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui;

import com.uclv.crash.gui.partials.Recordable;
import com.uclv.crash.gui.partials.*;
import com.uclv.crash.gui.utils.LayoutUtils;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Yasiel Cabrera
 */
public class AppActions {
    
    //actions
    public static void showHome(){
        show(App.HOME_SECTION, App.REFERENCE.getHomeIndicator(), AppStorage.getREGULAR_EXPRESION());
    }
    
    public static void showWorkSpace(){
        show(App.WORKSPACE_SECTION, App.REFERENCE.getWorkspaceIndicator(), AppStorage.getWORK_EDITOR());
    }
    
    public static void showNew(){
        show(App.NEW_SECTION, App.REFERENCE.getNewIndicator(), AppStorage.getNEW());
    }
    
    public static void showSave(){
        show(App.SAVE_SECTION, App.REFERENCE.getSaveIndicator(), AppStorage.getSAVE());
    }
    
    public static void showSettings(){
        show(App.SETTINGS_SECTION, App.REFERENCE.getSettingsIndicator(), new SettingsOp());
    }
    
    public static void showHelp(){
        try {
            Desktop.getDesktop().browse(new URI("http://www.github.com/yasiel9506/reat"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(AppActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void show(int section, JLabel indicator, JComponent comp){
        if (App.REFERENCE.activeSection != section) {
            App.REFERENCE.activeSection = section;
            App.REFERENCE.clearIndicators();
            indicator.setVisible(true);
            if(comp instanceof Recordable){
                ((Recordable)comp).remember();
            }
            LayoutUtils.setPanelInto(App.REFERENCE.cover, comp);
            App.REFERENCE.deactivateBackArrow();
        }
    }
}
