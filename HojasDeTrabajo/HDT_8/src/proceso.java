/*
Nelson García 22434
Joaquín Puente 22296
HDT 8
 */

public class proceso implements Comparable<proceso>{

    private String nombre;
    private int nice;
    private String nombre_usuario;
    private int prioridad;

    public proceso(String nombre, String nombre_usuario, int nice, int prioridad) {
        this.nombre = nombre;
        this.nice = nice;
        this.nombre_usuario = nombre_usuario;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNice() {
        return nice;
    }

    public void setNice(int nice) {
        this.nice = nice;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int compareTo(proceso o) {
        if (this.prioridad > o.prioridad) {
            return -1;
        }
        if (this.prioridad < o.prioridad) {
            return 1;
        }
        return 0;
    }

}
