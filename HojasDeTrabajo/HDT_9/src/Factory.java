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
        switch (tipoArbol){
            case "1":
                return new RBTree();
            case "2":
                return new SplayArbol();
            case "3":
                return new AVLArbol();
            default:
                return null;
        }
    }
}
