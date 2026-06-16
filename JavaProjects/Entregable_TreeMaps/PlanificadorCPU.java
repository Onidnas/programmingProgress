import java.util.TreeMap;
import java.util.Map;

// ============================================================
//  PlanificadorCPU — Gestiona procesos con TreeMap
//  La CLAVE del TreeMap es el nivel de prioridad (int).
//  TreeMap mantiene las claves ORDENADAS de menor a mayor.
//  → firstKey() siempre devuelve el proceso MÁS prioritario.
// ============================================================
public class PlanificadorCPU {

    // TreeMap<Prioridad, Proceso>
    // Clave: nivel de prioridad (1 = más alta prioridad)
    // Valor: objeto Proceso asociado a esa prioridad
    private TreeMap<Integer, Proceso> colaProcesos;

    // Constructor
    public PlanificadorCPU() {
        // TreeMap sin comparador = orden natural ascendente
        // → firstKey() = prioridad mínima = proceso más importante
        colaProcesos = new TreeMap<>();
    }

    // ----------------------------------------------------------
    // agregarProceso: Inserta un proceso en el TreeMap.
    // Si ya existe un proceso con esa prioridad, se avisa.
    // Complejidad: O(log n)
    // ----------------------------------------------------------
    public void agregarProceso(Proceso p) {
        if (colaProcesos.containsKey(p.getPrioridad())) {
            System.out.println(
                "⚠ CONFLICTO: Ya existe un proceso con prioridad "
                + p.getPrioridad() + ". No se insertó: " + p.getNombre()
            );
            return;
        }
        colaProcesos.put(p.getPrioridad(), p);
        System.out.println("✔ Proceso agregado  → " + p);
    }

    // ----------------------------------------------------------
    // ejecutarSiguiente: Extrae y "ejecuta" el proceso con
    // mayor prioridad (firstKey = clave mínima del TreeMap).
    // Complejidad: O(log n)
    // ----------------------------------------------------------
    public Proceso ejecutarSiguiente() {
        if (colaProcesos.isEmpty()) {
            System.out.println("⚡ Cola vacía — No hay procesos para ejecutar.");
            return null;
        }

        // firstKey() → nodo más a la IZQUIERDA del árbol = prioridad más baja (más urgente)
        int      claveMasPrioritaria = colaProcesos.firstKey();
        Proceso procesoPrioritario   = colaProcesos.remove(claveMasPrioritaria);

        procesoPrioritario.setEstado("EJECUTANDO");
        System.out.println("\n🚀 EJECUTANDO → " + procesoPrioritario);

        // Simula tiempo de ejecución (en una implementación real usaría hilos)
        procesoPrioritario.setEstado("TERMINADO");
        System.out.println("✅ TERMINADO   → " + procesoPrioritario);

        return procesoPrioritario;
    }

    // ----------------------------------------------------------
    // mostrarCola: Imprime todos los procesos en el TreeMap
    // en orden de prioridad (menor clave = mayor prioridad).
    // ----------------------------------------------------------
    public void mostrarCola() {
        if (colaProcesos.isEmpty()) {
            System.out.println("  (Cola vacía)");
            return;
        }
        int posicion = 1;
        for (Map.Entry<Integer, Proceso> entrada : colaProcesos.entrySet()) {
            String marcador = (posicion == 1) ? " ◀ SIGUIENTE" : "";
            System.out.printf(
                "  [%d°] Prioridad %-2d → %s%s%n",
                posicion++, entrada.getKey(), entrada.getValue().getNombre(), marcador
            );
        }
    }

    // ----------------------------------------------------------
    // procesoPendientes: Cantidad de procesos en cola.
    // ----------------------------------------------------------
    public int procesosPendientes() {
        return colaProcesos.size();
    }

    // ----------------------------------------------------------
    // verProximoProceso: Consulta sin extraer.
    // ----------------------------------------------------------
    public Proceso verProximoProceso() {
        if (colaProcesos.isEmpty()) return null;
        return colaProcesos.get(colaProcesos.firstKey());
    }
}
