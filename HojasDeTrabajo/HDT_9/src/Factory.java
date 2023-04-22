/*
* Hdt 9
* Nelson García Bravatti 22434
*
*/

public class Factory {

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
