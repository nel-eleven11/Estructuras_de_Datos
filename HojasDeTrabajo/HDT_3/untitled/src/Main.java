public class Main {
    public static void main(String[] args) {
        //Make an array with unordered numbers from 1 to 10
        Integer[] myArray = new Integer[10];
        myArray = new Integer[]{1, 3, 7, 10, 9, 2, 6, 8, 5, 4};


        SortingMethods mySort = new SortingMethods();
        mySort.quickSort(myArray, 0, myArray.length - 1);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        mySort.mergeSortRecursive(myArray, 0, myArray.length - 1);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        mySort.gnomeSort(myArray);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }



    }
}