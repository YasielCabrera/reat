/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui.partials;

import com.uclv.crash.gui.AppStorage;
import com.uclv.crash.gui.partials.recognition.RecognitionStart;
import com.uclv.crash.gui.utils.LayoutUtils;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Yasiel Cabrera
 */
public class EditorActions {

    public static void afndOnClickActions() {
        basicAction(WorkEditor.AFND_SECTION, WorkEditor.REFERENCE.getAfndIndicator(), AppStorage.getAFND());
    }

    public static void afdOnClickActions() {
        basicAction(WorkEditor.AFD_SECTION, WorkEditor.REFERENCE.getAfdIndicator(), AppStorage.getAFD());
    }

    public static void afdminOnClickActions() {
        basicAction(WorkEditor.AFDM_SECTION, WorkEditor.REFERENCE.getAfdminIndicator(), AppStorage.getAFD_MIN());
    }

    public static void recogniseOnClickActions() {
        //basicAction(WorkEditor.RECOGNISE_SECTION, WorkEditor.REFERENCE.getRecogniseIndicator(), null);
        if (AppStorage.getWORK_EDITOR().toggleRecognitionPanel()) {
            LayoutUtils.setPanelInto(AppStorage.getWORK_EDITOR().getRecognitionPanel(), new RecognitionStart());
        }

    }

    private static void basicAction(int section, JLabel indicator, JComponent comp) {
        if (WorkEditor.REFERENCE.activeSection != section) {
            WorkEditor.REFERENCE.activeSection = section;
            WorkEditor.REFERENCE.clearIndicators();
            indicator.setVisible(true);
            if (comp instanceof Recordable) {
                ((Recordable) comp).remember();
            }
            LayoutUtils.setPanelInto(WorkEditor.REFERENCE.workSpacePanel, comp);
        }
    }
}
