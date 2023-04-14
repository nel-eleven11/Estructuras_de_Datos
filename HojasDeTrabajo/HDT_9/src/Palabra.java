/*
 * Hdt 9
 * Nelson García Bravatti 22434
 *Clase palabra
 *
 **/
public class Palabra {

    private String Palabra;
    private String PIngles;
    private String PEspanol;

    public Palabra(String Palabra, String PIngles, String PEspanol) {
        this.Palabra = Palabra;
        this.PIngles = PIngles;
        this.PEspanol = PEspanol;
    }

    public String getPalabra() {
        return Palabra;
    }

    public void setPalabra(String palabra) {
        Palabra = palabra;
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
}
