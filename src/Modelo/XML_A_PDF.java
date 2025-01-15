package modelo;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * Clase para convertir un archivo XML a PDF.
 */
public class XML_A_PDF {

    /**
     * Convierte un archivo XML en un archivo PDF.
     * @author Ioan Sorin Muntean
     * @param rutaArchivoXML Ruta del archivo XML de entrada.
     * @param rutaArchivoPDF Ruta donde se generará el PDF.
     * @throws Exception Si ocurre un error durante la conversión.
     */
    public void convertirXMLAPDF(String rutaArchivoXML, String rutaArchivoPDF) throws Exception {
        // Leer contenido del archivo XML como texto formateado
        String contenidoXML = leerXML(rutaArchivoXML);

        // Crear un PDF con el contenido del XML
        crearPDF(rutaArchivoPDF, contenidoXML);
    }

    /**
     * Crea un archivo PDF con contenido especificado.
     *
     * @param rutaDestino Ruta donde se generará el PDF.
     * @param contenido Contenido a escribir en el PDF.
     * @throws Exception Si ocurre un error durante la generación del PDF.
     */
    private void crearPDF(String rutaDestino, String contenido) throws Exception {
        // Crear el documento PDF
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(rutaDestino));

        // Crear el layout del documento
        Document doc = new Document(pdfDoc);

        // Agregar el contenido al PDF como un párrafo
        doc.add(new Paragraph(contenido));

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

        // Transformar el documento DOM en un String con formato
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);

        java.io.StringWriter sw = new java.io.StringWriter();
        StreamResult result = new StreamResult(sw);
        transformer.transform(source, result);

        return sw.toString();
    }
}
/* Instrucciones de como usar la clase

public class Main {
    public static void main(String[] args) {
        try {
            // Crear una instancia de la clase XML_A_PDF
            XML_A_PDF xmlToPdf = new XML_A_PDF();
            
            // Definir las rutas de los archivos XML y PDF
            String rutaXML = "ruta/a/tu/archivo.xml"; // Ruta del archivo XML a convertir
            String rutaPDF = "ruta/donde/guardar/archivo.pdf"; // Ruta donde se guardará el PDF
            
            // Llamar al método para convertir el XML a PDF
            xmlToPdf.convertirXMLAPDF(rutaXML, rutaPDF);
            
        } catch (Exception e) {
            // Capturar cualquier excepción que ocurra y mostrarla
            System.err.println("Error al convertir XML a PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
*/