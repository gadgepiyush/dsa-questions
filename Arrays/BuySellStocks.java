package solvedArchive.Arrays;

public class BuySellStocks {

    //calculate max profit (time complexity O(N))
    static int stocks1(int arr[]){

        int profit = 0;
        int min = arr[0];

        for(int i : arr){
            if(i<min)
                min = i;

            if(i-min > profit)
                profit = i-min;
        }

        return profit;
    }
}
