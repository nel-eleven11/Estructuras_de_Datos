import java.io.*;
import java.util.*;

public class Controladora {
    private Map<String, Node> ciudades = new HashMap<>();
    private String[] nombresCiudades;
    private Map<String, Integer> indicesCiudades = new HashMap<>();
    private FloydWarshall floydWarshall;

    public Controladora() {
        leerArchivo();
        crearFloydWarshall();
    }

    public FloydWarshall getFloydWarshall() {
        return floydWarshall;
    }

    public void leerArchivo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\src\\logistica.txt"));

            String linea;
            while ((linea = reader.readLine()) != null) {
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
        int[][] distancias = new int[n][n];
        String[][] recorridos = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distancias[i], Integer.MAX_VALUE);
            distancias[i][i] = 0;
        }

        nombresCiudades = new String[n];
        for (int i = 0; i < n; i++) {
            nombresCiudades[i] = (String) ciudades.keySet().toArray()[i];
            indicesCiudades.put(nombresCiudades[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    recorridos[i][j] = nombresCiudades[i];
                } else {
                    recorridos[i][j] = "-";
                }
            }
        }

        for (Node ciudad : ciudades.values()) {
            for (Map.Entry<String, Integer[]> entry : ciudad.getTiemposViaje().entrySet()) {
                int origen = getIndiceCiudadPorNombre(ciudad.getNombre());
                int destino = getIndiceCiudadPorNombre(entry.getKey());
                if (origen != -1 && destino != -1) { // Para asegurarnos de que origen y destino existen
                    distancias[origen][destino] = entry.getValue()[0];
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(distancias[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(recorridos[i][j] + "");
            }
            System.out.println();
        }

        this.floydWarshall = new FloydWarshall(distancias, recorridos, n);

        //Calcular la ruta más corta entre dos ciudades
        floydWarshall.CalcularRutas();

        recorridos = floydWarshall.getRecorridos();
        distancias = floydWarshall.getDistancias();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(distancias[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(recorridos[i][j] + "");
            }
            System.out.println();
        }
    }

    public Integer getIndiceCiudadPorNombre(String nombre) {
        Integer indice = indicesCiudades.get(nombre);
        if (indice == null) {
            System.out.println("No se encontró el índice para la ciudad: " + nombre);
            return -1; // o algún otro valor de error
        } else {
            return indice;
        }
    }

    public String getNombreCiudadPorIndice(int indice) {
        return nombresCiudades[indice];
    }
}
