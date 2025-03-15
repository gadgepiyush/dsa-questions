package solvedArchive.Searching;

//leetcode 153
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {5,7,8,12,15,20};
        System.out.println(findMin(arr));
    }

    static int findMin(int[] arr){
        return findMinHelper(arr, 0, arr.length-1);
    }

    static int findMinHelper(int[] arr, int start, int end){
        if(start>=end){
            return arr[end];
        }

        if(arr[start]<arr[end])
            return arr[start];

        int mid = (start+end)/2;

        return Math.min(findMinHelper(arr, start, mid), findMinHelper(arr, mid+1, end));
    }
}
