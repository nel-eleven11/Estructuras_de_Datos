/*
Nelson García 22434
HDT 6
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
public class Controlador {

    private File archivo;
    private ArrayList<String> items = new ArrayList<String>();
    Factory_Map factory = new Factory_Map();
    ArrayList<String> producto2 = new ArrayList<String>();
    ArrayList<String> categoria = new ArrayList<String>();
    ArrayList<Integer> totalPro = new ArrayList<Integer>();

    Map<String, Map<String, Integer>> map;

    public void importFile(String nombreDelArchivo){
        //Ruta del archivo
        String fpath = ".\\src\\"+nombreDelArchivo+".txt";

        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                items.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writFile(String linea,String nombreDelArchivo){
        archivo = new File(nombreDelArchivo);
        try {
            FileWriter miEscritor = new FileWriter(archivo);
            miEscritor.write(linea);
            miEscritor.close();
        } catch (IOException e) {
            // Ocurrió un error en la escritura
            e.printStackTrace();
        }

    }

    public ArrayList<String> getItems() {
        return items;
    }

    public Map<String, Map<String, Integer>> cargarProductos(ArrayList<String> productos, int tipoDeMapa) {


        map = factory.getMap(tipoDeMapa);

        Map<String, Integer> desproducto = factory.getMap(tipoDeMapa);


        for (int i = 0; i < productos.size(); i++) {
            String[] producto = productos.get(i).split("\\|");
            categoria.add(producto[0]);
            producto2.add(producto[1]);
            desproducto.put(producto2.get(i), 1);

        }

        for (int i = 0; i < productos.size(); i++) {

            map.put(categoria.get(i), desproducto);

        }
        /*
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(categoria.get(i) +" "+producto2.get(i)+" "+map.get(categoria.get(i)).get(producto2.get(i)));
        }*/
        return map;

    }

    public void agregarProducto(int categoria_, int producto_, int cantidad, int tipoDeMapa){

        map = cargarProductos(items, tipoDeMapa);
        String categoria2 = categoria.get(categoria_);
        String producto = producto2.get(producto_);
        map.get(categoria2).put(producto, cantidad);
        System.out.println("Agregado: "+categoria.get(categoria_)+producto2.get(producto_)+map.get(categoria2).get(producto));
        //escribir en el archivo
        String linea = categoria.get(categoria_)+" | "+producto2.get(producto_);
        writFile(linea, "ListadoProducto (2)");
    }
    public void mostrarProducto(String nomProducto, int tipoDeMapa){
        map = factory.getMap(tipoDeMapa);
        map = cargarProductos(items, tipoDeMapa);
        //System.out.println("Producto: "+map.get(categoria_)+" "+map.get(categoria_).get(producto2.get(categoria_)));


    }

    public void mostrarCategoria(String nomProducto, int tipoDeMapa){
        map = factory.getMap(tipoDeMapa);
        map = cargarProductos(items, tipoDeMapa);
        for(int i = 0; i < producto2.size(); i++){
            if(producto2.get(i).equals(nomProducto)){
                System.out.println("Categoría: "+categoria.get(i));
            }
        }


    }


}
