/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Vista.MiVista;
import Vista.VentanaInicio;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author GART
 */
public class ControladorLanzarVentanas {
    
    private VentanaInicio ventanaInicio;
    private MiVista miVista;
    
    public ControladorLanzarVentanas(VentanaInicio ventanaInicio,  MiVista miVista){
        this.ventanaInicio = ventanaInicio;
        this.miVista = miVista;
        
        System.out.println("Iniciando...");
        ImageIcon gifIcon = new ImageIcon("src/recursos/inicio_facturacion.gif");
        ventanaInicio.getJLabelIcono(gifIcon);
        ventanaInicio.setTitle("Cargando...");
        ventanaInicio.setSize(550, 480);
        ventanaInicio.setResizable(false);
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
    
}
