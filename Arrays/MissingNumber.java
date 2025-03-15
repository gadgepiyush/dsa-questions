package solvedArchive.Arrays;

public class MissingNumber{
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};

        System.out.println(missingNumber(arr, 4));
    }

    static int missingNumber(int array[] , int n){
        int sum = 0;
        int totalSum = 0;
        int i = 0;
        for(i=0 ; i<array.length; i++){
            sum += array[i];
            totalSum += i;
        }


        totalSum+=n;

        return totalSum - sum;
    }
}
