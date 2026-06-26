package util;

import modelo.Libro;
import java.io.*;
import java.util.*;

public class GestorSerializacion {

    /** Serializa la lista de libros en un archivo binario .ser */
    public static void guardar(List<Libro> libros, String ruta) {
        new File(ruta).getParentFile().mkdirs();
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(libros);
            System.out.println("✔ Catálogo serializado → " + ruta);
        } catch (IOException e) {
            System.err.println("✘ Error al guardar: " + e.getMessage());
        }
    }

    /** Deserializa y devuelve la lista; lista vacía si no existe el archivo */
    @SuppressWarnings("unchecked")
    public static List<Libro> cargar(String ruta) {
        File f = new File(ruta);
        if (!f.exists()) {
            System.out.println("ℹ Sin datos previos. Catálogo nuevo.");
            return new ArrayList<>();
        }
        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(f))) {
            List<Libro> lista = (List<Libro>) ois.readObject();
            System.out.println("✔ Cargados: " + lista.size() + " libros.");
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✘ Error al deserializar: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
