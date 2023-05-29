/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.dadosclimaticos.View;

import javax.swing.JTextField;



/**
 *
 * @author chris
 */
public class MediaClimaView extends javax.swing.JInternalFrame {
    /**
     * Creates new form EstatisticaClimaView
     */
    public MediaClimaView(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconable) {
        super(title,resizable, closable, maximizable, iconable);
        initComponents();
    }

    
    
    
    public JTextField getFieldTemp() {
        return fieldTemp;
    }

    public JTextField getFieldPressao() {
        return fieldPressao;
    }

    public JTextField getFieldUmidade() {
        return fieldUmidade;
    }

    public JTextField getFieldQtdRegistro() {
        return fieldQtdRegistro;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldTemp = new javax.swing.JTextField();
        fieldPressao = new javax.swing.JTextField();
        fieldUmidade = new javax.swing.JTextField();
        fieldQtdRegistro = new javax.swing.JTextField();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Temperatura:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pressão:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Número de registros:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Umidade:");

        fieldTemp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldTemp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldTemp.setText("jTextField1");
        fieldTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTempActionPerformed(evt);
            }
        });

        fieldPressao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldPressao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldPressao.setText("jTextField1");

        fieldUmidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldUmidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldUmidade.setText("jTextField1");

        fieldQtdRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldQtdRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldQtdRegistro.setText("jTextField1");
        fieldQtdRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldQtdRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTemp)
                    .addComponent(fieldPressao)
                    .addComponent(fieldUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldQtdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(fieldPressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(fieldUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldQtdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTempActionPerformed

    private void fieldQtdRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldQtdRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldQtdRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldPressao;
    private javax.swing.JTextField fieldQtdRegistro;
    private javax.swing.JTextField fieldTemp;
    private javax.swing.JTextField fieldUmidade;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}