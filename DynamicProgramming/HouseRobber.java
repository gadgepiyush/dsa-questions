package solvedArchive.DynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {

        int arr[] = {2,7,9,3,1,100};
        houseRobber(arr);
    }

    //memoization
    static int houseRobber(int arr[]){

        int memo[] = new int[arr.length];
        int x = houseRobberHelper(0, arr, memo);
        for(int i : memo)
            System.out.print(i+" ");
        System.out.println();

        int y = houseRobberHelper(1, arr, memo);
        for(int i : memo)
            System.out.print(i+" ");
        System.out.println();

        return x;
    }

    static int houseRobberHelper(int i, int arr[], int memo[]){
        if(i>=arr.length)
            return 0;

        if(memo[i]!=0)
            return memo[i];

        int totalSum = 0;
        for(int j=i+2 ; j<arr.length ; j++){
            totalSum = Math.max(totalSum, houseRobberHelper(j, arr, memo));
        }

        totalSum += arr[i];
        memo[i] = totalSum;

        return totalSum;
    }

}
