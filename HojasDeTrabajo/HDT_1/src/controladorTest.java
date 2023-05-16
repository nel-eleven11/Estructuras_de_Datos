package src;
/*
 * HDT 1 Algorigmos y estructura de datos
 * Nelson García Bravatti
 * Joaquín Puente
 * Oscar Fuentes
 * Clase controladorTest
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class controladorTest {

    @Test
    void turnOnOff() {

        controlador controlador = new controlador();
        controlador.turnOnOff();
        assertTrue(controlador.radio.isOn());
        controlador.turnOnOff();
        assertFalse(controlador.radio.isOn());
    }

    @Test
    void changeFrequence() {
        controlador controlador = new controlador();
        try {
            controlador.changeFrequence();
            assertEquals("FM", controlador.radio.getFrequence());
            controlador.changeFrequence();
            assertEquals("AM", controlador.radio.getFrequence());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * @throws Exception
     */
    @Test
    void forward() throws Exception {
        controlador controlador = new controlador();
        controlador.forward();
        assertEquals(540, controlador.radio.getAMActualStation());
        controlador.forward();
        assertEquals(550, controlador.radio.getAMActualStation());

        controlador.changeFrequence();
        controlador.forward();
        assertEquals(88.1, controlador.radio.getFMActualStation());
        controlador.forward();
        assertEquals(88.3, controlador.radio.getFMActualStation());

    }

    
    /** 
     * @throws Exception
     */
    @Test
    void backward() throws Exception {
        controlador controlador = new controlador();
        controlador.backward();
        assertEquals(1610, controlador.radio.getAMActualStation());
        controlador.backward();
        assertEquals(1600, controlador.radio.getAMActualStation());

        controlador.changeFrequence();
        controlador.backward();
        assertEquals(107.9, controlador.radio.getFMActualStation());
        controlador.backward();
        assertEquals(107.7, controlador.radio.getFMActualStation());


    }

    
    /** 
     * @throws Exception
     */
    @Test
    void saveStation() throws Exception {
        controlador controlador = new controlador();
        controlador.saveStation(1);
        assertEquals(530, controlador.radio.getAMSlot(1));

        controlador.forward();
        controlador.forward();
        controlador.saveStation(2);
        assertEquals(550, controlador.radio.getAMSlot(2));

        controlador.changeFrequence();
        controlador.saveStation(1);
        assertEquals(87.9, controlador.radio.getFMSlot(1));

        controlador.forward();
        controlador.forward();
        controlador.saveStation(2);
        assertEquals(88.3, controlador.radio.getFMSlot(2));
    }

    
    /** 
     * @throws Exception
     */
    @Test
    void selectFavoriteSation() throws Exception {
        controlador controlador = new controlador();
        controlador.saveStation(1);

        controlador.forward();
        controlador.forward();
        controlador.saveStation(2);

        controlador.forward();
        controlador.forward();

        assertEquals(570, controlador.radio.getAMActualStation());

        controlador.selectFavoriteSation(1);
        assertEquals(530, controlador.radio.getAMActualStation());

        controlador.selectFavoriteSation(2);
        assertEquals(550, controlador.radio.getAMActualStation());

    }
}