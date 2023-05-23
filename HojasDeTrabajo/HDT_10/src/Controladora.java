import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * The type Controladora.
 */
public class Controladora {
    private Map<String, Node> ciudades = new HashMap<>();
    private String[] nombresCiudades;
    private Map<String, Integer> indicesCiudades = new HashMap<>();
    private FloydWarshall floydWarshall;

    /**
     * The Logistica.
     */
    ArrayList<String> logistica = new ArrayList<>();

    /**
     * Instantiates a new Controladora.
     */
    public Controladora() {
        leerArchivo();
        crearFloydWarshall();
    }

    /**
     * Gets floyd warshall.
     *
     * @return the floyd warshall
     */
    public FloydWarshall getFloydWarshall() {
        return floydWarshall;
    }

    /**
     * Modificar archivo.
     *
     * @param opcion the opcion
     * @param linea  the linea
     * @param clima  the clima
     */
    public void modificarArchivo(int opcion , String linea, String clima){

        if(opcion == 1){
            //se interrumpe una conexion entre dos ciudades
            for(int i = 0; i < logistica.size(); i++){
                if(logistica.get(i).contains(linea)){
                    logistica.remove(i);
                }
            }
        }
        if(opcion == 2){
            //se agrega una conexion entre dos ciudades
            logistica.add(linea);
        }
        if(opcion == 3){
            //se cambia el clima de una ciudad
            for(int i = 0; i < logistica.size(); i++){
                if(logistica.get(i).contains(linea)){
                    String [] datos = logistica.get(i).split(" ");
                    switch (clima){
                        case "1":
                            datos[2] = datos[2];
                            break;
                        case "2":
                            datos[2] = datos[3];
                            break;
                        case "3":
                            datos[2] = datos[4];
                            break;
                        case "4":
                            datos[2] = datos[5];
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "El clima ingresado no es valido");
                            break;
                    }
                    logistica.set(i, datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3] + " " + datos[4] + " " + datos[5]);
                }
            }

        }
        File archivo = new File(".\\src\\logistica.txt");
        //escribir en el archivo
        try {
            FileWriter miEscritor = new FileWriter(archivo);
            for (int i = 0; i < logistica.size(); i++) {
                miEscritor.write(logistica.get(i) + "\n");
            }
            miEscritor.close();
        } catch (IOException e) {
            // Ocurrió un error en la escritura
            e.printStackTrace();
        }
    }

    /**
     * Leer archivo.
     */
    public void leerArchivo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\src\\logistica.txt"));

            String linea;
            while ((linea = reader.readLine()) != null) {
                logistica.add(linea);
                String[] datos = linea.split(" ");

                // Verificamos si los datos son correctos y completos
                if (datos.length != 6) {
                    System.out.println("Línea con formato incorrecto: " + linea);
                    continue; // Ignoramos esta línea y pasamos a la siguiente
                }

                String ciudadOrigenNombre = datos[0];
                String ciudadDestinoNombre = datos[1];

                Integer[] tiempos = new Integer[4];
                for (int i = 0; i < 4; i++) {
                    tiempos[i] = Integer.parseInt(datos[i + 2]);
                }

                Node ciudadOrigen = ciudades.getOrDefault(ciudadOrigenNombre, new Node(ciudadOrigenNombre));
                ciudadOrigen.addDistance(ciudadDestinoNombre, tiempos);
                ciudades.putIfAbsent(ciudadOrigenNombre, ciudadOrigen);

                Node ciudadDestino = ciudades.getOrDefault(ciudadDestinoNombre, new Node(ciudadDestinoNombre));
                ciudadDestino.addDistance(ciudadOrigenNombre, tiempos);  // Asume que el tiempo de regreso es el mismo
                ciudades.putIfAbsent(ciudadDestinoNombre, ciudadDestino);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto");
            e.printStackTrace();
        }
    }
    private void crearFloydWarshall() {
        int n = ciudades.size();
        // se inicializan las matrices
        int[][] distancias = new int[n][n];
        String[][] recorridos = new String[n][n];

        //se llenan las matrices
        for (int i = 0; i < n; i++) {
            Arrays.fill(distancias[i], Integer.MAX_VALUE);
            distancias[i][i] = 0;
            Arrays.fill(recorridos[i], "-");
        }

        nombresCiudades = new String[n];
        for (int i = 0; i < n; i++) {
            nombresCiudades[i] = (String) ciudades.keySet().toArray()[i];
            indicesCiudades.put(nombresCiudades[i], i);
        }

        //se crea la matriz de recorridos
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i != j && recorridos[i][j].equals("-")) {
                    recorridos[i][j] = nombresCiudades[j];
                }
            }
        }


        //se crea la matriz de distancias
        for (Node ciudad : ciudades.values()) {
            for (Map.Entry<String, Integer[]> entry : ciudad.getTiemposViaje().entrySet()) {
                int origen = getIndiceCiudadPorNombre(ciudad.getNombre());
                int destino = getIndiceCiudadPorNombre(entry.getKey());
                if (origen != -1 && destino != -1) { // Para asegurarnos de que origen y destino existen
                    distancias[origen][destino] = entry.getValue()[0];
                }
            }
        }

        this.floydWarshall = new FloydWarshall(distancias, recorridos, n, nombresCiudades);

        floydWarshall.CalcularRutas();

        recorridos = floydWarshall.getRecorridos();
        distancias = floydWarshall.getDistancias();

    }

    /**
     * Gets indice ciudad por nombre.
     *
     * @param nombre the nombre
     * @return the indice ciudad por nombre
     */
    public Integer getIndiceCiudadPorNombre(String nombre) {
        Integer indice = indicesCiudades.get(nombre);
        if (indice == null) {
            System.out.println("No se encontró el índice para la ciudad: " + nombre);
            return -1; // o algún otro valor de error
        } else {
            return indice;
        }
    }

    /**
     * Gets nombre ciudad por indice.
     *
     * @param indice the indice
     * @return the nombre ciudad por indice
     */
    public String getNombreCiudadPorIndice(int indice) {
        return nombresCiudades[indice];
    }

    /**
     * Gets ruta mas corta.
     *
     * @param ciudadSalida  the ciudad salida
     * @param ciudadDestino the ciudad destino
     * @return the ruta mas corta
     */
    public ArrayList<String> getRutaMasCorta(String ciudadSalida, String ciudadDestino) {
        int indiceOrigen = getIndiceCiudadPorNombre(ciudadSalida);
        int indiceDestino = getIndiceCiudadPorNombre(ciudadDestino);

        if (indiceOrigen == -1 || indiceDestino == -1) {
            return null;
        }
        String[][] recorridos = floydWarshall.getRecorridos();

        ArrayList<String> ruta = new ArrayList<>();

        if (recorridos[indiceDestino][indiceOrigen].equals("-")) {
            ruta.add(ciudadSalida);
            ruta.add(ciudadDestino);
            return ruta;
        } else if (!recorridos[indiceDestino][indiceOrigen].equals(ciudadSalida)) {
            ruta.addAll(getRutaMasCorta(ciudadSalida, recorridos[indiceDestino][indiceOrigen]));
            ruta.add(ciudadDestino);
        } else {
            ruta.add(ciudadSalida);
            ruta.add(ciudadDestino);
        }

        return ruta;
    }

    /**
     * Gets centro del grafo.
     *
     * @return the centro del grafo
     */
    public String getCentroDelGrafo() {
        int[][] distancias = floydWarshall.getDistancias();

        int minMaxDistancia = Integer.MAX_VALUE;
        String centro = null;

        for (String ciudad : ciudades.keySet()) {
            int indiceCiudad = getIndiceCiudadPorNombre(ciudad);

            int maxDistancia = Integer.MIN_VALUE;

            for (int i = 0; i < distancias[indiceCiudad].length; i++) {
                if (i != indiceCiudad) {
                    maxDistancia = Math.max(maxDistancia, distancias[indiceCiudad][i]);
                }
            }

            if (maxDistancia < minMaxDistancia) {
                minMaxDistancia = maxDistancia;
                centro = ciudad;
            }
        }

        return centro;
    }


}
