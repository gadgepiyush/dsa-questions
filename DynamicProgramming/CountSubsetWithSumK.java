package solvedArchive.DynamicProgramming;

//https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532
//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class CountSubsetWithSumK {
    public static void main(String[] args) {
        int arr[] = {12 ,14 ,3 ,18 ,2 };
        int k = 13;
        System.out.println(findWays(arr, k));
    }

    static int findWays(int num[], int k) {
        return subsetHelper(num, k, 0);
    }

    static int subsetHelper(int arr[], int k, int i){
        if(i==arr.length)
            return k==0? 1 : 0;

        int exclude = subsetHelper(arr, k, i+1);
        int include = 0;
        if(arr[i]<=k)
            include = subsetHelper(arr, k-arr[i], i+1);

        return exclude + include;
    }
}
