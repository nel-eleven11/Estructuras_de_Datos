/*
Nelson García
22434
hdt 7
 */

import java.util.ArrayList;

/**
 * The type Ver palabra.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class VerPalabra <K, V> implements ITraversal<K, V> {

    private ArrayList<String> datos = new ArrayList<String>();

    @Override
    public void visit(TreeNode<K, V> actualNode) {
        Palabra palabra = (Palabra) actualNode.getValue();
        String datos = " Ingles: "+ palabra.getPIngles() + " Español: " + palabra.getPEspanol() + " Frances: " + palabra.getPFrances() ;
        this.datos.add(datos);
    }

    /**
     * Get datos array list.
     *
     * @return the array list
     */
    public ArrayList<String> getDatos(){
        return datos;
    }

    /**
     * Set datos.
     *
     * @param datos the datos
     */
    public void setDatos(ArrayList<String> datos){
        this.datos = datos;
    }
}
