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
            if (variables.containsKey((String) name)) {
                return variables.get(name);
            } else {
                throw new Exception("Variable does not exist");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    private static boolean isValidRegex(String name){
        return name.matches("[a-zA-Z]+");
    }

    public static HashMap<String, String> getVariables() {
        return variables;
    }

}
