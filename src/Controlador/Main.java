/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Vista.VentanaInicio;
import Vista.MiVista;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VentanaInicio ventanaInicio = new VentanaInicio();
        MiVista miVista = new MiVista();
        Producto miProducto = new Producto();
        
        ControladorLanzarVentanas controladorLanzarVentanas = new ControladorLanzarVentanas(ventanaInicio, miVista, miProducto);
        controladorLanzarVentanas.lanzarPrograma();
    }  
}