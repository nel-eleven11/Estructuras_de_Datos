/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */

import java.util.ArrayList;

public class controladora {

    private static ArrayList<proceso> _procesos = new ArrayList<>();
    private static VectorHeap<proceso> _colaPrioridad = new VectorHeap<>();

    public static void buildQueue(ArrayList<proceso> procesos) {
        for (proceso proceso : procesos) {
            _colaPrioridad.add(proceso);
        }
    }

    public static proceso getProcesos() {
        return _colaPrioridad.remove();
    }

    public static boolean isEmpty() {
        return _colaPrioridad.isEmpty();
    }

}
