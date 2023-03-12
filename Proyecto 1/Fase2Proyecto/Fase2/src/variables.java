/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.HashMap;

public class  variables{
    private static final HashMap<String, Object> variables = new HashMap<String, Object>();

    public static void addVariable(String name, Object value){
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

    public static Object getVariable(String name){
        try {
            if (!variables.containsKey(name)) {
                throw new Exception("Variable does not exist");
            } else {
                return variables.get(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static final HashMap<String, Object> constants= new HashMap<String, Object>();

    public static void addConstant(String name, Object value){
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

    public static Object getConstant(String name){
        try {
            if (!constants.containsKey(name)) {
                throw new Exception("Constant does not exist");
            } else {
                return constants.get(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static boolean isValidRegex(String name){
        return name.matches("[a-zA-Z]+");
    }

}
