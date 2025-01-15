/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author dam2
 */
public class MiVista extends javax.swing.JFrame {

    /**
     * Constructor de la MiVista
     */
    public MiVista() {
        initComponents();
        
        // Cargar el icono de empresa
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Recursos/IconoEmpresa.png"));
        
        if (imgIcon != null) {
            this.setIconImage(imgIcon.getImage());
        }
        else {
            System.err.println("No se pudo cargar el icono desde la ruta especificada.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMiVista = new javax.swing.JTabbedPane();
        jPanelCliente = new javax.swing.JPanel();
        jLabelNombreCliente = new javax.swing.JLabel();
        jLabelNif = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jTextFieldNif = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jPanelProducto = new javax.swing.JPanel();
        jLabelNombreProducto = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jComboBoxNombreProducto = new javax.swing.JComboBox<>();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabelDescuento = new javax.swing.JLabel();
        jTextFieldDescuento = new javax.swing.JTextField();
        jLabelFecha = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jScrollPaneCarro = new javax.swing.JScrollPane();
        jTextAreaProductos = new javax.swing.JTextArea();
        jButtonAñadir = new javax.swing.JButton();
        jLabelLote = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FACTURA");
        setLocation(new java.awt.Point(660, 300));

        jTabbedPaneMiVista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 0, 0), new java.awt.Color(51, 255, 0), new java.awt.Color(0, 51, 153)));
        jTabbedPaneMiVista.setForeground(new java.awt.Color(0, 51, 153));
        jTabbedPaneMiVista.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        jLabelNombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNombreCliente.setForeground(new java.awt.Color(0, 0, 255));
        jLabelNombreCliente.setText("NOMBRE :");

        jLabelNif.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNif.setForeground(new java.awt.Color(0, 0, 255));
        jLabelNif.setText("NIF :");

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(0, 0, 255));
        jLabelTelefono.setText("TELEFONO :");

        jLabelDireccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(0, 0, 255));
        jLabelDireccion.setText("DIRECCION :");

        jTextFieldNombreCliente.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldNombreCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextFieldNif.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldNif.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextFieldTelefono.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextFieldDireccion.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldDireccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombreCliente)
                    .addComponent(jLabelNif)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelDireccion))
                .addGap(53, 53, 53)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(jTextFieldTelefono)
                    .addComponent(jTextFieldNif)
                    .addComponent(jTextFieldNombreCliente))
                .addGap(119, 119, 119))
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombreCliente)
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNif)
                    .addComponent(jTextFieldNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jTabbedPaneMiVista.addTab("CLIENTE", jPanelCliente);

        jLabelNombreProducto.setForeground(new java.awt.Color(0, 0, 255));
        jLabelNombreProducto.setText("NOMBRE :");

        jLabelCantidad.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCantidad.setText("CANTIDAD :");

        jLabelPrecio.setForeground(new java.awt.Color(0, 0, 255));
        jLabelPrecio.setText("PRECIO :");

        jTextFieldCantidad.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldCantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jComboBoxNombreProducto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jComboBoxNombreProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ELIGE TU PRODUCTO", "MANZANA", "PERA", "PLATANO", "MANGO", "PIÑA" }));
        jComboBoxNombreProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextFieldPrecio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelDescuento.setForeground(new java.awt.Color(0, 0, 255));
        jLabelDescuento.setText("DESCUENTO");

        jTextFieldDescuento.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldDescuento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelFecha.setForeground(new java.awt.Color(0, 0, 255));
        jLabelFecha.setText("FECHA :");

        jTextFieldFecha.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldFecha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextAreaProductos.setColumns(20);
        jTextAreaProductos.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextAreaProductos.setRows(5);
        jTextAreaProductos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPaneCarro.setViewportView(jTextAreaProductos);

        jButtonAñadir.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButtonAñadir.setForeground(new java.awt.Color(255, 0, 0));
        jButtonAñadir.setMnemonic('a');
        jButtonAñadir.setText("AÑADIR AL CARRO");
        jButtonAñadir.setToolTipText("Añadir los productos al carro de la compra.");
        jButtonAñadir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelLote.setForeground(new java.awt.Color(0, 0, 255));
        jLabelLote.setText("LOTE:");

        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButtonGuardar.setMnemonic('g');
        jButtonGuardar.setText("GUARDAR");
        jButtonGuardar.setToolTipText("Exportar la factura en formato PDF y XML.");
        jButtonGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanelProductoLayout = new javax.swing.GroupLayout(jPanelProducto);
        jPanelProducto.setLayout(jPanelProductoLayout);
        jPanelProductoLayout.setHorizontalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLote)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelNombreProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabelDescuento)
                                    .addComponent(jLabelFecha))
                                .addGap(25, 25, 25)
                                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFecha)
                                    .addComponent(jTextFieldDescuento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldPrecio)
                                    .addComponent(jTextFieldCantidad)
                                    .addComponent(jComboBoxNombreProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButtonAñadir)
                                .addGap(48, 48, 48)
                                .addComponent(jButtonGuardar))))
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPaneCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanelProductoLayout.setVerticalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelLote)
                .addGap(18, 18, 18)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreProducto)
                    .addComponent(jComboBoxNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantidad)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescuento)
                    .addComponent(jTextFieldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAñadir)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPaneMiVista.addTab("PRODUCTO", jPanelProducto);

        getContentPane().add(jTabbedPaneMiVista, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadir;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBoxNombreProducto;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelDescuento;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelLote;
    private javax.swing.JLabel jLabelNif;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JLabel jLabelNombreProducto;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelProducto;
    private javax.swing.JScrollPane jScrollPaneCarro;
    private javax.swing.JTabbedPane jTabbedPaneMiVista;
    private javax.swing.JTextArea jTextAreaProductos;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldDescuento;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNif;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

    public void jButtonGuardar(ActionListener l) {
        jButtonGuardar.addActionListener(l); 
    }
    
    public void jButtonAñadir(ActionListener l) {
        jButtonAñadir.addActionListener(l); 
    }

    public void jTextAreaProductos(String texto){
        jTextAreaProductos.setText(texto);
    }
    
    public JComboBox<String> getjComboBoxNombreProducto() {
        return jComboBoxNombreProducto;
    }
    
    public String getProductoSeleccionado() {
        return (String) jComboBoxNombreProducto.getSelectedItem();
    }
    
    public void setPrecioProducto(String precio) {
        double precioDouble = Double.parseDouble(precio); //Convierte el String a double
        jTextFieldPrecio.setText(String.valueOf(precioDouble)); //Convierte el double de nuevo a String para el JTextField
    }
    
    public double getPrecioProducto() {
        return Double.parseDouble(jTextFieldPrecio.getText()); //Convierte el texto a double
    }

    /**
     * 
     * @return Devuelve la dirección
     */
    public JTextField getjTextFieldDireccion() {
        return jTextFieldDireccion;
    }

    /**
     * 
     * @return devuelve el NIF del cliente
     */
    public JTextField getjTextFieldNif() {
        return jTextFieldNif;
    }

    /**
     * 
     * @return Devuelve el nombre del cliente
     */
    public JTextField getjTextFieldNombreCliente() {
        return jTextFieldNombreCliente;
    }

    /**
     * 
     * @return Devuelve el telefono
     */
    public JTextField getjTextFieldTelefono() {
        return jTextFieldTelefono;
    }

    public int getCantidad() {
        try {
            return Integer.parseInt(jTextFieldCantidad.getText()); //Convierte el texto a int
        } catch(NumberFormatException e) {
            return 0; //Devuelve un valor por defecto en caso de error
        }
    }
    
    public void setCantidad(int cantidad) {
        jTextFieldCantidad.setText(String.valueOf(cantidad)); //Convierte el int a String para el JTextField
    }

    public int getDescuento() {
        try {
            return Integer.parseInt(jTextFieldDescuento.getText()); //Convierte el texto a int
        } catch(NumberFormatException e) {
            return 0; //Devuelve un valor por defecto en caso de error
        }
    }

    public void setDescuento(int descuento) {
        jTextFieldDescuento.setText(String.valueOf(descuento)); //Convierte el int a String para el JTextField
    } 
}