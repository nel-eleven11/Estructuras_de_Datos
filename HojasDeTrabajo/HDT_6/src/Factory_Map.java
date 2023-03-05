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

public class Factory_Map<T> {

    private Map<String, T> map = null;

    public Map<String, T> getMap(String mapType){
        if(mapType == null){
            return null;
        }
        if(mapType.equalsIgnoreCase("HashMap")){
            return new HashMap<String, T>();
        } else if(mapType.equalsIgnoreCase("TreeMap")){
            return new TreeMap<String, T>();
        } else if(mapType.equalsIgnoreCase("LinkedHashMap")){
            return new LinkedHashMap<String, T>();
        }
        return null;
    }
}
