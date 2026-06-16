// ============================================================
//  Main — Simulación del Planificador de CPU con TreeMap
// ============================================================
public class Main {

    public static void main(String[] args) {

        separador("═", "PLANIFICADOR DE CPU — TreeMap Demo");

        // ─── 1. Crear el planificador ─────────────────────────────
        PlanificadorCPU planificador = new PlanificadorCPU();

        // ─── 2. Crear procesos del sistema ────────────────────────
        // Constructor: Proceso(id, nombre, prioridad, tiempoRafagaMs)
        Proceso p1 = new Proceso(101, "Controlador IRQ",   1,   5);
        Proceso p2 = new Proceso(102, "Gestor Memoria",    2,  12);
        Proceso p3 = new Proceso(103, "Daemon Red",        3,  20);
        Proceso p4 = new Proceso(104, "Navegador Web",     5,  80);
        Proceso p5 = new Proceso(105, "Editor Código",     4,  60);
        Proceso p6 = new Proceso(106, "Antivirus",         7, 120);
        Proceso p7 = new Proceso(107, "Actualizaciones",   9, 200);
        Proceso p8 = new Proceso(108, "Reproductor Audio", 6,  40);

        // ─── 3. Agregar procesos al planificador ──────────────────
        separador("-", "Cargando procesos en el TreeMap");
        planificador.agregarProceso(p4); // Se insertan en orden NO ordenado
        planificador.agregarProceso(p7); // TreeMap los reordena internamente
        planificador.agregarProceso(p2);
        planificador.agregarProceso(p5);
        planificador.agregarProceso(p1);
        planificador.agregarProceso(p6);
        planificador.agregarProceso(p3);
        planificador.agregarProceso(p8);

        // ─── 4. Mostrar estado inicial del TreeMap ────────────────
        separador("-", "Estado inicial del TreeMap (ordenado por prioridad)");
        planificador.mostrarCola();
        System.out.println("\n  Procesos pendientes: " + planificador.procesosPendientes());

        // ─── 5. Ver próximo sin ejecutar ─────────────────────────
        separador("-", "Consulta: ¿Cuál es el próximo proceso? (sin extraer)");
        Proceso proximo = planificador.verProximoProceso();
        System.out.println("  Próximo a ejecutar → " + proximo);

        // ─── 6. Ejecutar todos los procesos en orden ─────────────
        separador("-", "Ejecutando todos los procesos por prioridad");
        int turno = 1;
        while (planificador.procesosPendientes() > 0) {
            System.out.println("\n  ── Turno " + turno++ + " ──");
            planificador.ejecutarSiguiente();
            System.out.print("  Cola restante: ");
            planificador.mostrarCola();
        }

        // ─── 7. Intentar ejecutar con cola vacía ─────────────────
        separador("-", "Intento de ejecución con cola vacía");
        planificador.ejecutarSiguiente();

        separador("═", "Simulación finalizada");
    }

    // Utilidad para separadores visuales en consola
    private static void separador(String car, String titulo) {
        int total = 60;
        int pad   = (total - titulo.length() - 2) / 2;
        String linea = car.repeat(total);
        System.out.println("\n" + linea);
        System.out.println(car.repeat(pad) + " " + titulo + " " + car.repeat(pad));
        System.out.println(linea);
    }
}
