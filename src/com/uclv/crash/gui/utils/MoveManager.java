/*
 * Copyright (C) 2017 Yasiel Cabrera
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

import java.awt.Component;
import java.awt.Window;

/**
 * Manejador de movimiento de las ventanas
 *
 * @author Yasiel Cabrera
 */
public class MoveManager {

    private static int x;
    private static int y;
    
    public static int offset = 0;

    /**
     * Aplica al componenete "C" los eventos y el mecanismo necesario para que
     * al oprimir el mouse y moverlo, el frame "window" se mueva junto al
     * cursor.
     *
     * @param c
     * @param window
     */
    public static void setAppMoveListener(Component c, Window window) {
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                x = evt.getX()+offset;
                y = evt.getY();
            }
        });
        c.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                window.setLocation(evt.getLocationOnScreen().x - x, evt.getLocationOnScreen().y - y);
            }
        });
    }
}
