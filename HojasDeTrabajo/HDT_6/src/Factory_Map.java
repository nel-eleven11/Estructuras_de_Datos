/*
Nelson García 22434
HDT 6
 */

//Java Collection Framework
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Factory_Map {

    private Map<String, Map<String, Integer>> map = null;

    public Map getMap(int mapType){

        if(mapType == 1){
            return new HashMap();
        } else if(mapType == 2){
            return new TreeMap();
        } else if(mapType == 3){
            return new LinkedHashMap();
        }
        else{
            System.out.println("No se ha seleccionado un tipo de mapa válido");
        }
        return null;
    }
}
