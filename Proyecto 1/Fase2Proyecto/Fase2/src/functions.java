import java.util.HashMap;


public class functions {

    private final HashMap<String, Object> functions = new HashMap<String, Object>();

    public void addFunction(String name, Object value){
        functions.put(name, value);
    }

    public Object getFunction(String name){
        return functions.get(name);
    }




}
