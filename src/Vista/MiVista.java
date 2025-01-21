/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorLanzarVentanas;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

/**
 * Clase MiVista que extiende un JFrame para crear una interfaz.
 * Proporciona métodos para que se pueda trabajar con los elementos
 * y realizar operaciones.
 * @author dam2
 */
public class MiVista extends javax.swing.JFrame {

    /**
     * Constructor de la clase MiVista.
     * Carga un icono para la ventana.
     */
    public MiVista() {
       initComponents();
       cargarIconoEmpresa();
       configurarComboBoxConImagenes();
    }

    private void cargarIconoEmpresa() {
        try {
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Recursos/IconoEmpresa.png"));
            if (imgIcon != null) {
                this.setIconImage(imgIcon.getImage());
            } else {
                System.err.println("No se pudo cargar el icono desde la ruta especificada.");
            }
        } catch(NullPointerException e) {
            System.err.println("Icono no encontrado: " + e.getMessage());
        }
    }

    private void configurarComboBoxConImagenes() {
        String[] productos = {"MANZANA", "PERA", "PLATANO", "MANGO", "PIÑA"};
        ImageIcon[] iconosProductos = {  

            cargarImagen("/Recursos/manzana.png"),
            cargarImagen("/Recursos/pera.png"),
            cargarImagen("/Recursos/platano.png"),
            cargarImagen("/Recursos/mango.png"),
            cargarImagen("/Recursos/piña.png")
        };

        jComboBoxNombreProducto.setRenderer((ListCellRenderer<? super String>) new JComboBoxImagenes(productos, iconosProductos));
    }

    private ImageIcon cargarImagen(String ruta) {
        try {
            return new ImageIcon(getClass().getResource(ruta));
        } catch (NullPointerException e) {
            System.err.println("Imagen no encontrada: " + ruta);
            return null;
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
        jLabelLote1 = new javax.swing.JLabel();
        jPanelProducto = new javax.swing.JPanel();
        jLabelNombreProducto = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jComboBoxNombreProducto = new javax.swing.JComboBox<>();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabelDescuento = new javax.swing.JLabel();
        jTextFieldDescuento = new javax.swing.JTextField();
        jScrollPaneCarro = new javax.swing.JScrollPane();
        jTextAreaProductos = new javax.swing.JTextArea();
        jButtonAñadir = new javax.swing.JButton();
        jLabelLote = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();

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

        jLabelLote1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelLote1.setForeground(new java.awt.Color(0, 0, 255));
        jLabelLote1.setText("REGISTRAR:");

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombreCliente)
                    .addComponent(jLabelNif)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelDireccion)
                    .addComponent(jLabelLote1))
                .addGap(26, 26, 26)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jTextFieldTelefono)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNif))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelLote1)
                .addGap(17, 17, 17)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombreCliente)
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
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
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jTabbedPaneMiVista.addTab("CLIENTE", jPanelCliente);

        jLabelNombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNombreProducto.setForeground(new java.awt.Color(0, 0, 255));
        jLabelNombreProducto.setText("NOMBRE :");

        jLabelCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCantidad.setText("CANTIDAD :");

        jLabelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(0, 0, 255));
        jLabelPrecio.setText("PRECIO :");

        jTextFieldCantidad.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldCantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jComboBoxNombreProducto.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jComboBoxNombreProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MANZANA", "PERA", "PLATANO", "MANGO", "PIÑA", "                                  ." }));
        jComboBoxNombreProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextFieldPrecio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldPrecio.setText("1.5");
        jTextFieldPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelDescuento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDescuento.setForeground(new java.awt.Color(0, 0, 255));
        jLabelDescuento.setText("DESCUENTO:");

        jTextFieldDescuento.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextFieldDescuento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        jLabelLote.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelLote.setForeground(new java.awt.Color(0, 0, 255));
        jLabelLote.setText("LOTE:");

        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButtonGuardar.setMnemonic('g');
        jButtonGuardar.setText("GUARDAR");
        jButtonGuardar.setToolTipText("Exportar la factura en formato PDF y XML.");
        jButtonGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButtonLimpiar.setMnemonic('g');
        jButtonLimpiar.setText("LIMPIAR");
        jButtonLimpiar.setToolTipText("Exportar la factura en formato PDF y XML.");
        jButtonLimpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanelProductoLayout = new javax.swing.GroupLayout(jPanelProducto);
        jPanelProducto.setLayout(jPanelProductoLayout);
        jPanelProductoLayout.setHorizontalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLote)
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelNombreProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabelDescuento))
                                .addGap(23, 23, 23)
                                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldDescuento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldPrecio)
                                    .addComponent(jComboBoxNombreProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCantidad)))
                            .addGroup(jPanelProductoLayout.createSequentialGroup()
                                .addComponent(jButtonAñadir)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonGuardar)))
                        .addGap(32, 32, 32)
                        .addComponent(jButtonLimpiar)))
                .addGap(95, 95, Short.MAX_VALUE))
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCarro)
                .addContainerGap())
        );
        jPanelProductoLayout.setVerticalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelLote)
                .addGap(18, 18, 18)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreProducto)
                    .addComponent(jComboBoxNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
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
                .addGap(18, 18, 18)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAñadir)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        jTabbedPaneMiVista.addTab("PRODUCTO", jPanelProducto);

        getContentPane().add(jTabbedPaneMiVista, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadir;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxNombreProducto;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelDescuento;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelLote;
    private javax.swing.JLabel jLabelLote1;
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
    private javax.swing.JTextField jTextFieldNif;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

    /**
     * Asociamos un ActionListener para el botón GuardarCliente
     * @param l escuchador que gestiona los eventos del botón GuardarCliente
     */
    public void jButtonGuardarCliente(ActionListener l) {
       
    }
    
    /**
     * Asociamos un ActionListener para el botón Guardar.
     * @param l escuchador que gestiona los eventos del botón Guardar.
     */
    public void jButtonGuardar(ActionListener l) {
        jButtonGuardar.addActionListener(l); 
    }
    /**
     * Asociamos un ActionListener para el botón Añadir.
     * @param l escuchador que gestiona los eventos del botón Añadir.
     */
    public void jButtonAñadir(ActionListener l) {
        jButtonAñadir.addActionListener(l); 
    }
    
    public void jButtonLimpiar(ActionListener l) {
        jButtonLimpiar.addActionListener(l); 
    }
    
    /**
     * 
     * @param texto pasamos por parámetro el texto que se mostrará en el TextArea
     */
    public void jTextAreaProductos(String texto){
        jTextAreaProductos.setText(texto);
    }
    public void jTextFieldCantidad(String texto) {   
        jTextFieldCantidad.setText(texto);
    }
    /**
     * 
     * @return Devuelve un ComboBox que contiene el nombre de todos los productos.
     */
    public JComboBox<String> getjComboBoxNombreProducto() {
        return jComboBoxNombreProducto;
    }
    
    /**
     * 
     * @return Devuelve el nombre del producto seleccionado como un String.
     */
    public String getProductoSeleccionado() {
        return (String) jComboBoxNombreProducto.getSelectedItem();
    }
    
    /**
     * Pone el precio del producto en el recuadro de texto.
     * Convierte un valor String a Double.
     * @param precio pasamos por parámetro el precio como un String.
     */
    public void setPrecioProducto(String precio) {
        double precioDouble = Double.parseDouble(precio); //Convierte el String a double
        jTextFieldPrecio.setText(String.valueOf(precioDouble)); //Convierte el double de nuevo a String para el JTextField
    }
    
    /**
     * 
     * @return Devuelve el precio del producto como Double
     */
    public double getPrecioProducto() {
        return Double.parseDouble(jTextFieldPrecio.getText()); //Convierte el texto a double
    }

    /**
     * 
     * @return Devuelve la dirección
     */
    public String getjTextFieldDireccion() {
        return jTextFieldDireccion.getText();
    }

    /**
     * 
     * @return devuelve el NIF del cliente
     */
    public String getjTextFieldNif() {
        return jTextFieldNif.getText();
    }

    /**
     * 
     * @return Devuelve el nombre del cliente
     */
    public String getjTextFieldNombreCliente() {
        return jTextFieldNombreCliente.getText();
    }

    /**
     * 
     * @return Devuelve el telefono
     */
    public int getjTextFieldTelefono() {
        try{
        return Integer.parseInt(jTextFieldTelefono.getText());
                }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Campo de telefono invalido!");
            System.out.println("Que letras hay en un telefono crack");
        return 0;
        
        }
    }
    
    public String getjTextFieldPrecio(){
        return jTextFieldPrecio.getText();
    }
    
        public String getjTextFieldDescuento() {
        return jTextFieldDescuento.getText();
        }
        public String getjTextFieldCantidad() {
        return jTextFieldCantidad.getText();
        }
        public String getjTextAreaProductos() {
        return jTextAreaProductos.getText();
    }
    /**
     * Devuelve la cantidad de productos ingresada y si ocurre un error devuelve un 0.
     * 
     * @return Devuelve la cantidad de productos como un entero(int).
     */
    public int getCantidad() {
        try {
            return Integer.parseInt(jTextFieldCantidad.getText()); //Convierte el texto a int
        } catch(NumberFormatException e) {            return 0; //Devuelve un valor por defecto en caso de error
        }
    }
    
    /**
     * Pone la cantidad en el recuadro de texto.
     * @param cantidad pasamos por parámetro la cantidad como un entero.
     */
    public void setCantidad(int cantidad) {
        jTextFieldCantidad.setText(String.valueOf(cantidad)); //Convierte el int a String para el JTextField
    }

    /**
     * Convierte el texto a Double y si ocurre un error devuele(0.0) .
     * @return Devuelve el descuento como un Double.
     */
    public double getDescuento() {
     try {
         return Double.parseDouble(jTextFieldDescuento.getText()); // Convierte el texto a Double
     } catch (NumberFormatException e) {
        return 0.0; // Devuelve un valor por defecto en caso de error
     }
   }

    /**
     * Pone el descuento en el recuadro de texto.
     * @param descuento pasamos por parámetro el descuento de tipo Double.
     */
    public void setDescuento(double descuento) {
        jTextFieldDescuento.setText(String.valueOf(descuento)); // Convierte el Double a String para el JTextField
    }

    
}