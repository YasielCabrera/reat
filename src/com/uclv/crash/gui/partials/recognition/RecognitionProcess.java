/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui.partials.recognition;

import com.uclv.crash.core.AutomataViewer;
import com.uclv.crash.gui.AppStorage;
import com.uclv.crash.gui.partials.afdstep.Step;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Yasiel Cabrera
 */
public final class RecognitionProcess extends javax.swing.JPanel {

    /**
     * cinta que tendra todos los caracteres
     */
    private final JLabel[] cinta = new JLabel[25];

    /**
     * Cadena que se esta procesando
     */
    private final String string;

    /**
     * Lista de todos los pasos que da el algoritmo de reconocimiento para dar
     * un veredicto
     */
    private final List<Step> stepList;

    /**
     * Paso actual.
     */
    private int currentStep;

    /**
     * una referencia al componenete donde se pinta el automata en el WorkEditor
     */
    private AutomataViewer viewer;

    private Thread thread;

    /**
     * intervalo entre dos pares de pasos.
     */
    private static final int INTERVAL = 2000;

    /**
     * Creates new form RecognitionProcess
     *
     * @param section
     */
    public RecognitionProcess(String section) {
        initComponents();

        string = RecognitionDone.lastStr;
        stepList = RecognitionDone.recognition;
        switch (section) {
            case "AFND":
                viewer = AppStorage.getAfndViewer();
                break;
            case "AFD":
                viewer = AppStorage.getAfdViewer();
                break;
            case "AFDM":
                viewer = AppStorage.getAfdMinViewer();
                break;
        }

        cinta[0] = w1;
        cinta[1] = w2;
        cinta[2] = w3;
        cinta[3] = w4;
        cinta[4] = w5;
        cinta[5] = w6;
        cinta[6] = w7;
        cinta[7] = w8;
        cinta[8] = w9;
        cinta[9] = w10;
        cinta[10] = w11;
        cinta[11] = w12;
        cinta[12] = w13;
        cinta[13] = w14;
        cinta[14] = w15;
        cinta[15] = w16;
        cinta[16] = w17;
        cinta[17] = w18;
        cinta[18] = w19;
        cinta[19] = w20;
        cinta[20] = w21;
        cinta[21] = w22;
        cinta[22] = w23;
        cinta[23] = w24;
        cinta[24] = w25;

        headAt(-1);
        currentStep = -1;
        stepCountLb.setText("Paso: 0 / " + stepList.size());
        stepSizeLb.setText("Aún no ha iniciado");
    }

    /**
     * Pone el cabezal de en una posicion especifica de la cadena y coloca la
     * cadena en la cinta
     *
     * @param index
     */
    public void headAt(int index) {
        cinta[12].setText((index >= 0 && index < string.length()) ? Character.toString(string.charAt(index)) : " ");

        for (int i = 11; i >= 0; i--) {
            cinta[i].setText((index - (12 - i) < 0) ? " " : Character.toString(string.charAt(index - (12 - i))));
        }
        for (int i = 13; i < 25; i++) {
            cinta[i].setText((index + (i - 12) >= string.length()) ? " " : Character.toString(string.charAt(index + (i - 12))));
        }
    }

    /**
     * inicia el recoocimiento de forma automatica.
     */
    private void play() {
        if (thread == null || !thread.isAlive()) {
            thread = new Thread(() -> {
                int lastStep = currentStep;
                while (currentStep < stepList.size() - 1) {
                    if (currentStep - lastStep + 1 != 1) {
                        continue;
                    }
                    
                    nextStepBttnMouseClicked(null);

                    lastStep = currentStep;
                    try {
                        Thread.sleep(RecognitionProcess.INTERVAL);
                    } catch (InterruptedException ex) {
                    }
                }
                playpauseBttn.setIcon(play);
                played = false;
                isStarted = false;
            });
        }
        played = true;
        playpauseBttn.setIcon(pause);
        
        if (isStarted) {
            thread.resume();
        } else {
            thread.start();
            isStarted = true;
        }
    }

    private void pause() {
        if (thread != null && thread.isAlive()) {
            thread.suspend();
            playpauseBttn.setIcon(play);
            played = false;
        }
    }

    private boolean isStarted = false;
    private boolean played = false;
    private ImageIcon play = new javax.swing.ImageIcon(getClass().getResource("/com/uclv/crash/gui/img/icons8_Play_35px_2.png"));
    private ImageIcon pause = new javax.swing.ImageIcon(getClass().getResource("/com/uclv/crash/gui/img/icons8_Pause_35px_1.png"));

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        w1 = new javax.swing.JLabel();
        w2 = new javax.swing.JLabel();
        w3 = new javax.swing.JLabel();
        w4 = new javax.swing.JLabel();
        w5 = new javax.swing.JLabel();
        w6 = new javax.swing.JLabel();
        w7 = new javax.swing.JLabel();
        w8 = new javax.swing.JLabel();
        w9 = new javax.swing.JLabel();
        w10 = new javax.swing.JLabel();
        w11 = new javax.swing.JLabel();
        w12 = new javax.swing.JLabel();
        w13 = new javax.swing.JLabel();
        w14 = new javax.swing.JLabel();
        w15 = new javax.swing.JLabel();
        w16 = new javax.swing.JLabel();
        w17 = new javax.swing.JLabel();
        w18 = new javax.swing.JLabel();
        w19 = new javax.swing.JLabel();
        w20 = new javax.swing.JLabel();
        w21 = new javax.swing.JLabel();
        w22 = new javax.swing.JLabel();
        w23 = new javax.swing.JLabel();
        w24 = new javax.swing.JLabel();
        w25 = new javax.swing.JLabel();
        cabezal = new javax.swing.JLabel();
        stepCountLb = new javax.swing.JLabel();
        stepSizeLb = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nextStepBttn = new javax.swing.JLabel();
        previousStepBttn = new javax.swing.JLabel();
        playpauseBttn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 42, 113));

        jPanel1.setBackground(new java.awt.Color(0, 30, 84));

        w1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w1.setForeground(new java.awt.Color(255, 255, 255));
        w1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w1.setText("Ɛ");

        w2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w2.setForeground(new java.awt.Color(255, 255, 255));
        w2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w2.setText("Ɛ");

        w3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w3.setForeground(new java.awt.Color(255, 255, 255));
        w3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w3.setText("Ɛ");

        w4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w4.setForeground(new java.awt.Color(255, 255, 255));
        w4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w4.setText("Ɛ");

        w5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w5.setForeground(new java.awt.Color(255, 255, 255));
        w5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w5.setText("Ɛ");

        w6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w6.setForeground(new java.awt.Color(255, 255, 255));
        w6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w6.setText("Ɛ");

        w7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w7.setForeground(new java.awt.Color(255, 255, 255));
        w7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w7.setText("Ɛ");

        w8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w8.setForeground(new java.awt.Color(255, 255, 255));
        w8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w8.setText("Ɛ");

        w9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w9.setForeground(new java.awt.Color(255, 255, 255));
        w9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w9.setText("Ɛ");

        w10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w10.setForeground(new java.awt.Color(255, 255, 255));
        w10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w10.setText("Ɛ");

        w11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w11.setForeground(new java.awt.Color(255, 255, 255));
        w11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w11.setText("Ɛ");

        w12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w12.setForeground(new java.awt.Color(255, 255, 255));
        w12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w12.setText("Ɛ");

        w13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w13.setForeground(new java.awt.Color(255, 204, 18));
        w13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w13.setText("Ɛ");

        w14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w14.setForeground(new java.awt.Color(255, 255, 255));
        w14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w14.setText("Ɛ");

        w15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w15.setForeground(new java.awt.Color(255, 255, 255));
        w15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w15.setText("Ɛ");

        w16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w16.setForeground(new java.awt.Color(255, 255, 255));
        w16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w16.setText("Ɛ");

        w17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w17.setForeground(new java.awt.Color(255, 255, 255));
        w17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w17.setText("Ɛ");

        w18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w18.setForeground(new java.awt.Color(255, 255, 255));
        w18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w18.setText("Ɛ");

        w19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w19.setForeground(new java.awt.Color(255, 255, 255));
        w19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w19.setText("Ɛ");

        w20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w20.setForeground(new java.awt.Color(255, 255, 255));
        w20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w20.setText("Ɛ");

        w21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w21.setForeground(new java.awt.Color(255, 255, 255));
        w21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w21.setText("Ɛ");

        w22.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w22.setForeground(new java.awt.Color(255, 255, 255));
        w22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w22.setText("Ɛ");

        w23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w23.setForeground(new java.awt.Color(255, 255, 255));
        w23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w23.setText("Ɛ");

        w24.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w24.setForeground(new java.awt.Color(255, 255, 255));
        w24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w24.setText("Ɛ");

        w25.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        w25.setForeground(new java.awt.Color(255, 255, 255));
        w25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w25.setText("Ɛ");

        cabezal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        cabezal.setForeground(new java.awt.Color(255, 255, 255));
        cabezal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabezal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uclv/crash/gui/img/icons8_Double_Up_25px.png"))); // NOI18N

        stepCountLb.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        stepCountLb.setForeground(new java.awt.Color(255, 255, 255));
        stepCountLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stepCountLb.setText("Paso: 0");
        stepCountLb.setToolTipText("");

        stepSizeLb.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        stepSizeLb.setForeground(new java.awt.Color(255, 255, 255));
        stepSizeLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stepSizeLb.setText("Total: 52");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(w1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(stepCountLb, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cabezal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(w14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(w25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stepSizeLb, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(w1)
                    .addComponent(w2)
                    .addComponent(w3)
                    .addComponent(w4)
                    .addComponent(w5)
                    .addComponent(w6)
                    .addComponent(w7)
                    .addComponent(w8)
                    .addComponent(w9)
                    .addComponent(w10)
                    .addComponent(w11)
                    .addComponent(w12)
                    .addComponent(w13)
                    .addComponent(w14)
                    .addComponent(w15)
                    .addComponent(w16)
                    .addComponent(w17)
                    .addComponent(w18)
                    .addComponent(w19)
                    .addComponent(w20)
                    .addComponent(w21)
                    .addComponent(w22)
                    .addComponent(w23)
                    .addComponent(w24)
                    .addComponent(w25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cabezal)
                    .addComponent(stepCountLb)
                    .addComponent(stepSizeLb))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 30, 84));

        nextStepBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uclv/crash/gui/img/icons8_End_35px.png"))); // NOI18N
        nextStepBttn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextStepBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextStepBttnMouseClicked(evt);
            }
        });

        previousStepBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uclv/crash/gui/img/icons8_Skip_to_Start_35px.png"))); // NOI18N
        previousStepBttn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previousStepBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousStepBttnMouseClicked(evt);
            }
        });

        playpauseBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uclv/crash/gui/img/icons8_Play_35px_2.png"))); // NOI18N
        playpauseBttn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playpauseBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playpauseBttnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previousStepBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playpauseBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextStepBttn)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextStepBttn)
                    .addComponent(previousStepBttn)
                    .addComponent(playpauseBttn))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextStepBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextStepBttnMouseClicked
        if (currentStep < stepList.size() - 1) {
            Step c = stepList.get(++currentStep);
            headAt((int) c.getData()[0]);
            //viewer.markVertex(((int) c.getData()[1]) + "");
            stepCountLb.setText("Paso: " + (currentStep + 1) + " / "+ stepList.size());
            stepSizeLb.setText((String) c.getData()[1]);
        }
    }//GEN-LAST:event_nextStepBttnMouseClicked

    private void previousStepBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousStepBttnMouseClicked
        if (currentStep - 1 >= 0) {
            Step c = stepList.get(--currentStep);
            headAt((int) c.getData()[0]);
            //viewer.markVertex(((int) c.getData()[1]) + "");
            stepCountLb.setText("Paso: " + (currentStep + 1) + " / "+ stepList.size());
            stepSizeLb.setText((String) c.getData()[1]);
        }
    }//GEN-LAST:event_previousStepBttnMouseClicked

    private void playpauseBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playpauseBttnMouseClicked
        if (!played && currentStep < stepList.size() - 1) {
            play();
        } else {
            pause();
        }
    }//GEN-LAST:event_playpauseBttnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cabezal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nextStepBttn;
    private javax.swing.JLabel playpauseBttn;
    private javax.swing.JLabel previousStepBttn;
    private javax.swing.JLabel stepCountLb;
    private javax.swing.JLabel stepSizeLb;
    private javax.swing.JLabel w1;
    private javax.swing.JLabel w10;
    private javax.swing.JLabel w11;
    private javax.swing.JLabel w12;
    private javax.swing.JLabel w13;
    private javax.swing.JLabel w14;
    private javax.swing.JLabel w15;
    private javax.swing.JLabel w16;
    private javax.swing.JLabel w17;
    private javax.swing.JLabel w18;
    private javax.swing.JLabel w19;
    private javax.swing.JLabel w2;
    private javax.swing.JLabel w20;
    private javax.swing.JLabel w21;
    private javax.swing.JLabel w22;
    private javax.swing.JLabel w23;
    private javax.swing.JLabel w24;
    private javax.swing.JLabel w25;
    private javax.swing.JLabel w3;
    private javax.swing.JLabel w4;
    private javax.swing.JLabel w5;
    private javax.swing.JLabel w6;
    private javax.swing.JLabel w7;
    private javax.swing.JLabel w8;
    private javax.swing.JLabel w9;
    // End of variables declaration//GEN-END:variables
}
