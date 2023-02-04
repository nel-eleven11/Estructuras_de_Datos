public class SortingMethods <T>{

    public IComparator myCompare;

    public SortingMethods(IComparator _Compare) {
        myCompare = _Compare;
    }

    public void quickSort(T[] myArray, int inf, int sup) {
        int i = inf - 1;
        int j = sup;
        boolean flag = true;
        T temp;


        if (inf >= sup) {
            return;
        }

        T elem_div = myArray[sup];


        while (flag) {
            while(myCompare.Compare(myArray[++i], elem_div) < 0); //Move the index i until it finds an element bigger than elem_div
            while((myCompare.Compare(myArray[--j], elem_div) > 0)  && (j > inf)); //Move the index j until it finds element smaller than elem_div

            if (i < j) {
                temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
            } else {
                flag = false;
            }
        }

        temp = myArray[i];
        myArray[i] = myArray[sup];
        myArray[sup] = temp;
        quickSort(myArray, inf, i - 1);
        quickSort(myArray, i + 1, sup);
    }

}
