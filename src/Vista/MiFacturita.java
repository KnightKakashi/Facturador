/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

/**
 *
 * @author dam2
 */
public class MiFacturita extends javax.swing.JFrame {

    /**
     * Creates new form MiFacturita
     */
    public MiFacturita() {
        initComponents();
        setTitle("Imagen redimensionable en JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 1200); // Tamaño inicial
        setLocationRelativeTo(null); // Centrar en pantalla

        // Crear el JPanel personalizado
        ImagePanel panel = new ImagePanel("/Recursos/factura.png");
        panel.setBounds(0, 0, getWidth(), getHeight()); // Asegurar que ocupa todo el JFrame
        getContentPane().add(panel); // Agregar el panel al JFrame
    }
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
           public void setJlabelTelefono(String telefono){
        JlabelTelefono.setText(telefono);   
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
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1NIF = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        JlabelTelefono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 1750));
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        jLabel1NIF.setText("NO HAY DATOS");

        jLabelNombre.setText("NO HAY DATOS");

        jLabelDireccion.setText("NO HAY DATOS");

        JlabelTelefono.setText("NO HAY DATOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlabelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1NIF, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1NIF, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlabelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(510, 160, 107, 105);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(245, 245, 239));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 370, 590, 180);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlabelTelefono;
    private javax.swing.JLabel jLabel1NIF;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    class ImagePanel extends JPanel {
        private Image image;

        public ImagePanel(String imagePath) {
            // Cargar la imagen desde los recursos
            this.image = new ImageIcon(getClass().getResource(imagePath)).getImage();
        }



        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                // Dibujar la imagen redimensionada
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}