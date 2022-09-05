package solvedArchive.Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int arr1[] = {1,2,3,0,0,0};
        int arr2[] = {2,5,6};

        arrayMerge1(arr1,arr2,3);

    }

    //naive solution
    static void arrayMerge1(int arr1[], int arr2[], int n){

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


    //optimised (Time complexity O(M+N)) only drawback using extra space
    static void arrayMerge2(int arr1[], int arr2[],int n){

        int arr3[] = new int[arr1.length];

        int i=0,j=0,k=0;

        while(i<arr1.length-n && j<arr2.length){
            if(arr1[i]>arr2[j]){
                arr3[k]=arr2[j];
                j++;
            }
            else{
                arr3[k]=arr1[i];
                i++;
            }
            k++;
        }

        while(i<arr1.length-n){
            arr3[k]=arr1[i];
            i++; k++;
        }

        while(j<arr2.length){
            arr3[k]=arr2[j];
            j++; k++;
        }

        for(int x : arr3){
            System.out.print(x+" ");
        }
    }

}
