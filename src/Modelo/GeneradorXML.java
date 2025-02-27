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
 * Clase encargada de generar un archivo XML con la información de una factura.
 * La factura contiene los datos del cliente, de la empresa, los productos adquiridos 
 * y el total de la compra. El XML generado se guarda en una ruta especificada.
 * 
 * <p>
 * Esta clase usa la API de Java DOM para crear el archivo XML y la API de transformación
 * para guardar el XML en un archivo en el sistema de archivos.
 * </p>
 * 
 * @author ignac
 */
public class GeneradorXML {
   
	  /**
     * Genera un archivo XML con los datos de la factura de una cesta de compra.
     * El XML generado incluye los datos del cliente, de la empresa, los productos
     * adquiridos y el total de la compra.
     *
     * @param cesta El objeto que contiene la cesta de compra con los detalles de 
     *              los productos y el cliente.
     * @param rutaArchivo La ruta donde se guardará el archivo XML generado.
     * 
     * @throws Exception Si ocurre un error al generar o guardar el archivo XML.
     */
    public void generarFacturaXML(CestaCompra cesta) { 
        
        try {
            //Crear documento
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            //Crear raíz
            Element root = doc.createElement("factura");
            doc.appendChild(root);

            //Cliente
            Element cliente = doc.createElement("Cliente");
            root.appendChild(cliente);

            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(cesta.getCliente().getNombre()));
            cliente.appendChild(nombre);

            Element nif = doc.createElement("nif");
            nif.appendChild(doc.createTextNode(cesta.getCliente().getNif()));
            cliente.appendChild(nif);
            
            Element telefono = doc.createElement("telefono");
            telefono.appendChild(doc.createTextNode(Integer.toString(cesta.getCliente().getTelefono())));
            cliente.appendChild(telefono);
            
            Element dir = doc.createElement("direccion");
            dir.appendChild(doc.createTextNode(cesta.getCliente().getDireccion()));
            cliente.appendChild(dir);
            
            //Empresa
            Element empresaElement = doc.createElement("Empresa");
            root.appendChild(empresaElement);

            Element nombreEmpresa = doc.createElement("nombre");
            nombreEmpresa.appendChild(doc.createTextNode(Empresa.getNombre()));
            empresaElement.appendChild(nombreEmpresa);

            Element direccionEmpresa = doc.createElement("direccion");
            direccionEmpresa.appendChild(doc.createTextNode(Empresa.getDireccion()));
            empresaElement.appendChild(direccionEmpresa);

            Element telefonoEmpresa = doc.createElement("telefono");
            telefonoEmpresa.appendChild(doc.createTextNode(Empresa.getTelefono()));
            empresaElement.appendChild(telefonoEmpresa);

            Element correoEmpresa = doc.createElement("correo") ;
            correoEmpresa.appendChild(doc.createTextNode(Empresa.getCorreo()));
            empresaElement.appendChild(correoEmpresa);

            // Productos
            Element productos = doc.createElement("Productos");
            root.appendChild(productos);

            for(Producto producto : cesta.getLista()) {
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

            //Total
            Element total = doc.createElement("Total");
            total.appendChild(doc.createTextNode(String.valueOf(cesta.calcularTotal())));
            root.appendChild(total);

            // Crear el directorio "Facturas" si no existe
            String rutaDirectorio = "Facturas";
            File directorio = new File(rutaDirectorio);

            // Crear los directorios necesarios
            if (directorio.mkdirs()) {
                System.out.println("Directorios creados: " + directorio.getAbsolutePath());
            } else {
                System.out.println("No se pudieron crear los directorios o ya existen.");
            }

            // Generar un nombre único para la factura
            String nombreArchivo = "Factura_" + System.currentTimeMillis() + ".xml";
            File archivoFactura = new File(directorio, nombreArchivo);

            // Guardar en archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(archivoFactura);
            transformer.transform(source, result);

            System.out.println("XML generado correctamente: " + archivoFactura.getAbsolutePath());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}