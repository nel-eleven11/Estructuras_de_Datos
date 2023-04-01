import java.util.ArrayList;
import java.util.PriorityQueue;

public class controladora2 {

    private static PriorityQueue<proceso> _colaPrioridad = new PriorityQueue<>();

    public static void buildQueue(ArrayList<proceso> procesos) {
        _colaPrioridad.addAll(procesos);
    }

    public static proceso getProceso() {
        return _colaPrioridad.poll();
    }

    public static boolean isEmpty() {
        return _colaPrioridad.isEmpty();
    }
}
