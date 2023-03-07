/*
Nelson García 22434
HDT 6
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
public class Controlador {

    private ArrayList<String> items = new ArrayList<String>();
    Factory_Map factory = new Factory_Map();
    ArrayList<String> producto2 = new ArrayList<String>();
    ArrayList<String> categoria = new ArrayList<String>();

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

    public ArrayList<String> getItems() {
        return items;
    }

    public void cargarProductos(ArrayList<String> productos, int tipoDeMapa) {


        Map<String, Map<String, Integer>> map = factory.getMap(tipoDeMapa);

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

        for (int i = 0; i < productos.size(); i++) {
            System.out.println(categoria.get(i) +" "+producto2.get(i)+" "+map.get(categoria.get(i)).get(producto2.get(i)));
        }

    }

    public void agregarProducto(int categoria, int producto, int cantidad){

    }

    public void mostrarProductos(int categoria){

    }

    public void mostrarCategorias(int nomProducto){

    }


}
