package vm;



import java.io.*;
import java.util.ArrayList;

public class archivos implements Serializable{
    private static File dataFile;

    /**
     * @author Joaquin Puente
     * Este método permite guardar la información en un archivo .dat
     * @param _DataToSave
     * @param _arrayList
     */
    public static void saveData(Integer[] _array) {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(dataFile);
            System.out.println(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {

                ObjectOutputStream oos = null;
                try {

                    oos = new ObjectOutputStream(fos);

                    if (oos != null) {

                        oos.writeObject(_array);

                    }
                    assert oos != null;
                    oos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * @author Joaquin Puente
     * Este método permite cargar la información a partir del archivo .dat
     * @return Arraylist
     */
    public static Integer[] loadData() {

        Integer[] arraylist = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (fis != null) {

                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(fis);

                    if (ois != null) {

                        try {
                            arraylist = (Integer[]) ois.readObject();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    assert ois != null;
                    ois.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return arraylist;

    }
}