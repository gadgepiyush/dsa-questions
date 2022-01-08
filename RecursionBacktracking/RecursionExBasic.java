package solvedArchive.RecursionBacktracking;

class RecursionMethods {

    static long factorial(long n) {

        if (n < 1) return 1;

        return n * factorial(n - 1);
    }

    static int fibonacci(int n) {

        //base case
        if (n < 2) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int sumOfDigits(int n) {

        if (n == 0) return 0;

        return n % 10 + sumOfDigits(n / 10);
    }

    static int productOfDigits(int n) {

        if (n == 0) return 1;

        return n % 10 * productOfDigits(n / 10);
    }

    static boolean palindrome(String s) {

        s = s.replaceAll("[\\s\\W]", "").toLowerCase();
        System.out.println(s);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    static int noOfZeroInDigit(int n, int count) {

        if (n/10 == 0)
            return count;


        if (n%10 == 0) {
            return noOfZeroInDigit(n/10, ++count);
        }
        else {
            return noOfZeroInDigit(n/10, count);
        }

    }

    static int noOfSteps(int n,int count){

        if(n==0){
            return count;
        }

        if(n%2!=0 && n!=1){
            n = n-1;
            return noOfSteps(n/2, count+2);
        }

        else {
            return noOfSteps(n/2, count+1);
        }


    }

    static int binarySearch(int arr[], int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        } else {
            return binarySearch(arr, target, start, mid - 1);
        }


    }

    static int rotatedBinarySearch(int arr[], int target, int start, int end){
        //base case
        if(start>end)  return -1;

        int mid = (start+end)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[start] <= arr[mid]){
            if(target>=arr[start] && target<arr[mid])
                return rotatedBinarySearch(arr, target, start, mid-1);

            else
                return rotatedBinarySearch(arr, target, mid+1, end);

        }
        else{
            if(target>arr[mid] && target<=arr[end])
                return rotatedBinarySearch(arr, target, mid+1, end);

            else{
                return rotatedBinarySearch(arr, target, start, mid-1);
            }

        }

    }

}

class RecursionExBasic {

    public static void main(String[] args) {



    }
}















