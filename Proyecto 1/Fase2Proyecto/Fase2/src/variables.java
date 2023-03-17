/*
Nelson García 22434
Joaquín Puente 22296
Oscar Fuentes
Proyecto 1 Algoritmos y Estructuras de datos
 */
import java.util.HashMap;

public class  variables{
    private static final HashMap<String, String> variables = new HashMap<String, String>();
    /*
    añade varaibles a la lista de variables
    * @param name
    * @param value
    * @return void
     */
    public static void addVariable(String name, String value){
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
    /*
    *retorna el valor de una variable
    * @param name
    * @return Object
     */
    public static String getVariable(String name){
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
    /*
    *añade una constante a la lista de constantes
    * @param name
    * @param value
    * @return void
     */
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
    /*
    *retorna el valor de una constante
    * @param name
    * @return Object
     */
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
    /*
    *verifica si el nombre de una variable o constante es valido
    * @param name
    * @return boolean
     */
    private static boolean isValidRegex(String name){
        return name.matches("[a-zA-Z]+");
    }

    public static HashMap<String, String> getVariables() {
        return variables;
    }

}
