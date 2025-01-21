package Controlador;

import Modelo.Cliente;
import Modelo.PlaceholderModelo;
import Modelo.Producto;
import Vista.Imprimir;
import Vista.MiVista;
import Vista.VentanaBorrar;
import Vista.VentanaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author GART
 */
public class ControladorLanzarVentanas implements ActionListener {
  //PRUEBA  
    private VentanaInicio ventanaInicio;
    private MiVista miVista;
    private Imprimir impresionsita;
    private VentanaBorrar borrar;
    private PlaceholderModelo miModelo;
    
    /**
     * Constructor para inicializar el controlador
     * 
     *@param ventanaInicio
     *@param miVista 
     *@param impresionsita  
     *@param miModelo  
     */
    public ControladorLanzarVentanas(VentanaInicio ventanaInicio, MiVista miVista, Imprimir impresionsita, VentanaBorrar borrar, PlaceholderModelo miModelo){
        this.ventanaInicio = ventanaInicio;
        this.miVista = miVista;
        this.impresionsita = impresionsita;
        this.borrar = borrar;
        this.miModelo = miModelo;
        
        System.out.println("Iniciando constructor ControladorLanzarVentanas...");
        
        escuchadores(this);
    }

    public void escuchadores(ActionListener listener){
        miVista.jButtonGuardar(this);
        miVista.jButtonAñadir(this);
        miVista.jButtonLimpiar(this);
        impresionsita.jBtnImprimirpdf(this);
        miVista.getjComboBoxNombreProducto().addActionListener(e -> {
            String producto = miVista.getProductoSeleccionado();
            String precio = obtenerPrecio(producto);
            miVista.setPrecioProducto(precio);
        });
    }
   
    /**
    * Metodo que lanza el programa
    */
     public void lanzarPrograma(){
        lanzarVentanaCarga();
    }

    /**
    * Metodo que lanza la ventana de carga,
    * Este metodo se encarga de lanzar la ventana y despues de unos segundos
    * se cierra para que se abra la ventana principal de la aplicacion
    */
    public void lanzarVentanaCarga(){
        System.out.println("Iniciando...");
        ImageIcon gifIcon = new ImageIcon("src/recursos/inicio_facturacion.gif");
        ventanaInicio.getJLabelIcono(gifIcon);
        ventanaInicio.setTitle("Cargando...");
        ventanaInicio.setSize(550, 480);
        ventanaInicio.setResizable(false);
        ventanaInicio.setVisible(true);
        
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ventanaInicio.dispose(); // Cierra la ventana
                System.out.println("La ventana de carga ha desaparecido...");
                miVista.setVisible(true);
                 System.out.println("Lanzando ventana principal...");
            }
        }, 900); //Volver a subir el tiempo de carga
    }
    
    /**
    * Metodo que lanza la ventana de impresion
    */
    public void lanzarVentanaFactura(){
        System.out.println("Iniciando Ventana de Facturacion");
       
        impresionsita.setVisible(true); 
           
    }
    
    /**
     * Metodo que lanza la ventana de borrar
     */
    public void lanzarVentanaBorrar(){
        System.out.println("Iniciando VentanaBorrar");
       
        borrar.setVisible(true);
    }
    
    /**
    * Metodo que recibe un producto y coloca un precio predeterminado a cada uno.
    */
    public String obtenerPrecio(String producto){
        switch(producto){
            case "MANZANA":
                return "1.50";
            case "PERA":
                return "1.30";
            case "PLATANO":
                return "1.00";
            case "MANGO":
                return "2.00";
            case "PIÑA":
                return "3.50";
            default:
                return "";
        }
    }
    
    /**
     *Metodo que se encarga de coger los datos de la ventana miVista,añadirlo a nuevo producto p
     * y a un cliente c,para meterlos en el constructor CestaCompra cestita usar el metodo generarXML al pulsar
     * el boton "GUARDAR"
     */ 
    public void rellenarCarro() {
        miVista.jTextAreaProductos(" ");
         
        String nombreProducto = miVista.getProductoSeleccionado();
        int cantidad = miVista.getCantidad();
        double precio = miVista.getPrecioProducto();
        double descuento = miVista.getDescuento();
        String fecha = miModelo.prod.getFecha();
        
        String nombre = miVista.getjTextFieldNombreCliente();
        String nif = miVista.getjTextFieldNif();
        int telefono = miVista.getjTextFieldTelefono();
        String direccion = miVista.getjTextFieldDireccion();
         
        Producto p = new Producto(nombreProducto, cantidad, precio, descuento, fecha);
        Cliente c = new Cliente(nombre, nif, telefono, direccion);
        
        miModelo.cestita.agregarProducto(p);
        miModelo.cestita.setCliente(c);
        
        miModelo.genxml.generarFacturaXML(miModelo.cestita, "facturasXML.xml");
        miVista.jTextAreaProductos(miModelo.cestita.imprimirLista());         
    }
    
    /**
     *Metodo que se encarga de coger los datos de la ventana miVista, parsearlos
     * y añadirlos a la previsualizacion de la factura, esta funcion se usa al pulsar 
     * el boton "GUARDAR CLIENTE"
     */ 
    public void rellenarClientePDF(){
        String nombre = miVista.getjTextFieldNombreCliente();
        String nif = miVista.getjTextFieldNif();
        int telefono = miVista.getjTextFieldTelefono();
        String direccion = miVista.getjTextFieldDireccion();
        
        impresionsita.setjLabelNombre(nombre);
        impresionsita.setjLabelDireccion(direccion);
        impresionsita.setjLabel1NIF(nif);
        impresionsita.setJLabelTelefono(telefono + "");
        impresionsita.setjLabelFecha(miModelo.cestita.getFecha());
    }
    
    /**
     * Metodo que se encarga de comprobar que todos los campos de mivista han sido rellenados adecuadamente
     * devuelve un error como JoptionPane en el que avisa que los campos son invalidos
    */
    public boolean comprobarCampos(){
        boolean vacio = false;
        if(miVista.getjTextFieldDireccion().isEmpty() ||
           miVista.getjTextFieldNif().isEmpty() ||
           miVista.getjTextFieldNombreCliente().isEmpty()||
           miVista.getjTextFieldDescuento().isEmpty() ||
           miVista.getjTextFieldCantidad().isEmpty()){
            vacio = true;
            System.out.println("Faltan campos por rellenar");
            JOptionPane.showMessageDialog(ventanaInicio, "CAMPOS INVALIDOS!");
            return vacio;
        }else if (miVista.getjTextFieldTelefono()==0){
            vacio = true;               
    }
        return vacio;    
    }
    
    /**
     * Metodo que se encarga de recorrer los productos que recibe como parmetro
     * para colocarlos despues en el textarea del pdf.
     */
    public void rellenarProductosPDF(){
        StringBuilder sb = new StringBuilder();
    
        // Crear el array con los productos
        String[][] productos = {
            {
                miVista.getProductoSeleccionado(),
                miVista.getjTextFieldCantidad(),
                miVista.getjTextFieldPrecio(),
                miVista.getjTextFieldDescuento(),
                "21%",
                Double.toString(miModelo.cestita.calcularTotal())
            }
        };

        // Construir el texto formateado para el JTextArea
        for (String[] producto : productos) {
            sb.append(String.format("%-20s %-10s %-10s %-10s %-10s %-10s%n",
                producto[0], producto[1], producto[2], producto[3], producto[4], producto[5]));
        }

        // Llenar el JTextArea con la lista formateada
        impresionsita.jTextAreaProductos(miModelo.cestita.imprimirListaPDF());
    }
    
    /**
     *Metodo que se encarga de lanzar la venta de impresion para imprimir directamente desde la impresora
     * a traves del boton "imprimir"
     */ 
     private void imprimirPDF() { 
         System.out.println("esta bien vas imprimir");
         impresionsita.cargarbotonimprimir();
    }  
     
    /**
     *Metodo que se encarga de limpiar el text area de productos
     */
    private void borrarAreaProductos() {
        miVista.jTextAreaProductos("");
        miVista.setCantidad(0);
        miVista.setNombreCliente("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "AÑADIR AL CARRO":
                System.out.println("Añadiendo al carro...");
                rellenarCarro();
                break;
            case "GUARDAR":
                if(comprobarCampos()){
                    System.out.println("Guardando...");
                }
                else{
                    rellenarProductosPDF();
                    rellenarClientePDF(); 
                    System.out.println("Sacando factura...");
                    lanzarVentanaFactura() ;
                }
                break;
            case "IMPRIMIR":
                System.out.println("Vas a Imprimir tu factura");
                imprimirPDF() ;
                break;
            case "BORRAR":
                System.out.println("Borrando el area de productos...");
                borrarAreaProductos();
                break;
            default:
                System.out.print("Error" + e.getActionCommand());
                break;
        }
    }
}