/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */

/**
 * The type Proceso.
 */
public class proceso implements Comparable<proceso>{

    private String nombre;
    private int nice;
    private String nombre_usuario;
    private int prioridad;

    /**
     * Instantiates a new Proceso.
     *
     * @param nombre         the nombre
     * @param nombre_usuario the nombre usuario
     * @param nice           the nice
     * @param prioridad      the prioridad
     */
    public proceso(String nombre, String nombre_usuario, int nice, int prioridad) {
        this.nombre = nombre;
        this.nice = nice;
        this.nombre_usuario = nombre_usuario;
        this.prioridad = prioridad;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets nice.
     *
     * @return the nice
     */
    public int getNice() {
        return nice;
    }

    /**
     * Sets nice.
     *
     * @param nice the nice
     */
    public void setNice(int nice) {
        this.nice = nice;
    }

    /**
     * Gets nombre usuario.
     *
     * @return the nombre usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * Sets nombre usuario.
     *
     * @param nombre_usuario the nombre usuario
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * Gets prioridad.
     *
     * @return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Sets prioridad.
     *
     * @param prioridad the prioridad
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int compareTo(proceso o) {
        if (this.prioridad > o.prioridad) {
            return 1;
        }
        if (this.prioridad < o.prioridad) {
            return -1;
        }
        return 0;
    }

}
