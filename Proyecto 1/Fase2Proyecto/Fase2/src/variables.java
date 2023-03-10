/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.HashMap;
import java.util.HashSet;

public class  variables{
    private HashMap<String, Object> variables = new HashMap<String, Object>();

    public void addVariable(String name, Object value){
        variables.put(name, value);
    }

    public Object getVariable(String name){
        return variables.get(name);
    }

    private HashMap<String, Object> constants= new HashMap<String, Object>();

    public void addConstant(String name, Object value){
        constants.put(name, value);
    }

    public Object getConstant(String name){
        return constants.get(name);
    }

}
