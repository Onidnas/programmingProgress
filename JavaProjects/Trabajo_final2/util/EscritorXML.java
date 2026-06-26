package util;

import modelo.Libro;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class EscritorXML {

    /**
     * Exporta la lista de libros a un archivo XML con el formato:
     *
     * <?xml version="1.0" encoding="UTF-8"?>
     * <catalogo sistema="Biblioteca Digital TEC" fecha="yyyy-MM-dd">
     *     <libro isbn="978-1">
     *         <titulo>Dune</titulo>
     *         <autor>Frank Herbert</autor>
     *         <genero>Ciencia Ficción</genero>
     *         <precio>280.00</precio>
     *         <ejemplares>5</ejemplares>
     *     </libro>
     *     ...
     * </catalogo>
     *
     * @param ruta    Ruta del archivo XML de salida
     * @param libros  Lista de libros a exportar
     * @param sistema Nombre del sistema (atributo del elemento raíz)
     */
    public static void exportar(String ruta, List<Libro> libros, String sistema) {

        // Crear directorio de salida si no existe
        new File(ruta).getParentFile().mkdirs();

        try {
            // 1) Crear un Document vacío
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder        builder = factory.newDocumentBuilder();
            Document               doc     = builder.newDocument();

            // 2) Elemento raíz <catalogo> con atributos sistema y fecha
            Element raiz = doc.createElement("catalogo");
            raiz.setAttribute("sistema", sistema);
            raiz.setAttribute("fecha", LocalDate.now().toString());
            doc.appendChild(raiz);

            // 3) Un elemento <libro> por cada libro de la lista
            for (Libro l : libros) {
                Element libro = doc.createElement("libro");
                libro.setAttribute("isbn", l.getIsbn());

                addChild(doc, libro, "titulo",     l.getTitulo());
                addChild(doc, libro, "autor",      l.getAutor());
                addChild(doc, libro, "genero",     l.getGenero());
                addChild(doc, libro, "precio",     String.format("%.2f", l.getPrecio()));
                addChild(doc, libro, "ejemplares", String.valueOf(l.getEjemplares()));

                raiz.appendChild(libro);
            }

            // 4) Serializar el Document a archivo con indentación
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,   "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");

            transformer.transform(
                new DOMSource(doc),
                new StreamResult(new File(ruta))
            );

            System.out.println("✔ Inventario XML generado → " + ruta);

        } catch (ParserConfigurationException | TransformerException e) {
            System.err.println("✘ Error al generar XML: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar: crea un elemento hijo con texto y lo agrega al padre.
     *
     * @param doc    Documento DOM
     * @param parent Elemento padre al que se agrega el hijo
     * @param tag    Nombre de la etiqueta XML
     * @param value  Contenido de texto del elemento
     */
    private static void addChild(Document doc, Element parent,
                                  String tag, String value) {
        Element child = doc.createElement(tag);
        child.setTextContent(value);
        parent.appendChild(child);
    }
}
