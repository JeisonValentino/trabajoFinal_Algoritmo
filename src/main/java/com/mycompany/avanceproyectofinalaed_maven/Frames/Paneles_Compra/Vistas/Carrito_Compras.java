/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.avanceproyectofinalaed_maven.Frames.Paneles_Compra.Vistas;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Jvalentino
 */
public class Carrito_Compras extends javax.swing.JPanel {

    /**
     * Creates new form Carrito_Compras
     */
    public Carrito_Compras() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_compras = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 0));
        setPreferredSize(new java.awt.Dimension(250, 300));
        setLayout(new java.awt.BorderLayout());

        table_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Precio", ""
            }
        ));
        jScrollPane1.setViewportView(table_compras);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(247, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL : ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("0");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_compras;
    // End of variables declaration//GEN-END:variables

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTable getTable_compras() {
        return table_compras;
    }



}
