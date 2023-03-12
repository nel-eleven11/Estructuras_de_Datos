import java.util.HashMap;


public class functions {

    private final HashMap<String, Object> functions = new HashMap<String, Object>();

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

    public boolean isValidRegex(String name){
        return name.matches("[a-zA-Z]+");
    }

}
