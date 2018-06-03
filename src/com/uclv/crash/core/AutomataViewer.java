/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclv.crash.core;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yasiel Cabrera
 */
public class AutomataViewer extends mxGraphComponent {

    private Map<String, mxCell> vertexes;

    public AutomataViewer() {
        super(new mxGraph());

        this.getViewport().setBackground(new Color(0x002A71));
        this.setBorder(null);
        
        vertexes = new HashMap<>();

        initGraph();

        new mxRubberband(this); // Permite que se puedan seleccionar multiples elementos
    }

    private void initGraph() {

        graph.setCellsResizable(false);
        graph.setCellsDisconnectable(false);
        graph.setCellsEditable(false);
        graph.setAllowDanglingEdges(false);
        graph.setCellsCloneable(false);
        graph.setCellsSelectable(true);
        graph.setCellsMovable(true);
        graph.setKeepEdgesInBackground(true);
        graph.setConnectableEdges(false);
        graph.setEdgeLabelsMovable(false);
        graph.setSplitEnabled(false);
        
                
//graph.setResetEdgesOnMove(true);
        
        /* Estilos */
        mxStylesheet stylesheet = graph.getStylesheet();
        
        Map<String, Object> mark = new HashMap<>();
        mark.put(mxConstants.STYLE_FONTCOLOR, "white");
        mark.put(mxConstants.STYLE_STROKECOLOR, "white");
        mark.put(mxConstants.STYLE_FILLCOLOR, "#002A71");
        stylesheet.putCellStyle("MARK", mark);

        Map<String, Object> styleState = new HashMap<>();
        styleState.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        styleState.put(mxConstants.STYLE_FONTCOLOR, "#001E54");
        styleState.put(mxConstants.STYLE_FONTSIZE, 14);
        styleState.put(mxConstants.STYLE_FONTFAMILY, "Segoe UI Semibold");
        styleState.put(mxConstants.STYLE_FILLCOLOR, "white");
        styleState.put(mxConstants.STYLE_STROKECOLOR, "#001E54");
        styleState.put(mxConstants.STYLE_STROKEWIDTH, 2);
        styleState.put(mxConstants.STYLE_SPACING_TOP, 2);
        styleState.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE); 
        stylesheet.putCellStyle("STATE", styleState);

        Map<String, Object> styleStartState = new HashMap<>();
        styleStartState.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_HEXAGON);
        styleStartState.put(mxConstants.STYLE_FONTCOLOR, "white");
        styleStartState.put(mxConstants.STYLE_FONTSIZE, 14);
        styleStartState.put(mxConstants.STYLE_FONTFAMILY, "Segoe UI Semibold");
        styleStartState.put(mxConstants.STYLE_FILLCOLOR, "#002A71");
        styleStartState.put(mxConstants.STYLE_STROKECOLOR, "white");
        styleStartState.put(mxConstants.STYLE_STROKEWIDTH, 2);
        styleStartState.put(mxConstants.STYLE_SPACING_TOP, 2);
        styleStartState.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE); 
        stylesheet.putCellStyle("START_STATE", styleStartState);

        Map<String, Object> styleFinalState = new HashMap<>();
        styleFinalState.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        styleFinalState.put(mxConstants.STYLE_FONTCOLOR, "white");
        styleFinalState.put(mxConstants.STYLE_FONTSIZE, 14);
        styleFinalState.put(mxConstants.STYLE_FONTFAMILY, "Segoe UI Semibold");
        styleFinalState.put(mxConstants.STYLE_FILLCOLOR, "#002A71");
        styleFinalState.put(mxConstants.STYLE_STROKECOLOR, "white");
        styleFinalState.put(mxConstants.STYLE_STROKEWIDTH, 5);
        styleFinalState.put(mxConstants.STYLE_SPACING_TOP, 3);
        styleFinalState.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE); 
        stylesheet.putCellStyle("FINAL_STATE", styleFinalState);
        
        Map<String, Object> styleStartFinalState = new HashMap<>();
        styleStartFinalState.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_HEXAGON);
        styleStartFinalState.put(mxConstants.STYLE_FONTCOLOR, "white");
        styleStartFinalState.put(mxConstants.STYLE_FONTSIZE, 14);
        styleStartFinalState.put(mxConstants.STYLE_FONTFAMILY, "Segoe UI Semibold");
        styleStartFinalState.put(mxConstants.STYLE_FILLCOLOR, "#002A71");
        styleStartFinalState.put(mxConstants.STYLE_STROKECOLOR, "white");
        styleStartFinalState.put(mxConstants.STYLE_STROKEWIDTH, 5);
        styleStartFinalState.put(mxConstants.STYLE_SPACING_TOP, 2);
        styleStartFinalState.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE); 
        stylesheet.putCellStyle("START_FINAL_STATE", styleStartFinalState);

        Map<String, Object> styleEdgeElbow = new HashMap<>();
        styleEdgeElbow.put(mxConstants.STYLE_ROUNDED, true);
        //styleEdgeElbow.put(mxConstants.STYLE_ORTHOGONAL, false);
        styleEdgeElbow.put(mxConstants.STYLE_EDGE, "elbowEdgeStyle");
        styleEdgeElbow.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
        styleEdgeElbow.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
        styleEdgeElbow.put(mxConstants.STYLE_ENDSIZE, 10);
        styleEdgeElbow.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
        styleEdgeElbow.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
        styleEdgeElbow.put(mxConstants.STYLE_STROKECOLOR, "white");
        styleEdgeElbow.put(mxConstants.STYLE_FONTCOLOR, "#FFCC12");
        styleEdgeElbow.put(mxConstants.STYLE_FONTSIZE, 18);
        styleEdgeElbow.put(mxConstants.STYLE_SPACING_TOP, 3);
        styleEdgeElbow.put(mxConstants.STYLE_BENDABLE, "1");
        stylesheet.putCellStyle("ELBOW", styleEdgeElbow);
        
        //events
        getGraphControl().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    mxCell cell = (mxCell) getCellAt(e.getX(), e.getY());
                    if(cell == null){
                        System.out.println("your click is in a white space");
                        executeCircleLayout();
                    }else if(cell.isEdge()){
                        System.out.println("you has clicked an edge");
                    }else{
                        System.out.println("you has clicked a vertex");
                    }
                }
            }
            
        });

    }

    public void insertVertex(String name) {
        if (!vertexes.containsKey(name)) {
            mxCell x = (mxCell) graph.insertVertex(null, null, name, 0, 0, 30, 30, "STATE");
            vertexes.put(name, x);
            x.setConnectable(false);
        }
    }

    public void insertStartVertex(String name) {
        if (!vertexes.containsKey(name)) {
            mxCell x = (mxCell) graph.insertVertex(null, null, name, 0, 0, 30, 30, "START_STATE");
            vertexes.put(name, x);
            x.setConnectable(false);
        }
    }
    
    public void insertStartFinalVertex(String name) {
        if (!vertexes.containsKey(name)) {
            mxCell x = (mxCell) graph.insertVertex(null, null, name, 0, 0, 30, 30, "START_FINAL_STATE");
            vertexes.put(name, x);
            x.setConnectable(false);
        }
    }

    public void insertFinalVertex(String name) {
        if (!vertexes.containsKey(name)) {
            mxCell x = (mxCell) graph.insertVertex(null, null, name, 0, 0, 30, 30, "FINAL_STATE");
            vertexes.put(name, x);
            x.setConnectable(false);
        }
    }

    public void insertEdge(String pond, String origin, String target) {
        String r = "";
        for(char c : pond.toCharArray()){
            r += c == SimplifiedTransition.EMPTY_INPUT? 'Ɛ' : c ;
        }
        mxCell x = (mxCell) graph.insertEdge(null, null, r, vertexes.get(origin), vertexes.get(target), "ELBOW");
    }
    
    public void markVertex(String name){
        graph.getModel().beginUpdate();
        vertexes.get(name).setStyle("FINAL_STATE");
        graph.getModel().endUpdate();
    }

    public void executeCircleLayout() {
        mxIGraphLayout layout = new mxCircleLayout(graph);
        layout.execute(graph.getDefaultParent());
    }

    public void executeCompactTreeLayout() {
        mxIGraphLayout layout = new mxCompactTreeLayout(graph);
        layout.execute(graph.getDefaultParent());
    }

}
