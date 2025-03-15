package solvedArchive.Searching;

//leetcode 33
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[]  arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }

    static int search(int[] arr, int target){

        return binarySearch(arr, 0, arr.length-1, target);
    }

    static int binarySearch(int[] arr, int start, int end, int target){
        if(end<=start){
            if(end==start && arr[end]==target)
                return end;
            else
                return -1;
        }

        int mid = (start+end)/2;

        if(target>=arr[start] && target<=arr[mid]) {
            return binarySearchHelper(arr, start, mid, target);
        }
        else if(target>=arr[mid+1] && target<=arr[end]){
            return binarySearchHelper(arr, mid+1, end, target);
        }

        return Math.max(binarySearch(arr, start, mid, target), binarySearch(arr, mid+1, end, target));
    }

    static int binarySearchHelper(int arr[], int start, int end, int target){
        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]<target) {
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }

        return -1;
    }
}
