package Controlador;

import Modelo.PlaceholderModelo;
import Modelo.Producto;
import Vista.MiFacturita;
import Vista.MiVista;
import Vista.VentanaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author GART
 */
public class ControladorLanzarVentanas implements ActionListener {
    
    private VentanaInicio ventanaInicio;
    private MiVista miVista;
    private MiFacturita miFactura;
    private PlaceholderModelo miModelo;
    
    public ControladorLanzarVentanas(VentanaInicio ventanaInicio, MiVista miVista, MiFacturita miFactura, PlaceholderModelo miModelo){
        this.ventanaInicio = ventanaInicio;
        this.miVista = miVista;
        this.miModelo = miModelo;
        this.miFactura= miFactura;
        
        System.out.println("Iniciando constructor ControladorLanzarVentanas...");
        
        escuchadores(this);
    }

    public void escuchadores(ActionListener listener){
        miVista.jButtonGuardar(this);
        miVista.jButtonAñadir(this);
        miVista.jButtonGuardarCliente(this);
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
       
        miFactura.setVisible(true);
        
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
        miFactura.setjLabelNombre(nombre);
        miFactura.setjLabelDireccion(direccion);
        miFactura.setjLabel1NIF(nif);
        miFactura.setJlabelTelefono(telefono + "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "AÑADIR AL CARRO":
                System.out.println("Añadiendo al carro...");
                rellenarCarro();
                break;
            case "GUARDAR":
                System.out.println("Guardando...");
                //ESTO ES LO QUE TE TOCA A TIU CUDRIG, 
                //HACER UN METODO QUE COJA LAS COSAS DEL PRODUCTO Y LAS PONGA EN EL TEXTAREA DEL PDF
                //CUANDO LE DES AL BOTON GUARDAR
                lanzarVentanaFactura();
                break;
            case "GUARDAR CLIENTE":
                System.out.println("Guardando datos del cliente...");
                rellenarClientePDF();        
                break;
            default:
                System.out.print("Error" + e.getActionCommand());
                break;
        }
    }
}