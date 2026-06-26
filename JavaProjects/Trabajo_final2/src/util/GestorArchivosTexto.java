package util;

import modelo.Libro;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GestorArchivosTexto {

    public static void generarReporte(
            String ruta, List<Libro> libros,
            String sistema) {

        new File(ruta).getParentFile().mkdirs();
        String sep  = "═".repeat(62);
        String hora = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        try (BufferedWriter bw =
                new BufferedWriter(new FileWriter(ruta))) {

            bw.write(sep); bw.newLine();
            bw.write("  REPORTE DE CATÁLOGO — " + sistema.toUpperCase());
            bw.newLine();
            bw.write("  Generado: " + hora); bw.newLine();
            bw.write(sep); bw.newLine();

            if (libros.isEmpty()) {
                bw.write("  Sin libros registrados."); bw.newLine();
            } else {
                for (Libro l : libros) {
                    bw.write("  • " + l); bw.newLine();
                }
            }

            bw.write(sep); bw.newLine();
            double total = libros.stream()
                .mapToDouble(Libro::getPrecio).sum();
            bw.write(String.format(
                "  Total libros: %d | Valor catálogo: $%.2f%n",
                libros.size(), total));
            bw.write(sep); bw.newLine();

            System.out.println("✔ Reporte TXT generado → " + ruta);

        } catch (IOException e) {
            System.err.println("✘ Error al escribir reporte: " + e.getMessage());
        }
    }
}
