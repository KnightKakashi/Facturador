/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import java.io.File;

/**
 *
 * @author ignac
 */
public class GeneradorXML {
   
    public void generarFacturaXML(CestaCompra cesta, String rutaArchivo) {
        try {
            // Crear documento
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Crear raíz
            Element root = doc.createElement("Factura");
            doc.appendChild(root);

            // Cliente
            Element cliente = doc.createElement("Cliente");
            root.appendChild(cliente);

            Element nombre = doc.createElement("Nombre");
            nombre.appendChild(doc.createTextNode(cesta.getCliente().getNombre()));
            cliente.appendChild(nombre);

            Element nif = doc.createElement("NIF");
            nif.appendChild(doc.createTextNode(cesta.getCliente().getNif()));
            cliente.appendChild(nif);
            
            Element tlf = doc.createElement("Telefono");
            tlf.appendChild(doc.createTextNode(Integer.toString(cesta.getCliente().getTlf())));
            cliente.appendChild(tlf);
            
            Element dir = doc.createElement("Direccion");
            dir.appendChild(doc.createTextNode(cesta.getCliente().getDireccion()));
            cliente.appendChild(dir);

            // Productos
            Element productos = doc.createElement("Productos");
            root.appendChild(productos);

            for (Producto producto : cesta.getLista()) {
                Element productoNode = doc.createElement("Producto");

                Element nombreProducto = doc.createElement("Nombre");
                nombreProducto.appendChild(doc.createTextNode(producto.getNombre()));
                productoNode.appendChild(nombreProducto);
                
                Element cantidadProducto = doc.createElement("Cantidad");
                cantidadProducto.appendChild(doc.createTextNode((Integer.toString(producto.getCantidad()))));
                productoNode.appendChild(cantidadProducto);

                Element precioProducto = doc.createElement("Precio");
                precioProducto.appendChild(doc.createTextNode((Double.toString(producto.getPrecio()))));
                productoNode.appendChild(precioProducto);
                
                Element descuentoProducto = doc.createElement("Descuento");
                descuentoProducto.appendChild(doc.createTextNode((Double.toString(producto.getDescuento()))));
                productoNode.appendChild(descuentoProducto);
                
                Element fechaProducto = doc.createElement("Fecha");
                fechaProducto.appendChild(doc.createTextNode(producto.getFecha()));
                productoNode.appendChild(fechaProducto);

                productos.appendChild(productoNode);
            }

            // Total
            Element total = doc.createElement("Total");
            total.appendChild(doc.createTextNode(String.valueOf(cesta.calcularTotal())));
            root.appendChild(total);

            // Guardar en archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

            System.out.println("XML generado correctamente: " + rutaArchivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


