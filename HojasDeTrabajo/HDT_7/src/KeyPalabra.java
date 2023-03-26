/*
Nelson García
22434
hdt 7
 */

/**
 * The type Key palabra.
 *
 * @param <String> the type parameter
 * @param <V>      the type parameter
 */
public class KeyPalabra<String, V> implements IGetKey<String, V> {



/**
 * Gets key from value.
 *
 * @param value the value
 * @return the key from value
 */
    @Override
    public String getKeyFromValue(V value) {
        return (String) ((Palabra)value).getPalabra();
    }

}

