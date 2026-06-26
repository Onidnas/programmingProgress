package servicio;

import modelo.Genero;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.*;

public class LectorConfigXML {

    private String        nombreSistema;
    private int           capacidadMaxima;
    private String        rutaDatos;
    private String        rutaExportacion;
    private List<Genero>  generos = new ArrayList<>();

    public void parsear(String ruta) {
        try {
            DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            DocumentBuilder        bld = fac.newDocumentBuilder();
            Document               doc = bld.parse(new File(ruta));
            doc.getDocumentElement().normalize();

            nombreSistema   = valor(doc, "nombre");
            capacidadMaxima = Integer.parseInt(valor(doc, "capacidadMaxima"));
            rutaDatos       = valor(doc, "rutaDatos");
            rutaExportacion = valor(doc, "rutaExportacion");

            NodeList nl = doc.getElementsByTagName("genero");
            for (int i = 0; i < nl.getLength(); i++) {
                Element el = (Element) nl.item(i);
                generos.add(new Genero(
                    Integer.parseInt(el.getAttribute("id")),
                    el.getTextContent().trim()
                ));
            }
            System.out.println("✔ Config cargada: " + nombreSistema);

        } catch (Exception e) {
            System.err.println("✘ Error al parsear XML: " + e.getMessage());
        }
    }

    private String valor(Document d, String tag) {
        return d.getElementsByTagName(tag).item(0)
                .getTextContent().trim();
    }

    public String       getNombreSistema()   { return nombreSistema; }
    public int          getCapacidadMaxima() { return capacidadMaxima; }
    public String       getRutaDatos()       { return rutaDatos; }
    public String       getRutaExportacion() { return rutaExportacion; }
    public List<Genero> getGeneros()         { return generos; }
}
