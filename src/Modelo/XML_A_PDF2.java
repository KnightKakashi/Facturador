package Modelo;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import javax.swing.JFileChooser;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;

/**
 * Clase para convertir un archivo XML en un archivo PDF con formato de factura.
 */
public class XML_A_PDF2 {

   
}

    /**
     * Lee un archivo XML y lo transforma en un String formateado.
     *
     * @param rutaArchivo Ruta del archivo XML.
     * @return Contenido del XML como texto formateado.
     * @throws Exception Si ocurre un error durante la lectura del XML.
     */
    private String leerXML(String rutaArchivo) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(new File(rutaArchivo));
        doc.getDocumentElement().normalize();

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        String nombreCliente = xpath.evaluate("//Cliente/nombre", doc);
        String nifCliente = xpath.evaluate("//Cliente/nif", doc);
        String telefonoCliente = xpath.evaluate("//Cliente/telefono", doc);
        String direccionCliente = xpath.evaluate("//Cliente/direccion", doc);
        String total = xpath.evaluate("//Total", doc);

        NodeList productos = (NodeList) xpath.evaluate("//Productos/Producto", doc, XPathConstants.NODESET);
        StringBuilder productosBuilder = new StringBuilder();
        for (int i = 0; i < productos.getLength(); i++) {
            org.w3c.dom.Node productoNode = productos.item(i);

            String nombreProducto = xpath.evaluate("Nombre", productoNode);
            String cantidadProducto = xpath.evaluate("Cantidad", productoNode);
            String precioProducto = xpath.evaluate("Precio", productoNode);
            String descuentoProducto = xpath.evaluate("Descuento", productoNode);

            productosBuilder.append("<Producto>")
                    .append("<Nombre>").append(nombreProducto).append("</Nombre>")
                    .append("<Cantidad>").append(cantidadProducto).append("</Cantidad>")
                    .append("<Precio>").append(precioProducto).append("</Precio>")
                    .append("<Descuento>").append(descuentoProducto).append("</Descuento>")
                    .append("</Producto>");
        }

        return "<Cliente><Nombre>" + nombreCliente + "</Nombre><NIF>" + nifCliente + "</NIF><Telefono>" + telefonoCliente + "</Telefono><Direccion>" + direccionCliente + "</Direccion></Cliente>"
                + "<Productos>" + productosBuilder + "</Productos><Total>" + total + "</Total>";
    }
//}




///*
//Cómo Modificar Datos y Llamar a las Funciones
//Para utilizar la clase XML_A_PDF2 y convertir un archivo XML a PDF, puedes seguir estos pasos:
//
//Crear una Instancia de la Clase: Primero, crea una instancia de la clase XML_A_PDF2.
//
//java
//XML_A_PDF2 converter = new XML_A_PDF2();
//Llamar a la Función convertirXMLAPDF: Usa la instancia creada para llamar a la función convertirXMLAPDF. Esta función toma dos parámetros: la ruta del archivo XML de entrada y la ruta donde se generará el archivo PDF de salida.
//
//java
//String rutaArchivoXML = "ruta/a/tu/archivo.xml";
//String rutaArchivoPDF = "ruta/a/tu/salida.pdf";
//converter.convertirXMLAPDF(rutaArchivoXML, rutaArchivoPDF);
//Modificar Datos en el Código
//Para modificar los datos del archivo PDF, puedes seguir estos pasos:
//
//Modificar los Datos de la Empresa: Puedes cambiar los datos de la empresa que aparecen en la factura, modificando las líneas correspondientes en el método crearPDF.
//
//java
//doc.add(new Paragraph("Empresa: Mi Nueva Empresa S.L.")
//        .setTextAlignment(TextAlignment.LEFT));
//doc.add(new Paragraph("Dirección: Calle Nueva, 456")
//        .setTextAlignment(TextAlignment.LEFT));
//doc.add(new Paragraph("Teléfono: 123456789")
//        .setTextAlignment(TextAlignment.LEFT));
//doc.add(new Paragraph("Correo: contacto@miempresa.com")
//        .setTextAlignment(TextAlignment.LEFT));
//Modificar la Estructura del PDF: Puedes añadir o quitar columnas de la tabla de productos o cambiar el formato de los datos que aparecen en el PDF.
//
//java
//// Añadir una columna para "Fecha"
//Table table = new Table(6); // Ajustado a 6 columnas para incluir Fecha
//table.addCell("Producto");
//table.addCell("Cantidad");
//table.addCell("Precio Unitario (€)");
//table.addCell("Descuento (%)");
//table.addCell("Total (€)");
//table.addCell("Fecha");
//Agregar o Quitar Elementos del PDF: Puedes agregar nuevos elementos, como imágenes o secciones adicionales, utilizando las funcionalidades de la librería iText.
//
//java
//// Ejemplo de cómo agregar una imagen (asegúrate de tener la imagen en la ruta especificada)
//Image img = new Image(ImageDataFactory.create("ruta/a/tu/imagen.png"));
//doc.add(img);
//Ejemplo Completo
//Aquí tienes un ejemplo completo de cómo puedes modificar los datos y llamar a las funciones:
//
//java
//public class Main {
    public static void main(String[] args) {
        try {
            // Crear una instancia del conversor
            XML_A_PDF2 converter = new XML_A_PDF2();

            // Rutas de los archivos
            String rutaArchivoPDF = "salida.pdf";

            // Convertir el archivo XML a PDF
            converter.convertirXMLAPDF(rutaArchivoPDF);

            System.out.println("Conversión completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//Conclusión
//La clase XML_A_PDF2 está diseñada para convertir archivos XML en documentos PDF con formato de factura. 
//Puedes personalizar los datos de la empresa, la estructura del PDF y añadir nuevos elementos según tus necesidades.
//Simplemente llama a las funciones proporcionadas y modifica las secciones del código como se ha mostrado en los ejemplos.
//
//*/