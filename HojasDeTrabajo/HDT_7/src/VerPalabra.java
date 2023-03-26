/*
Nelson García
22434
hdt 7
 */
public class VerPalabra <K, V> implements ITraversal<K, V> {

    @Override
    public void visit(TreeNode<K, V> actualNode) {
        Palabra palabra = (Palabra) actualNode.getValue();
        System.out.println(" Ingles: "+ palabra.getPIngles() + " Español: " + palabra.getPEspanol() + " Frances: " + palabra.getPFrances() );
    }
}
