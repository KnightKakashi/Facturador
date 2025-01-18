/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

//import com.sun.javafx.iio.ImageStorage;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author GART
 */
public class Imprimir extends javax.swing.JFrame {

    /**
     * Creates new form Imprimir
     */
    public Imprimir() {
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
        panel = new javax.swing.JPanel();
        jBtnImprimir = new javax.swing.JButton();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelNumeroFactura = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabel1NIF = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1056, 816));

        panel.setPreferredSize(new java.awt.Dimension(1350, 1900));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnImprimir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBtnImprimir.setText("IMPRIMIR");
        jBtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImprimirActionPerformed(evt);
            }
        });
        panel.add(jBtnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("dfbdbdbd");
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 800, 1130, 320));

        jLabelNumeroFactura.setText("jLabel2");
        panel.add(jLabelNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 150, 30));

        jLabelFecha.setText("jLabel3");
        panel.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 250, 30));

        jPanel1.setLayout(new java.awt.GridLayout(5, 0));

        jLabelNombre.setText("jLabel2");
        jPanel1.add(jLabelNombre);

        jLabelDireccion.setText("jLabel2");
        jPanel1.add(jLabelDireccion);

        jLabel1NIF.setText("jLabel2");
        jPanel1.add(jLabel1NIF);

        jLabelTelefono.setText("jLabel2");
        jPanel1.add(jLabelTelefono);

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 410, 240, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/factura.png"))); // NOI18N
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 810, -1, -1));

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1744, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    public void setJLabelTelefono(String telefono){
            jLabelTelefono.setText(telefono);   
       }

        public void setjLabel1NIF(String nif){
            jLabel1NIF.setText(nif);   
        }

        public void setjLabelNombre(String nombre){
            jLabelNombre.setText(nombre);   
        }

        public void setjLabelDireccion(String direccion){
            jLabelDireccion.setText(direccion);   
        }   
    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImprimirActionPerformed
        jBtnImprimir.setVisible(false);
        panel.setBackground(Color.WHITE);
        try {
            BufferedImage bi = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
            panel.paint(bi.getGraphics());
            String ruta = "src\\Recursos\\factura_impresa.png";
            ImageIO.write(bi, "png", new File(ruta));
            Desktop.getDesktop().print(new File(ruta));
        } catch (IOException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnImprimirActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1NIF;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumeroFactura;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
