/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @Test
    void add() {
        controladora.getColaPrioridad().clear();
        ArrayList<proceso> procesos = new ArrayList<>();

        //Importar los procesos del txt
        files.importFile();

        //Crear los objetos procesos
        for (int i = 0; i < files.getItems().size(); i++) {
            String nombre = files.getItems().get(i).get(0);
            String nombre_usuario = files.getItems().get(i).get(1);
            int nice = Integer.parseInt(files.getItems().get(i).get(2));
            int prioridad = Integer.parseInt(files.getItems().get(i).get(3));

            procesos.add(new proceso(nombre, nombre_usuario, nice, prioridad));
        }

        controladora.buildQueue(procesos);
        assertEquals(4, controladora.getColaPrioridad().size());
    }

    @Test
    void remove() {
        controladora.getColaPrioridad().clear();
        ArrayList<proceso> procesos2 = new ArrayList<>();

        //Importar los procesos del txt
        files.importFile();

        //Crear los objetos procesos
        for (int i = 0; i < files.getItems().size(); i++) {
            String nombre = files.getItems().get(i).get(0);
            String nombre_usuario = files.getItems().get(i).get(1);
            int nice = Integer.parseInt(files.getItems().get(i).get(2));
            int prioridad = Integer.parseInt(files.getItems().get(i).get(3));

            procesos2.add(new proceso(nombre, nombre_usuario, nice, prioridad));
        }

        controladora.buildQueue(procesos2);
        assertEquals(4, controladora.getColaPrioridad().size());

        controladora.getProcesos();
        assertEquals(3, controladora.getColaPrioridad().size());
    }

    @Test
    void isEmpty() {
        controladora.getColaPrioridad().clear();
        ArrayList<proceso> procesos3 = new ArrayList<>();

        //Importar los procesos del txt
        files.importFile();

        //Crear los objetos procesos
        for (int i = 0; i < files.getItems().size(); i++) {
            String nombre = files.getItems().get(i).get(0);
            String nombre_usuario = files.getItems().get(i).get(1);
            int nice = Integer.parseInt(files.getItems().get(i).get(2));
            int prioridad = Integer.parseInt(files.getItems().get(i).get(3));

            procesos3.add(new proceso(nombre, nombre_usuario, nice, prioridad));
        }
        assertTrue(controladora.isEmpty());
        controladora.buildQueue(procesos3);
        assertFalse(controladora.isEmpty());
    }

    @Test
    void size() {
        controladora.getColaPrioridad().clear();
        ArrayList<proceso> procesos4 = new ArrayList<>();

        //Importar los procesos del txt
        files.importFile();

        //Crear los objetos procesos
        for (int i = 0; i < files.getItems().size(); i++) {
            String nombre = files.getItems().get(i).get(0);
            String nombre_usuario = files.getItems().get(i).get(1);
            int nice = Integer.parseInt(files.getItems().get(i).get(2));
            int prioridad = Integer.parseInt(files.getItems().get(i).get(3));

            procesos4.add(new proceso(nombre, nombre_usuario, nice, prioridad));
        }

        controladora.buildQueue(procesos4);
        assertEquals(4, controladora.getColaPrioridad().size());

        controladora.getProcesos();
        assertEquals(3, controladora.getColaPrioridad().size());

        controladora.getProcesos();
        assertEquals(2, controladora.getColaPrioridad().size());

        controladora.getProcesos();
        assertEquals(1, controladora.getColaPrioridad().size());

        controladora.getProcesos();
        assertEquals(0, controladora.getColaPrioridad().size());
    }

    @Test
    void clear() {
        controladora.getColaPrioridad().clear();
        ArrayList<proceso> procesos5 = new ArrayList<>();

        //Importar los procesos del txt
        files.importFile();

        //Crear los objetos procesos
        for (int i = 0; i < files.getItems().size(); i++) {
            String nombre = files.getItems().get(i).get(0);
            String nombre_usuario = files.getItems().get(i).get(1);
            int nice = Integer.parseInt(files.getItems().get(i).get(2));
            int prioridad = Integer.parseInt(files.getItems().get(i).get(3));

            procesos5.add(new proceso(nombre, nombre_usuario, nice, prioridad));
        }

        controladora.buildQueue(procesos5);
        assertEquals(4, controladora.getColaPrioridad().size());

        controladora.getColaPrioridad().clear();
        assertEquals(0, controladora.getColaPrioridad().size());

    }
}