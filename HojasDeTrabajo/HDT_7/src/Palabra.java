/*
Nelson García
22434
hdt 7
 */

/**
 * The type Palabra.
 * Clase Palabra
 */


public class Palabra {

    private String Palabra;
    private String PIngles;
    private String PFrances;
    private String PEspanol;

    /**
     * Instantiates a new Palabra.
     * Constructor de la clase
     *
     * @param Palabra  the palabra
     * @param PIngles  the p ingles
     * @param PEspanol the p espanol
     * @param PFrances the p frances
     */
    public Palabra(String Palabra, String PIngles, String PEspanol, String PFrances) {
        this.Palabra = Palabra;
        this.PIngles = PIngles;
        this.PFrances = PFrances;
        this.PEspanol = PEspanol;
    }

    /**
     * Gets p espanol.
     *
     * @return the p espanol
     */
    public String getPEspanol() {
        return PEspanol;
    }

    /**
     * Sets p espanol.
     *
     * @param PEspanol the p espanol
     */
    public void setPEspanol(String PEspanol) {
        this.PEspanol = PEspanol;
    }

    /**
     * Gets palabra.
     *
     * @return the palabra
     */
    public String getPalabra() {
        return Palabra;
    }

    /**
     * Sets palabra.
     *
     * @param palabra the palabra
     */
    public void setPalabra(String palabra) {
        Palabra = palabra;
    }

    /**
     * Gets p ingles.
     *
     * @return the p ingles
     */
    public String getPIngles() {
        return PIngles;
    }

    /**
     * Sets p ingles.
     *
     * @param PIngles the p ingles
     */
    public void setPIngles(String PIngles) {
        this.PIngles = PIngles;
    }

    /**
     * Gets p frances.
     *
     * @return the p frances
     */
    public String getPFrances() {
        return PFrances;
    }

    /**
     * Sets p frances.
     *
     * @param PFrances the p frances
     */
    public void setPFrances(String PFrances) {
        this.PFrances = PFrances;
    }
}
