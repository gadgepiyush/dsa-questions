package solvedArchive.Searching;

//leetcode 240
public class SearchingATwoDMatrix {
    public static void main(String[] args) {
        int arr[][] = { {1,4,7,11},
                        {2,5,8,12},
                        {3,6,9,16},
                        {10,13,14,17}};

        int arr2[][] = {{-1,3}};

        System.out.println(searchMatrix(arr2, 3));
    }

    static boolean searchMatrix(int[][] arr, int target){
        int row = 0;
        int col = arr[0].length-1;

        while (col>=0 && row<arr.length){
            if(arr[row][col]==target) {
                return true;
            }
            else if(target>arr[row][col]){
                row++;
            }
            else {
                col--;
            }
        }

        return false;
    }
}
