package solvedArchive.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 4, 2};

        nextPermutation(arr);

        for(int i : arr)
            System.out.print(i+" ");
    }

    static void nextPermutation(int arr[]){
        if(arr.length==1)
            return;

        //step 1 find idx1
        int idx1 = -1;
        for(int i=arr.length-2 ; i>=0 ; i--){
            if(arr[i] < arr[i+1]){
                idx1 = i;
                break;
            }
        }


        //step 2 find idx2
        int idx2 = 0;
        if(idx1<0){
            reverse(arr, 0, arr.length-1);
        }
        else{
            for(int i = arr.length-1 ; i>=0 ; i--){
                if(arr[i] > arr[idx1]){
                    idx2 = i;
                    break;
                }
            }
        }

        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        reverse(arr, idx1+1, arr.length-1);

    }


    static void reverse(int arr[], int start ,int end){
        while (start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
