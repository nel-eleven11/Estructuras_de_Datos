/*
Nelson García
22434
hdt 7
 */

import java.util.ArrayList;
public class VerPalabra <K, V> implements ITraversal<K, V> {

    private ArrayList<String> datos = new ArrayList<String>();

    @Override
    public void visit(TreeNode<K, V> actualNode) {
        Palabra palabra = (Palabra) actualNode.getValue();
        String datos = " Ingles: "+ palabra.getPIngles() + " Español: " + palabra.getPEspanol() + " Frances: " + palabra.getPFrances() ;
        this.datos.add(datos);
    }

    public ArrayList<String> getDatos(){
        return datos;
    }

    public void setDatos(ArrayList<String> datos){
        this.datos = datos;
    }
}
