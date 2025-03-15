package solvedArchive.Arrays;

//leetcode 2460
public class ApplyOperationsOnArray {
    public static void main(String[] args) {
        int arr[] = {1,2,2,1,1,0};

        applyOperations(arr);

        for(int i : arr)
            System.out.print(i + " ");
    }

    static int[] applyOperations(int[] arr) {
        for(int i=0 ; i<arr.length-1 ; i+=1){
            if(arr[i] == arr[i+1]){
                arr[i] *= 2;
                arr[i+1] = 0;
            }
        }

        int back = 0;
        for(int front=0 ; front<arr.length ; front++){
            if(arr[front]!=0){
                int temp = arr[back];
                arr[back] = arr[front];
                arr[front] = temp;
                back++;
            }
        }

        return arr;
    }
}
