/**
 * The type Palabra.
 */
/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *Clase palabra
 *
 **/
public class Palabra implements Comparable<Palabra> {

    private String PIngles;
    private String PEspanol;

    /**
     * Instantiates a new Palabra.
     *
     * @param PIngles  the p ingles
     * @param PEspanol the p espanol
     */
    public Palabra(String PIngles, String PEspanol) {

        this.PIngles = PIngles;
        this.PEspanol = PEspanol;
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

    @Override
    public int compareTo(Palabra palabra) {
        return PIngles.compareTo(palabra.getPIngles());
    }
}
