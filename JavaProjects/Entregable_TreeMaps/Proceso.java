// ============================================================
//  Clase Proceso — Modela un proceso del sistema operativo
// ============================================================
public class Proceso {

    private int    id;           // Identificador único del proceso
    private String nombre;       // Nombre descriptivo
    private int    prioridad;    // Nivel de prioridad (1 = más alta)
    private int    tiempoRafaga; // Tiempo de CPU requerido (ms)
    private String estado;       // LISTO, EJECUTANDO, TERMINADO

    // Constructor principal
    public Proceso(int id, String nombre, int prioridad, int tiempoRafaga) {
        this.id           = id;
        this.nombre       = nombre;
        this.prioridad    = prioridad;
        this.tiempoRafaga = tiempoRafaga;
        this.estado       = "LISTO";
    }

    // Getters
    public int    getId()           { return id; }
    public String getNombre()       { return nombre; }
    public int    getPrioridad()    { return prioridad; }
    public int    getTiempoRafaga() { return tiempoRafaga; }
    public String getEstado()       { return estado; }

    // Setter de estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Representación en texto
    @Override
    public String toString() {
        return String.format(
            "[PID:%d | %-18s | Prioridad:%-2d | Ráfaga:%3dms | %s]",
            id, nombre, prioridad, tiempoRafaga, estado
        );
    }
}
