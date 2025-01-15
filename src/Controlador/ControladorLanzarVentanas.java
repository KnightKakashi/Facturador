/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.PlaceholderModelo;
import Vista.MiVista;
import Vista.VentanaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private PlaceholderModelo miModelo;
    
    public ControladorLanzarVentanas(VentanaInicio ventanaInicio,  MiVista miVista, PlaceholderModelo miModelo){
        this.ventanaInicio = ventanaInicio;
        this.miVista = miVista;
        this.miModelo = miModelo;
        
        System.out.println("Iniciando...");
        ImageIcon gifIcon = new ImageIcon("src/recursos/inicio_facturacion.gif");
        ventanaInicio.getJLabelIcono(gifIcon);
        ventanaInicio.setTitle("Cargando...");
        ventanaInicio.setSize(550, 480);
        ventanaInicio.setResizable(false);
        
        escuchadores(this);
    }
    
    public void escuchadores(ActionListener listener){
        miVista.jButtonGuardar(this);
        miVista.jButtonAñadir(this);
        
        miVista.getjComboBoxNombreProducto().addActionListener(e -> {
            String producto = miVista.getProductoSeleccionado(); // Método para obtener el producto seleccionado
            String precio = obtenerPrecio(producto); // Lógica para determinar el precio
            miVista.setPrecioProducto(precio); // Actualizar el campo de texto
        });
    }

    /**
    * Metodo que lanza la ventana de carga,
    * Este metodo se encarga de lanzar la ventana y despues de unos segundos
    * se cierra para que se abra la ventana principal de la aplicacion
    */
    public void lanzarVentanaCarga(){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}