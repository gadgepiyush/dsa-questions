package solvedArchive.Sorting;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {4,1,2,0,9,8,3};

        quicksort(arr, 0, arr.length-1);

        for (int i : arr)
            System.out.print(i+",");

    }

    static void quicksort(int[] arr, int start, int end){

        if(start>=end)  return;

        int pivot = pivotFinder(arr, start, end);

        quicksort(arr, start, pivot-1);
        quicksort(arr, pivot+1, end);

    }

    static int pivotFinder(int[] arr, int start, int end){

        int i = start-1;
        int j = start;
        while (j< end){
            if(arr[j]<arr[end]){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        i++;

        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;

        return i;
    }


}














