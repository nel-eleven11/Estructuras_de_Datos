/*
* Hdt 9
* Nelson García Bravatti 22434
*
*/

/**
 * The type Factory.
 */
public class Factory {

    /**
     * Get arbol estructura arbol.
     *
     * @param tipoArbol the tipo arbol
     * @return the estructura arbol
     */
    public static EstructuraArbol getArbol(String tipoArbol){
        if (tipoArbol.equals("1")){
            return new RBTree();
        } else if (tipoArbol.equals("2")){
            return new SplayArbol();
        } else if (tipoArbol.equals("3")){
            return new AVLArbol();
        } else {
            return null;
        }
    }
}
