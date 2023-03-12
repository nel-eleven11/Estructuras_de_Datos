/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.HashMap;

public class  variables{
    private final HashMap<String, Object> variables = new HashMap<String, Object>();

    public void addVariable(String name, Object value){
        try {
            if (isValidRegex(name)) {
                variables.put(name, value);
            } else {
                throw new Exception("Invalid variable name");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Object getVariable(String name){
        return variables.get(name);
    }

    private final HashMap<String, Object> constants= new HashMap<String, Object>();

    public void addConstant(String name, Object value){
        try {
            if (isValidRegex(name)) {
                if (!variables.containsKey(name)) {
                    constants.put(name, value);
                } else {
                    throw new Exception("Constant already exists");
                }
            } else {
                throw new Exception("Invalid constant name");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Object getConstant(String name){
        return constants.get(name);
    }

    private boolean isValidRegex(String name){
        return name.matches("[a-zA-Z]+");
    }

}
