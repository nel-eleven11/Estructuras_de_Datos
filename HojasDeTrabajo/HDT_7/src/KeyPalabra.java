/*
Nelson García
22434
hdt 7
 */

public class KeyPalabra<String, V> implements IGetKey<String, V> {
    @Override
    public String getKeyFromValue(V value) {
        return (String) ((Palabra)value).getPalabra();
    }

}

