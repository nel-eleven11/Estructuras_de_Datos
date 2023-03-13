import java.util.HashMap;


public class functions {

    private static final HashMap<String, Object> functions = new HashMap<String, Object>();
    /*
    *añade una funcion a la lista de funciones
    *param name
    *param value
     */
    public static void addFunction(String name, Object value){
        try {
            if (isValidRegex(name)) {
                functions.put(name, value);
            } else {
                throw new Exception("Invalid function name");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    *retorna el valor de una funcion
    * @param name
    * @return Object
     */
    public Object getFunction(String name){
        try {
            if (!functions.containsKey(name)) {
                throw new Exception("Function does not exist");
            } else {
                return functions.get(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /*
    *verifica si el nombre de una funcion es valido
    * @param name
    * @return boolean
     */
    public static boolean isValidRegex(String name){
        return name.matches("[a-zA-Z]+");
    }

}
