/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasiel Cabrera
 */
public class Settings implements Serializable {

    private static final long serialVersionUID = 256358L;

    private static final String SETTINGS_DIRECTORY = "";
    private static final String SETTINGS_FILE = "settings";

    public Settings() {

    }

    public void load() {
        if (new File(SETTINGS_DIRECTORY + SETTINGS_FILE).exists()) {
            System.out.println(new File(SETTINGS_DIRECTORY  + SETTINGS_FILE).getAbsolutePath());
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(SETTINGS_DIRECTORY  + SETTINGS_FILE));
                Settings s = (Settings) in.readObject();

                this.windowsWidth = s.windowsWidth;
                this.windowsHeight = s.windowsHeight;

                in.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("there is not settings file...");
        }
    }

    public boolean save() {
        try {
            File dir = new File(SETTINGS_DIRECTORY);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SETTINGS_DIRECTORY + SETTINGS_FILE));
            out.writeObject(this);
            out.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    public void apply() {
        App.REFERENCE.setSize(windowsWidth, windowsHeight);
        if(isWindowsMaximized()){
            App.REFERENCE.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        }else{
            App.REFERENCE.setExtendedState(javax.swing.JFrame.NORMAL);
        }
        
    }

    //atrinutos....
    private int windowsWidth = 1000;

    private int windowsHeight = 600;
    
    private boolean isWindowsMaximized = false;

    //GETTERS AND SETTERS
    public int getWindowsWidth() {
        return windowsWidth;
    }

    public void setWindowsWidth(int windowsWidth) {
        this.windowsWidth = windowsWidth;
    }

    public int getWindowsHeight() {
        return windowsHeight;
    }

    public void setWindowsHeight(int windowsHeight) {
        this.windowsHeight = windowsHeight;
    }

    public boolean isWindowsMaximized() {
        return isWindowsMaximized;
    }

    public void setIsWindowsMaximized(boolean isWindowsMaximized) {
        this.isWindowsMaximized = isWindowsMaximized;
    }

    
}
