package solvedArchive.RecursionBacktracking;


import java.util.ArrayList;

class RecursionMethodsLvl1 {

    static boolean sortedArrayChecker(int arr[], int i){

        //base case
        if(i+1 == arr.length){
            return true;
        }

        if(arr[i] <= arr[i+1]){
            return sortedArrayChecker(arr, i+1);
        }
        else{
            return false;
        }

    }

    static int linearSearch(int arr[], int i, int target){
        //base case
        if(i==arr.length){
            return -1;
        }

        if(arr[i] == target)
            return i;

        else
            return linearSearch(arr, i+1, target);

    }

    //this method is returning a list containing the indexes where target is found
    static ArrayList<Integer> occurrenceCheck(ArrayList<Integer> arr, int target,int i){

        ArrayList<Integer> countList = new ArrayList<>();

        if(i==arr.size()){
            return countList;
        }

        if(arr.get(i) == target){
            countList.add(i);
        }

        ArrayList<Integer> ansFromBelowCalls = occurrenceCheck(arr, target, i+1);

        countList.addAll(ansFromBelowCalls);

        return countList;

    }

    static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr, int end){

        //base case
        if(end==0){
            return arr;
        }

        for(int i=0 ; i<end-1 ; i++){

            if(arr.get(i) > arr.get(i+1)){
                int temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i+1, temp);
            }

        }

        return bubbleSort(arr, end-1);
    }

}


public class RecursionExLvl1 {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(1);
        arr.add(3);
        arr.add(1);
        arr.add(4);
        arr.add(1);

        ArrayList<Integer> x = RecursionMethodsLvl1.occurrenceCheck(arr, 1, 0);

        System.out.println(x);

    }

}





