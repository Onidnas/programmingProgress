import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EjemploDOM {
    public static void main(String[] args) throws Exception {
        // ① Crear el DocumentBuilder (factory pattern)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);  // Soporte de namespaces
        DocumentBuilder builder = factory.newDocumentBuilder();

        // ② Parsear el archivo XML → árbol DOM en memoria
        Document doc = builder.parse(new File("datos.xml"));

        // ③ Normalizar el árbol (combinar nodos de texto fragmentados)
        doc.getDocumentElement().normalize();

        // ④ Acceder al elemento raíz
        Element root = doc.getDocumentElement();
        System.out.println("Elemento raíz: " + root.getNodeName());

        // ⑤ Obtener lista de nodos hijos
        NodeList productos = doc.getElementsByTagName("producto");

        for (int i = 0; i < productos.getLength(); i++) {
            Node nodo = productos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nodo;
                // Leer atributo e hijos
                System.out.println("ID: " + elem.getAttribute("id"));
                System.out.println("Nombre: " + elem.getElementsByTagName("nombre")
                    .item(0).getTextContent());
            }
        }

        // ⑥ Modificar el documento — añadir un nuevo elemento
        Element nuevoProducto = doc.createElement("producto");
        nuevoProducto.setAttribute("id", "P999");
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent("Nuevo Producto");
        nuevoProducto.appendChild(nombre);
        root.appendChild(nuevoProducto);

        // ⑦ Guardar el documento modificado
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(doc), new StreamResult(new File("salida.xml")));
        System.out.println("Archivo XML guardado correctamente.");
    }
}
