/*
 * HDT 10 Algorigmos y estructura de datos
 * Nelson García Bravatti 22434
 * Joaquín Puente  22296
 *
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Controladora test.
 */
class ControladoraTest {
    /**
     * Test get ruta mas corta.
     */
    @Test
    public void testGetRutaMasCorta() {
        // Creamos la instancia de la controladora.
        Controladora controladora = new Controladora();
    }

    /**
     * Gets ruta mas corta.
     */
    @Test
    void getRutaMasCorta() {
        Controladora controladora = new Controladora();

        List<String> ciudades = Arrays.asList("BuenosAires", "Lima", "Quito");

        ArrayList<String> rutaMasCorta = controladora.getRutaMasCorta("BuenosAires", "Quito");

        for (int i = 0; i < rutaMasCorta.size(); i++) {
            System.out.println(i + " " + rutaMasCorta.get(i));
        }

        assertEquals(3, rutaMasCorta.size());
        assertEquals("BuenosAires", rutaMasCorta.get(0));
        assertEquals("Lima", rutaMasCorta.get(1));
        assertEquals("Quito", rutaMasCorta.get(2));
    }

    /**
     * Get centro del grafo.
     */
    @Test
    void getCentroDelGrafo(){
        Controladora controladora = new Controladora();

        String centroDelGrafo = controladora.getCentroDelGrafo();

        assertEquals("Lima", centroDelGrafo);
    }

    /**
     * Modificaciones.
     */
    @Test
    void modificaciones(){
        Controladora controladora = new Controladora();
        String linea = "";
        boolean existe = false;

        linea = "Quito SaoPaulo 10 20 30 40";
        existe = false;
        controladora.modificarArchivo(2, linea, "");
        for(int i = 0; i < controladora.logistica.size(); i++){
            if(controladora.logistica.get(i).contains(linea)){
                existe = true;
            }
        }
        assertEquals(true, existe);

        linea = "Quito SaoPaulo";
        existe = false;
        controladora.modificarArchivo(3, linea, "2");
        for(int i = 0; i < controladora.logistica.size(); i++){
            if(controladora.logistica.get(i).contains(linea)){
                String [] datos = controladora.logistica.get(i).split(" ");
                if(datos[2].equals(datos[3])){
                    existe = true;
                }
            }
        }
        assertEquals(true, existe);

        linea = "Quito SaoPaulo";
        controladora.modificarArchivo(1, linea, "");
        existe = false;
        for(int i = 0; i < controladora.logistica.size(); i++){
            if(controladora.logistica.get(i).contains(linea)){
                existe = true;
            }
        }
        assertEquals(false, existe);
    }
}