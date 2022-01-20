package solvedArchive.Arrays;

public class SearchInMatrix {
    public static void main(String[] args) {
        int[][] arr =  {{1,3,5,7} ,{10,11,16,20}, {23,30,34,60}};

        boolean b = searchInMatrix2(arr, 12);
        System.out.println(b);
    }

    //naive approach
    static boolean searchInMatrix1(int[][] arr, int target){

        int row = 0;
        int col = arr[0].length-1;

        while(row<arr.length && col>=0){

            if(arr[row][col] == target)
                return true;

            if(arr[row][col] > target)
                col--;
            else
                row++;
        }

        return false;
    }

    //using binary search optimised
    static boolean searchInMatrix2(int[][] arr, int target){

        int col = arr[0].length -1;

        for (int[] subArr : arr) {

            if (subArr[0] <= target && subArr[col] >= target) {
                int start = 0;
                int end = arr[0].length - 1;

                while (start <= end) {
                    int mid = (start + end)/2;

                    if (subArr[mid] == target)
                        return true;


                    if (subArr[mid] < target)
                        start = mid + 1;
                    else
                        end = mid - 1;

                }
            }
        }

        return false;
    }


}