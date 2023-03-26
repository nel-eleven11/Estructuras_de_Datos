/*
Nelson García
22434
hdt 7
 */
public class Palabra {

    private String Palabra;
    private String PIngles;
    private String PFrances;
    private String PEspanol;

    public Palabra(String Palabra, String PIngles, String PEspanol, String PFrances) {
        this.Palabra = Palabra;
        this.PIngles = PIngles;
        this.PFrances = PFrances;
        this.PEspanol = PEspanol;
    }

    public String getPEspanol() {
        return PEspanol;
    }

    public void setPEspanol(String PEspanol) {
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

    public String getPFrances() {
        return PFrances;
    }

    public void setPFrances(String PFrances) {
        this.PFrances = PFrances;
    }
}
