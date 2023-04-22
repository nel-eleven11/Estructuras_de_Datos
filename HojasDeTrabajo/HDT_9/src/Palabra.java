/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *Clase palabra
 *
 **/
public class Palabra implements Comparable<Palabra> {

    private String PIngles;
    private String PEspanol;

    public Palabra(String PIngles, String PEspanol) {

        this.PIngles = PIngles;
        this.PEspanol = PEspanol;
    }


    public String getPIngles() {
        return PIngles;
    }

    public void setPIngles(String PIngles) {
        this.PIngles = PIngles;
    }

    public String getPEspanol() {
        return PEspanol;
    }

    public void setPEspanol(String PEspanol) {
        this.PEspanol = PEspanol;
    }

    @Override
    public int compareTo(Palabra palabra) {
        return PIngles.compareTo(palabra.getPIngles());
    }
}
