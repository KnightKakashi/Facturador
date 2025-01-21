/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Modelo.CestaCompra;
import Modelo.Cliente;
import Modelo.GeneradorXML;
import Modelo.PlaceholderModelo;
import Modelo.Producto;
import Vista.Imprimir;
import Vista.VentanaInicio;
import Vista.MiVista;
import Vista.VentanaBorrar;

/**
 *
 * @author dam2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Clases del package Vista
        VentanaInicio ventanaInicio = new VentanaInicio();
        MiVista miVista = new MiVista();
        Imprimir impresionsita = new Imprimir();
        VentanaBorrar borrar = new VentanaBorrar();
        //Clases del package Modelo
        CestaCompra miCesta = new CestaCompra();
        Cliente miCliente = new Cliente();
        GeneradorXML miGeneradorXML = new GeneradorXML();
        Producto miProducto = new Producto();
        
        PlaceholderModelo miModelo = new PlaceholderModelo(miCesta, miCliente, miGeneradorXML, miProducto);       
        ControladorLanzarVentanas controladorLanzarVentanas = new ControladorLanzarVentanas(ventanaInicio, miVista,impresionsita, borrar, miModelo);
        
        controladorLanzarVentanas.lanzarPrograma();
    }  
}