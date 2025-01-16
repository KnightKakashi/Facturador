/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.File;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

/* Librerías iText para la creación de PDF */
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.property.TextAlignment;

/**
 * Clase para convertir un archivo XML en un archivo PDF con formato de factura.
 * <p>
 * Esta clase procesa un archivo XML que contiene la información de la factura y la convierte en un archivo PDF, 
 * aplicando un formato adecuado para una factura profesional.
 * </p>
 */
public class XML_A_PDF2 {

    /**
     * Convierte un archivo XML a un archivo PDF con formato de factura.
     * @author Ioan Sorin Muntean
     * @param rutaArchivoXML Ruta del archivo XML de entrada.
     * @param rutaArchivoPDF Ruta donde se generará el archivo PDF.
     * @throws Exception Si ocurre un error durante la conversión.
     */
    public void convertirXMLAPDF(String rutaArchivoXML, String rutaArchivoPDF) throws Exception {
        // Leer el contenido del archivo XML
        String contenidoXML = leerXML(rutaArchivoXML);

        // Crear el PDF con los datos extraídos del XML
        crearPDF(rutaArchivoPDF, contenidoXML);
    }

    /**
     * Crea un archivo PDF con el contenido proporcionado.
     *
     * @param rutaDestino Ruta donde se generará el archivo PDF.
     * @param contenido Contenido a escribir en el archivo PDF.
     * @throws Exception Si ocurre un error durante la creación del PDF.
     */
    private void crearPDF(String rutaDestino, String contenido) throws Exception {
        // Crear el documento PDF y su escritor
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(rutaDestino));

        // Crear el layout del documento
        Document doc = new Document(pdfDoc);

        // Cabecera de la factura
        doc.add(new Paragraph("Factura Generada")
                .setBold()
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER));

        // Datos de la empresa (puedes personalizarlos según tu empresa)
        doc.add(new Paragraph("Empresa: Mi Empresa S.L.")
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Dirección: Calle Ficticia, 123")
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Teléfono: 987654321")
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Correo: info@miempresa.com")
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("\n"));

        // Datos del cliente extraídos del contenido XML
        doc.add(new Paragraph("Cliente: " + contenido.split("<Nombre>")[1].split("</Nombre>")[0])
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("NIF: " + contenido.split("<NIF>")[1].split("</NIF>")[0])
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Teléfono: " + contenido.split("<Telefono>")[1].split("</Telefono>")[0])
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Dirección: " + contenido.split("<Direccion>")[1].split("</Direccion>")[0])
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("\n"));

        // Detalles de los productos
        doc.add(new Paragraph("Detalles de la compra:")
                .setBold()
                .setFontSize(14)
                .setTextAlignment(TextAlignment.LEFT));

        // Crear una tabla para los productos
        Table table = new Table(5);
        table.addCell("Producto");
        table.addCell("Cantidad");
        table.addCell("Precio Unitario (€)");
        table.addCell("Descuento (%)");
        table.addCell("Total (€)");

        // Llenar la tabla con los productos extraídos del contenido XML
        for (String productoXML : contenido.split("<Producto>")) {
            if (productoXML.contains("<Nombre>")) {
                String nombreProducto = productoXML.split("<Nombre>")[1].split("</Nombre>")[0];
                String cantidadProducto = productoXML.split("<Cantidad>")[1].split("</Cantidad>")[0];
                String precioProducto = productoXML.split("<Precio>")[1].split("</Precio>")[0];
                String descuentoProducto = productoXML.split("<Descuento>")[1].split("</Descuento>")[0];
                String totalProducto = String.format("%.2f", Double.parseDouble(precioProducto) * Integer.parseInt(cantidadProducto) * (1 - Double.parseDouble(descuentoProducto) / 100));

                table.addCell(nombreProducto);
                table.addCell(cantidadProducto);
                table.addCell(precioProducto);
                table.addCell(descuentoProducto);
                table.addCell(totalProducto);
            }
        }

        doc.add(table);

        // Total de la factura: Precio base, IVA y Total
        double precioBase = Double.parseDouble(contenido.split("<Total>")[1].split("</Total>")[0]);
        double iva = precioBase * 0.21; // 21% IVA
        double totalFactura = precioBase + iva;

        // Resumen de la factura
        doc.add(new Paragraph("\n"));
        doc.add(new Paragraph("Resumen de la factura:")
                .setBold()
                .setFontSize(14)
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Precio Base: €" + String.format("%.2f", precioBase))
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("IVA (21%): €" + String.format("%.2f", iva))
                .setTextAlignment(TextAlignment.LEFT));
        doc.add(new Paragraph("Total: €" + String.format("%.2f", totalFactura))
                .setBold()
                .setTextAlignment(TextAlignment.LEFT));

        // Cerrar el documento
        doc.close();

        System.out.println("PDF creado correctamente: " + rutaDestino);
    }

    /**
     * Lee un archivo XML y lo transforma en un String formateado.
     *
     * @param rutaArchivo Ruta del archivo XML.
     * @return Contenido del XML como texto formateado.
     * @throws Exception Si ocurre un error durante la lectura del XML.
     */
    private String leerXML(String rutaArchivo) throws Exception {
        // Configurar el DocumentBuilder para leer el XML
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(new File(rutaArchivo));

        // Normalizar el documento XML
        doc.getDocumentElement().normalize();

        // Crear un XPath para extraer los valores fácilmente
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        // Extraer los datos del cliente y total utilizando XPath
        String nombreCliente = xpath.evaluate("//Cliente/Nombre", doc);
        String nifCliente = xpath.evaluate("//Cliente/NIF", doc);
        String telefonoCliente = xpath.evaluate("//Cliente/Telefono", doc);
        String direccionCliente = xpath.evaluate("//Cliente/Direccion", doc);
        String total = xpath.evaluate("//Factura/Total", doc);

        // Aquí puedes extraer otros campos según el XML
        return "<Nombre>" + nombreCliente + "</Nombre>" +
               "<NIF>" + nifCliente + "</NIF>" +
               "<Telefono>" + telefonoCliente + "</Telefono>" +
               "<Direccion>" + direccionCliente + "</Direccion>" +
               "<Total>" + total + "</Total>";
    }
}



/*
Cómo Modificar Datos y Llamar a las Funciones
Para utilizar la clase XML_A_PDF2 y convertir un archivo XML a PDF, puedes seguir estos pasos:

Crear una Instancia de la Clase: Primero, crea una instancia de la clase XML_A_PDF2.

java
XML_A_PDF2 converter = new XML_A_PDF2();
Llamar a la Función convertirXMLAPDF: Usa la instancia creada para llamar a la función convertirXMLAPDF. Esta función toma dos parámetros: la ruta del archivo XML de entrada y la ruta donde se generará el archivo PDF de salida.

java
String rutaArchivoXML = "ruta/a/tu/archivo.xml";
String rutaArchivoPDF = "ruta/a/tu/salida.pdf";
converter.convertirXMLAPDF(rutaArchivoXML, rutaArchivoPDF);
Modificar Datos en el Código
Para modificar los datos del archivo PDF, puedes seguir estos pasos:

Modificar los Datos de la Empresa: Puedes cambiar los datos de la empresa que aparecen en la factura, modificando las líneas correspondientes en el método crearPDF.

java
doc.add(new Paragraph("Empresa: Mi Nueva Empresa S.L.")
        .setTextAlignment(TextAlignment.LEFT));
doc.add(new Paragraph("Dirección: Calle Nueva, 456")
        .setTextAlignment(TextAlignment.LEFT));
doc.add(new Paragraph("Teléfono: 123456789")
        .setTextAlignment(TextAlignment.LEFT));
doc.add(new Paragraph("Correo: contacto@miempresa.com")
        .setTextAlignment(TextAlignment.LEFT));
Modificar la Estructura del PDF: Puedes añadir o quitar columnas de la tabla de productos o cambiar el formato de los datos que aparecen en el PDF.

java
// Añadir una columna para "Fecha"
Table table = new Table(6); // Ajustado a 6 columnas para incluir Fecha
table.addCell("Producto");
table.addCell("Cantidad");
table.addCell("Precio Unitario (€)");
table.addCell("Descuento (%)");
table.addCell("Total (€)");
table.addCell("Fecha");
Agregar o Quitar Elementos del PDF: Puedes agregar nuevos elementos, como imágenes o secciones adicionales, utilizando las funcionalidades de la librería iText.

java
// Ejemplo de cómo agregar una imagen (asegúrate de tener la imagen en la ruta especificada)
Image img = new Image(ImageDataFactory.create("ruta/a/tu/imagen.png"));
doc.add(img);
Ejemplo Completo
Aquí tienes un ejemplo completo de cómo puedes modificar los datos y llamar a las funciones:

java
public class Main {
    public static void main(String[] args) {
        try {
            // Crear una instancia del conversor
            XML_A_PDF2 converter = new XML_A_PDF2();

            // Rutas de los archivos
            String rutaArchivoXML = "ruta/a/tu/archivo.xml";
            String rutaArchivoPDF = "ruta/a/tu/salida.pdf";

            // Convertir el archivo XML a PDF
            converter.convertirXMLAPDF(rutaArchivoXML, rutaArchivoPDF);

            System.out.println("Conversión completada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
Conclusión
La clase XML_A_PDF2 está diseñada para convertir archivos XML en documentos PDF con formato de factura. 
Puedes personalizar los datos de la empresa, la estructura del PDF y añadir nuevos elementos según tus necesidades.
Simplemente llama a las funciones proporcionadas y modifica las secciones del código como se ha mostrado en los ejemplos.

*/