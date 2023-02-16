/**
 * 
 */
package edu.uvg.structures.src;

/**
 * @author MAAG
 *
 */
public interface IStack<T> {

	int count();
	
	boolean isEmpty();
	
	void push(T value);
	
	T pull();
	
	T peek();
}
