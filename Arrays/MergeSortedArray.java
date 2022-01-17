package solvedArchive.Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int arr1[] = {4,5,6,0,0,0};
        int arr2[] = {1,2,3};

        arrayMerge(arr1,arr2, 3);

    }

    static void arrayMerge(int arr1[], int arr2[], int n){

        int j=0;
        for (int i = arr1.length-n; i < arr1.length; ++i) {
            arr1[i] = arr2[j];
            j++;
        }

        int i = arr1.length-n;
        while (i<arr1.length && arr1[i]<arr1[i-1]){

            j=i;
            while (j>0 && arr1[j]<arr1[j-1]){
                int temp = arr1[j];
                arr1[j] = arr1[j-1];
                arr1[j-1] = temp;
                j--;
            }

            i++;
        }

        for (int i1 : arr1)
            System.out.print(i1+" ");


    }


}
