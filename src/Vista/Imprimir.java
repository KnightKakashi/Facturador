/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

//import com.sun.javafx.iio.ImageStorage;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
        setTitle("Imprimir factura..");
    }
    
    public void cargarbotonimprimir() {
        jBtnImprimir.setVisible(false);
        try {
            BufferedImage bi = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
            panel.paint(bi.getGraphics());
            String ruta = "src\\Recursos\\factura_impresa.png";
            ImageIO.write(bi, "png", new File(ruta));
            Desktop.getDesktop().print(new File(ruta));
        } catch (IOException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
        jBtnImprimir.setVisible(true);
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
        jTextAreaProductos = new javax.swing.JTextArea();
        jLabelNumeroFactura = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabel1NIF = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(200, 20));
        setPreferredSize(new java.awt.Dimension(1090, 944));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1056, 816));

        panel.setBackground(new java.awt.Color(245, 245, 239));
        panel.setMinimumSize(new java.awt.Dimension(1000, 1444));
        panel.setPreferredSize(new java.awt.Dimension(1070, 1435));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnImprimir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBtnImprimir.setText("IMPRIMIR");
        panel.add(jBtnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jTextAreaProductos.setColumns(20);
        jTextAreaProductos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextAreaProductos.setRows(5);
        jTextAreaProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(jTextAreaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, 820, 280));

        jLabelNumeroFactura.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabelNumeroFactura.setText("jLabel2");
        panel.add(jLabelNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 150, 30));

        jLabelFecha.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabelFecha.setText("jLabel3");
        panel.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 250, 30));

        jPanel1.setBackground(new java.awt.Color(245, 245, 239));
        jPanel1.setLayout(new java.awt.GridLayout(5, 0));

        jLabelNombre.setBackground(new java.awt.Color(245, 245, 239));
        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabelNombre.setText("jLabel2");
        jPanel1.add(jLabelNombre);

        jLabelDireccion.setBackground(new java.awt.Color(245, 245, 239));
        jLabelDireccion.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabelDireccion.setText("jLabel2");
        jPanel1.add(jLabelDireccion);

        jLabel1NIF.setBackground(new java.awt.Color(245, 245, 239));
        jLabel1NIF.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel1NIF.setText("jLabel2");
        jPanel1.add(jLabel1NIF);

        jLabelTelefono.setBackground(new java.awt.Color(245, 245, 239));
        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabelTelefono.setText("jLabel2");
        jPanel1.add(jLabelTelefono);

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 240, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/factura.png"))); // NOI18N
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1030, -1));

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
  public void setjLabelFecha(String fecha){
      jLabelFecha.setText(fecha);
  }
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
        
        public void jTextAreaProductos(String texto){
            jTextAreaProductos.setText(texto);
        }
        


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
    private javax.swing.JTextArea jTextAreaProductos;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
 /**
     * Asociamos un ActionListener para el botón Imprimir.
     * @param l escuchador que gestiona los eventos del botón Guardar.
     */
    public void jBtnImprimirpdf(ActionListener l) {
        jBtnImprimir.addActionListener(l);
       
    }

}
