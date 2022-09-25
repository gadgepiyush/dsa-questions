package solvedArchive.Sorting;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {4,1,2,0,9,8,3};

        mergeSort(arr, 0, arr.length-1);

        for (int i : arr)
            System.out.print(i+",");
    }

    static void mergeSort(int arr[], int start, int end){
        if(start<end){
            int mid = (start+end)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    //  4 1 2 0 9 8 3
    static void merge(int arr[], int start, int mid, int end){
       int temp1[] = new int[mid-start+1];
       int k = start;
       for(int i=0 ; i<temp1.length ; i++){
           temp1[i] = arr[k];
           k++;
       }

       int temp2[] = new int[end-mid];
       for(int j=0 ; j<temp2.length ; j++){
           temp2[j] = arr[k];
           k++;
       }

       int i=0, j=0;
       k = start;

       while(i<temp1.length && j< temp2.length){
           if(temp1[i]<temp2[j]){
               arr[k] = temp1[i];
               i++;
           }
           else{
               arr[k] = temp2[j];
               j++;
           }
           k++;
       }

       if(i<temp1.length){
           while(i<temp1.length){
               arr[k] = temp1[i];
               i++;
               k++;
           }
       }
       else{
           while(j<temp2.length){
               arr[k] = temp2[j];
               j++;
               k++;
           }
       }
    }

}
