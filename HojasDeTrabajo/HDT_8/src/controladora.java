/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */

import java.util.ArrayList;

/**
 * The type Controladora.
 */
public class controladora {

    private static ArrayList<proceso> _procesos = new ArrayList<>();
    private static VectorHeap<proceso> _colaPrioridad = new VectorHeap<>();

    /**
     * Build queue.
     *
     * @param procesos the procesos
     */
    public static void buildQueue(ArrayList<proceso> procesos) {
        for (proceso proceso : procesos) {
            _colaPrioridad.add(proceso);
        }
    }

    /**
     * Gets procesos.
     *
     * @return the procesos
     */
    public static proceso getProcesos() {
        return _colaPrioridad.remove();
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public static boolean isEmpty() {
        return _colaPrioridad.isEmpty();
    }

    /**
     * Gets cola prioridad.
     *
     * @return the cola prioridad
     */
    public static VectorHeap<proceso> getColaPrioridad() {
        return _colaPrioridad;
    }

    /**
     * Sets cola prioridad.
     *
     * @param colaPrioridad the cola prioridad
     */
    public static void setColaPrioridad(VectorHeap<proceso> colaPrioridad) {
        _colaPrioridad = colaPrioridad;
    }

}
