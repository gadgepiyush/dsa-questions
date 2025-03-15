package solvedArchive.Arrays;

//leetcode - 282
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0};
        moveZeroes(arr);
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] +" ");
        }


    }

    static void moveZeroes(int[] arr){
        int back = 0;
        int front = 0;

        while(back<arr.length && front<arr.length){
            if( arr[back]!=0){
                back++;
                continue;
            }

            if(arr[front]!=0 && back<front){
                arr[back] = arr[front];
                arr[front] = 0;
                back++;
            }
            front++;
        }
    }
}
