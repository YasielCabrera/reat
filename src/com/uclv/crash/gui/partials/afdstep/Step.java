/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.gui.partials.afdstep;

/**
 *
 * @author Yasiel Cabrera
 */
public class Step {
    /**
     * Numero del paso del algoritmo
     */
    private int stepNumber;
    /**
     * cantidad de elementos que hay guardado en este paso
     */
    private int dataLength;
    /**
     * Datos de este paso
     */
    private Object data [];
    
    public Step(int n, int length){
        stepNumber = n;
        dataLength = length;
        data = new Object[length];
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
    
    
}
