import java.util.HashMap;
import java.util.Map;

/**
 * The type Node.
 */
public class Node {
    private String nombre;
    private Map<String, Integer[]> tiemposViaje;

    /**
     * Instantiates a new Node.
     *
     * @param nombre the nombre
     */
    public Node(String nombre) {
        this.nombre = nombre;
        this.tiemposViaje = new HashMap<>();
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Add distance.
     *
     * @param ciudadDestino the ciudad destino
     * @param tiempos       the tiempos
     */
    public void addDistance(String ciudadDestino, Integer[] tiempos) {
        this.tiemposViaje.put(ciudadDestino, tiempos);
    }

    /**
     * Gets tiempos viaje.
     *
     * @return the tiempos viaje
     */
    public Map<String, Integer[]> getTiemposViaje() {
        return this.tiemposViaje;
    }
}
