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

        //step 1 find inflection point (i.e. the point where value of i-1 < i)
        int toSwap = -1;
        for(int i=arr.length-2 ; i>=0 ; i--){
            if(arr[i] < arr[i+1]){
                toSwap = i;
                break;
            }
        }


        //step 2 find the index of the number just before when number is becoming less then the number ar idx1
        int swapWith = 0;
        if(toSwap<0){ // if it is the last permutation just reverse the whole array
            reverse(arr, 0, arr.length-1);
        }
        else{
            for(int i = arr.length-1 ; i>=0 ; i--){
                if(arr[i] > arr[toSwap]){
                    swapWith = i;
                    break;
                }
            }
        }

        int temp = arr[toSwap];
        arr[toSwap] = arr[swapWith];
        arr[swapWith] = temp;

        reverse(arr, toSwap+1, arr.length-1);

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
