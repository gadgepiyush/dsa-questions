package solvedArchive.PrefixSum;

//leetcode 303 Range Sum Query -  Immutable
public class RangeSumQuery {
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{-2, 0, 3, -5, 2, -1};
        int prevSum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] += prevSum;
            prevSum = arr[i];
        }
    }

    static int sumRange(int left, int right){
        return left>0 ? arr[right]-arr[left-1] : arr[right];
    }
}
