package Controlador;
import Modelo.Producto;
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
    private Producto miProducto;
    
    public ControladorLanzarVentanas(VentanaInicio ventanaInicio,  MiVista miVista, Producto miProducto){
        this.ventanaInicio = ventanaInicio;
        this.miVista = miVista;
        this.miProducto = miProducto;
        
        System.out.println("Iniciando...");
        
        escuchadores(this);
    }
    
    
    
    public void escuchadores(ActionListener listener){
        miVista.jButtonGuardar(this);
        miVista.jButtonAñadir(this);
        
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
        }, 9000);
    }
    
    private String obtenerPrecio(String producto){
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
  
    public void rellenarcarro() {
        miVista.jTextAreaProductos(" ");
        miVista.jTextAreaProductos(miProducto.toString());
        
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //jButtonGuardar
        //jButtonAñadir
        switch (e.getActionCommand()) {
            case "AÑADIR AL CARRO":
            rellenarcarro();
            break;
            case "GUARDAR":
            break;
            default:
            System.out.print("Error" + e.getActionCommand());
            break;
        }
        
       
    }
}