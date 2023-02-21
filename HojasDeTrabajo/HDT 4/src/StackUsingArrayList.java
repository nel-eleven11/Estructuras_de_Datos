/**
 * 
 */


import java.util.ArrayList;

/**
 * @author MAAG
 *
 */
public class StackUsingArrayList<T> extends Stack<T> {

	private ArrayList<T> miListaInterna;
	
	public StackUsingArrayList() {
		miListaInterna = new ArrayList<T>(); 
	}
	
	
	/**
	 * count, cuenta el numero de elementos en la lista
	 * @return int
	 */
	@Override
	public int count() {
		return miListaInterna.size();
	}

	
	/**
	 * isEmpty, verifica si la lista esta vacia
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return miListaInterna.isEmpty();
	}

	
	/**
	 * push, agrega un elemento al inicio de la lista
	 * @param value
	 */
	@Override
	public void push(T value) {
		miListaInterna.add(0, value);
	}

	
	/**
	 * pull, elimina el primer elemento de la lista, y lo retorna
	 * @return T
	 */
	@Override
	public T pull() {
		return miListaInterna.remove(0);
	}

	
	/**
	 * peek, retorna el primer elemento de la lista
	 * @return T
	 */
	@Override
	public T peek() {		
		return miListaInterna.get(0);
	}

}
