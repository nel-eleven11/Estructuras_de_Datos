/*
Nelson García
22434
hdt 7
 */

/**
 * The interface Get key.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author MAAG
 */
public interface IGetKey<K, V> {
    /**
     * Gets key from value.
     *
     * @param value the value
     * @return the key from value
     */
    K getKeyFromValue(V value);
}
