/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<proceso> procesos = new ArrayList<>();

        files.importFile();

        for (int i = 0; i < files.getItems().size(); i++) {
            String nombre = files.getItems().get(i).get(0);
            String nombre_usuario = files.getItems().get(i).get(1);
            int nice = Integer.parseInt(files.getItems().get(i).get(2));
            int prioridad = Integer.parseInt(files.getItems().get(i).get(3));

            procesos.add(new proceso(nombre, nombre_usuario, nice, prioridad));
        }

        System.out.println("VectorHeap");
        controladora.buildQueue(procesos);
        while (!controladora.isEmpty()) {
            proceso proceso = controladora.getProcesos();
            System.out.println(proceso.getNombre() + ", " + proceso.getNombre_usuario() + ", " + proceso.getNice() + ", PR=" + proceso.getPrioridad());
        }

        System.out.println("\nPriorityQueue");
        controladora2.buildQueue(procesos);
        while (!controladora2.isEmpty()) {
            proceso proceso = controladora2.getProceso();
            System.out.println(proceso.getNombre() + ", " + proceso.getNombre_usuario() + ", " + proceso.getNice() + ", PR=" + proceso.getPrioridad());
        }






    }
}
