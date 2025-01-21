/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author oscar
 */
public class VentanaBorrar extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public VentanaBorrar() {
        initComponents();
        
        setSize(550, 480);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxBorrar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonBorrarElemento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Borrar porducto");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Que articulos desea borrar:");

        jButtonBorrarElemento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBorrarElemento.setText("BORRAR ELEMENTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonBorrarElemento)
                            .addComponent(jComboBoxBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBorrarElemento)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrarElemento;
    private javax.swing.JComboBox<String> jComboBoxBorrar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
public void jButtonBorrarElemento(ActionListener l) {
        jButtonBorrarElemento.addActionListener(l); 
    }
    public JComboBox<String> getjComboBoxBorrar() {
        return jComboBoxBorrar;
    }
    
    public String getBorrar() {
        return (String) jComboBoxBorrar.getSelectedItem();
    }
}