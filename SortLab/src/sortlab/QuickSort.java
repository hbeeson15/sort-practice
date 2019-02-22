package sortlab;

/*
This class contains the quicksort. There are 4 different functions corresponding
to the different types of quicksort required. Partition() is the case where 1 and 2 are 
the stopping cases. Partition100() is the case where a partition size of 100 is the 
stopping case and insertion sort is used to finish. Partition50() is the case where 
a partition size of 50 is the stopping case and insertion sort is used to finish. 
MidOfThreePivot is the case where the median of three is used to select the pivot. 
Each of the types of quicksort are recursive. 
 */
public class QuickSort {

    public void QuickSort() {

    }

    public int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low - 1;    //index of small element
        for (int j = low; j < high; j++) {
            //if current is less than or equal to the pivot
            if (array[j] <= pivot) {
                i++;
                //switch array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //switch array[i+1] and array[high] or pivot
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public int partition100(int[] array, int low, int high) {

        int pivot = array[high];

        //checks for the stopping case: partitions of size 100
        if (high - low <= 100) {
            insertionSort(array);
        } else {
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (array[j] >= pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            return i + 1;
        }
        return 0;
    }

    public int partition50(int[] array, int low, int high) {

        int pivot = array[high];

        //checks for the stopping case: partitions of size 50
        if (high - low <= 50) {
            insertionSort(array);
        } else {
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (array[j] >= pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            return i + 1;
        }
        return 0;
    }

    public void midOfThreePivot(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        // Selecting the  pivot
        int first = low;
        int second = low < high ? low + 1 : high;
        int third = low + 1 < high ? low + 2 : high;
        // median for first three
        int pivot = Math.max(Math.min(array[first], array[second]),
                Math.min(Math.max(array[first], array[second]), array[third]));

        while (low < high) {
            while (array[low] <= pivot) {
                low++;
            }
            while (array[high] >= pivot) {
                high--;
             
            }
            if (low <= high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
                high--;

            }
        }
        if (high > low) {
            midOfThreePivot(array, low, high);
        } else {
            return;
        }

    }

    /*Main sorting function. Array is the array to be sorted, low
    is the starting index, high is the ending index.*/
    public void sort(int[] array, int low, int high) {
        if (low < high) {
            int partIndex = partition(array, low, high);

            if (partIndex == 0) {
                return;
            } else {
                //recursively sort the elements before and after partition
                sort(array, low, partIndex - 1);
                sort(array, partIndex + 1, high);
            }

        }
    }

    //insertion sort function that is called after the stopping case of quicksort
    //is reached. 
    public int insertionSort(int[] data) {
        int temp;
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
        return 0;
    }

    //function to print out the array to the console
    public void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
