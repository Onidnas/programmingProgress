import modelo.Libro;
import servicio.LectorConfigXML;
import util.GestorSerializacion;
import util.GestorArchivosTexto;
import util.EscritorXML;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("═══════════════════════════════════");
        System.out.println("   BIBLIOTECA DIGITAL — INICIO     ");
        System.out.println("═══════════════════════════════════\n");

        // 1) Leer configuración desde XML
        LectorConfigXML cfg = new LectorConfigXML();
        cfg.parsear("recursos/config.xml");

        System.out.println("Sistema : "   + cfg.getNombreSistema());
        System.out.println("Capacidad: "  + cfg.getCapacidadMaxima());
        System.out.println("Géneros: "    + cfg.getGeneros());

        // 2) Deserializar catálogo existente
        List<Libro> libros = GestorSerializacion.cargar(cfg.getRutaDatos());

        // 3) Agregar libros de prueba
        libros.add(new Libro("978-1", "Dune",
            "Frank Herbert", "Ciencia Ficción", 280.00, 5));
        libros.add(new Libro("978-2", "Clean Code",
            "Robert C. Martin", "Tecnología", 450.50, 3));
        libros.add(new Libro("978-3", "El nombre del viento",
            "Patrick Rothfuss", "Novela", 310.00, 8));

        // --- Actividad 4: Búsqueda interactiva con Scanner ---
        Scanner sc = new Scanner(System.in);

        System.out.println("\n─────────────────────────────────────");
        System.out.println("  BÚSQUEDA / ELIMINACIÓN DE LIBROS   ");
        System.out.println("─────────────────────────────────────");
        System.out.print("Ingresa un ISBN para buscar (o ENTER para omitir): ");
        String isbn = sc.nextLine().trim();

        if (!isbn.isEmpty()) {
            // Buscar libro por ISBN usando Stream
            Libro encontrado = libros.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

            if (encontrado != null) {
                System.out.println("✔ Libro encontrado:");
                System.out.println("  " + encontrado);
                System.out.print("¿Deseas eliminarlo? (s/n): ");
                String respuesta = sc.nextLine().trim();

                if (respuesta.equalsIgnoreCase("s")) {
                    libros.removeIf(l -> l.getIsbn().equals(isbn));
                    System.out.println("✔ Libro eliminado del catálogo.");
                } else {
                    System.out.println("ℹ Libro conservado en el catálogo.");
                }
            } else {
                System.out.println("✘ No se encontró ningún libro con ISBN: " + isbn);
            }
        } else {
            System.out.println("ℹ Búsqueda omitida.");
        }

        sc.close();

        // 4) Serializar catálogo actualizado
        GestorSerializacion.guardar(libros, cfg.getRutaDatos());

        // 5) Generar reporte TXT
        GestorArchivosTexto.generarReporte(
            cfg.getRutaExportacion() + "reporte.txt",
            libros, cfg.getNombreSistema());

        // 6) Exportar catálogo a XML  ← IMPLEMENTACIÓN DE EscritorXML
        EscritorXML.exportar(
            cfg.getRutaExportacion() + "inventario.xml",
            libros,
            cfg.getNombreSistema());

        System.out.println("\n✔ Sistema finalizado correctamente.");
    }
}
