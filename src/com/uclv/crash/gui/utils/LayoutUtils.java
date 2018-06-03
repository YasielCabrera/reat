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
package com.uclv.crash.gui.utils;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Yasiel Cabrera Alonso
 */
public class LayoutUtils {
    private static final GridBagConstraints GBC = new GridBagConstraints();
    
    public static void setPanelInto(JPanel panel, JComponent target){
        panel.removeAll();
        if( !(panel.getLayout() instanceof GridBagLayout)){
            panel.setLayout(new GridBagLayout());
        }
        GBC.gridx = 0;
        GBC.gridy = 0;
        GBC.fill = GridBagConstraints.BOTH;
        GBC.weightx = 1.0;
        GBC.weighty = 1.0;
        panel.add(target, GBC);
        panel.revalidate();
        panel.repaint();
        target.revalidate();
        target.repaint();
    }
}
