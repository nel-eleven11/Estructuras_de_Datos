/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * The type Controladora 2.
 */
public class controladora2 {

    private static PriorityQueue<proceso> _colaPrioridad = new PriorityQueue<>();

    /**
     * Build queue.
     *
     * @param procesos the procesos
     */
    public static void buildQueue(ArrayList<proceso> procesos) {
        _colaPrioridad.addAll(procesos);
    }

    /**
     * Gets proceso.
     *
     * @return the proceso
     */
    public static proceso getProceso() {
        return _colaPrioridad.poll();
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public static boolean isEmpty() {
        return _colaPrioridad.isEmpty();
    }
}
