/*
Nelson García Bravatti
22434
HDT 4
Clase abstracta List
 */

abstract class List <T> implements IList<T>{

    protected int count;

    public List(){
        count = 0;
    }

    
    /** 
     * @return int
     */
    public int count(){
        return count;
    }

    
    /** 
     * @return boolean
     */
    public boolean isEmpty(){
        return count == 0;
    }

    public abstract void InsertAtStart(T value);

    public abstract void InsertAtEnd(T value);

    public abstract void Insert(T value, int index);

    public abstract T Delete(int index);

    public abstract T DeleteAtStart();

    public abstract T DeleteAtEnd();

    public abstract T Get(int index);

}
