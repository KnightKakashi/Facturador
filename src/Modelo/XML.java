/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ild_37
 */
public class XML {
    private static String Name="Mercadona";
public static String NombreXML="Factura";
private int ronda=0;//Esta variable te dice si es la primera vez que ese cliente añade un producto 
private double TotalFactuta=0;


    public void Añadir(String producto,int cantidad,double precio,int descuento,String fecha,int IdCliente,String NCliente) throws IOException{
    TotalFactuta+=((precio*cantidad)*(100-descuento)/100);
    if (ronda==0){
        crearFichero();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NombreXML+".xml"))) {
            // Escribimos la estructura básica del XML
                writer.write("<Factura>\n");
                writer.write("    <NEmpresa>Name</NEmpresa>\n");
                writer.write("    <Productos>\n");
                writer.write("        <Producto>\n");
                writer.write("            <NProducto>" + producto + "</NProducto>\n");
                writer.write("            <Cantidad>" + cantidad + "</Cantidad>\n");
                writer.write("            <Precio>" + precio + "</Precio>\n");
                writer.write("            <Descuento>" + descuento + "</Descuento>\n");
                writer.write("            <Fecha>" + fecha + "</Fecha>\n");
                writer.write("        </Producto>\n");
                writer.write("    </Productos>\n");
                writer.write("    <Cliente>\n");
                writer.write("        <IDCliente>" + IdCliente + "</IDCliente>\n");
                writer.write("        <NCliente>" + NCliente + "</NCliente>\n");
                writer.write("    </Cliente>\n");
                writer.write("    <Total>" + TotalFactuta + "</Total>\n");
                writer.write("</Factura>");
               
            System.out.println("El archivo XML ha sido creado exitosamente.");
             ronda++;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());    
    }
   
}
     else{
            AñadirProducto(producto, cantidad, precio, descuento, fecha);
             
             }
    }
    
    public void AñadirProducto(String producto, int cantidad, double precio, int descuento, String fecha) {
    StringBuilder contenido = new StringBuilder();
    StringBuilder nuevoProducto = new StringBuilder();

    // Construir el XML del nuevo producto
    nuevoProducto.append("        <Producto>\n");
    nuevoProducto.append("            <NProducto>").append(producto).append("</NProducto>\n");
    nuevoProducto.append("            <Cantidad>").append(cantidad).append("</Cantidad>\n");
    nuevoProducto.append("            <Precio>").append(precio).append("</Precio>\n");
    nuevoProducto.append("            <Descuento>").append(descuento).append("</Descuento>\n");
    nuevoProducto.append("            <Fecha>").append(fecha).append("</Fecha>\n");
    nuevoProducto.append("        </Producto>\n");

    boolean productoInsertado = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(NombreXML + ".xml"))) {
        String linea;

        // Leer línea por línea
        while ((linea = reader.readLine()) != null) {
            // Detectar dónde insertar el nuevo producto
            if (linea.trim().equals("</Productos>") && !productoInsertado) {
                contenido.append(nuevoProducto); // Insertar el nuevo producto
                productoInsertado = true;
            }
            contenido.append(linea).append("\n"); // Copiar el resto del contenido
            
        }
    } catch (IOException e) {
        System.err.println("Error al leer el archivo XML: " + e.getMessage());
        return;
    }

    // Reescribir el archivo con el contenido actualizado
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(NombreXML + ".xml"))) {
        writer.write(contenido.toString());
        System.out.println("Producto agregado exitosamente al archivo XML.");
        
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo XML: " + e.getMessage());
    }
}
    
    public void crearFichero () throws IOException{

    File fichero = new File(NombreXML+".xml");

    if(!fichero.exists()){
       fichero.createNewFile();
    } 
    }
    

}


