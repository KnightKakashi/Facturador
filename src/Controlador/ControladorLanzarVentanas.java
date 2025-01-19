package Controlador;

import Modelo.PlaceholderModelo;
import Modelo.Producto;
import Vista.Imprimir;
import Vista.MiFacturita;
import Vista.MiVista;
import Vista.VentanaInicio;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    private PlaceholderModelo miModelo;
    private Object panel;
    
    /**
     * Constructor para inicializar el controlador
     * 
     *@param ventanaInicio
     *@param miVista 
     *@param impresionsita  
     *@param miModelo  
     */
    
    public ControladorLanzarVentanas(VentanaInicio ventanaInicio, MiVista miVista, Imprimir impresionsita, PlaceholderModelo miModelo){
        this.ventanaInicio = ventanaInicio;
        this.miVista = miVista;
        this.miModelo = miModelo;
        this.impresionsita= impresionsita;
        
        System.out.println("Iniciando constructor ControladorLanzarVentanas...");
        
        escuchadores(this);
    }

    public void escuchadores(ActionListener listener){
        miVista.jButtonGuardar(this);
        miVista.jButtonAñadir(this);
        miVista.jButtonGuardarCliente(this);
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
    
    public void lanzarVentanaFactura(){
        System.out.println("Iniciando Ventana de Facturacion");
       
        impresionsita.setVisible(true);        
    }
    
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
  
    public void rellenarCarro() {
        miVista.jTextAreaProductos(" ");
         
        String nombreProducto = miVista.getProductoSeleccionado();
        int cantidad = miVista.getCantidad();
        double precio = miVista.getPrecioProducto();
        double descuento = miVista.getDescuento();
        String fecha = miModelo.prod.getFecha();
         
        Producto p = new Producto(nombreProducto, cantidad, precio, descuento, fecha);
        miModelo.cestita.agregarProducto(p);

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
        
        //Cliente c = new Cliente(nombre, nif, telefono, direccion);
        impresionsita.setjLabelNombre(nombre);
        impresionsita.setjLabelDireccion(direccion);
        impresionsita.setjLabel1NIF(nif);
        impresionsita.setJLabelTelefono(telefono + "");
    }
    
    public boolean comprobarCampos(){
        boolean vacio = false;
        if(miVista.getjTextFieldDireccion().isEmpty() ||
           miVista.getjTextFieldNif().isEmpty() ||
           miVista.getjTextFieldNombreCliente().isEmpty() ||
           miVista.getjTextFieldTelefono()==0 ||
           miVista.getjTextAreaProductos().isEmpty() ||
           miVista.getjTextFieldDescuento().isEmpty() ||
           miVista.getjTextFieldCantidad().isEmpty()){
            vacio = true;
            System.out.println("Faltan campos por rellenar");
            JOptionPane.showMessageDialog(ventanaInicio, "FALTAN CAMPOS POR RELLENAR");
            return vacio;
        }
        return vacio;    
    }
    /**
     *Metodo que se encarga de coger los datos de la ventana miVista
     * y añadirlos a la parte inferior que simula la cesta de la compra, esta funcion se usa al pulsar 
     * el boton "AÑADIR AL CARRO"
     */ 
    public void rellenarProductosPDF(){
        String producto = miVista.getProductoSeleccionado();
        int cantidad = miVista.getCantidad();
        double precio = miVista.getPrecioProducto();
        double descuento = miVista.getDescuento();
        int iva = 21;
        double total = miModelo.cestita.calcularTotal();
        String cantidad2 = " ";

        switch (producto) {
            case "MANZANA":
                producto = "MANZANA                                         ";
                break;
            case "PERA":
                producto = "PERA                                                  ";
                break;
            case "PLATANO":
                producto = "PLATANO                                           ";
                break;
            case "MANGO":
                producto = "MANGO                                              ";
                break;
            case "PIÑA":
                producto = "PIÑA                                                  ";
                break;
        }

        switch (Integer.toString(cantidad).length()) {
            case 1:
                cantidad2 = cantidad + "                          ";
                break;
            case 2:
                cantidad2 = cantidad + "                         ";
                break;
            case 3:
                cantidad2 = cantidad + "                      ";
                break;
            case 4:
                cantidad2 = cantidad + "                    ";
                break;
            case 5:
                cantidad2 = cantidad + "                  ";
                break;
        }
        
        String definitivo = "   " + producto + cantidad2 + precio + "                 " + descuento + "              " + iva + "           " + total + "€";

        impresionsita.jTextAreaProductos(definitivo);
    }
    /**
     *Metodo que se encarga de lanzar la venta de impresion para imprimir directamente desde la impresora
     * a traves del boton "imprimir"
     */ 
     private void imprimirPDF() { 
         System.out.println("esta bien vas imprimir");
         impresionsita.cargarbotonimprimir();
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
                }else{
                rellenarProductosPDF();
                rellenarClientePDF(); 
                System.out.println("Sacando factura...");
                lanzarVentanaFactura();
                }
                break;
            case "IMPRIMIR":
               System.out.println("Vas a Imprimir tu factura");
               imprimirPDF();
                break;
            default:
                System.out.print("Error" + e.getActionCommand());
                break;
        }
    }
}