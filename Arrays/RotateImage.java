package solvedArchive.Arrays;

//leetcode 48
public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {
                  {5,1,9,11}
                , {2,4,8,10}
                , {13,3,6,7}
                , {15,14,12,16}};

        rotateMatrix(arr);

        for (int[] ints : arr) {
            for (int j : ints)
                System.out.print(j + " ");

            System.out.println();
        }
    }

    static void rotateMatrix(int[][] arr){
        int n = arr.length;

        for(int i=0 ; i<(n+1)/2 ; i++){
            for(int j=0 ; j<n/2 ; j++){
                //temp = bottom left
                int temp = arr[n-1-j][i];

                //bottom left = bottom right
                arr[n-1-j][i] = arr[n-1-i][n-1-j];

                //bottom right = top right
                arr[n-1-i][n-j-1] = arr[j][n-1-i];

                //top right = top left
                arr[j][n-1-i] = arr[i][j];

                //top left = temp
                arr[i][j] = temp;
            }
        }
    }

}
