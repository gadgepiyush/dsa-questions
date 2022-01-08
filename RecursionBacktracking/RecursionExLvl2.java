package solvedArchive.RecursionBacktracking;
import java.util.*;


class RecursionMethodLvl2{


    // this method removes the given char(skip) from the string (this method takes all arguments)
    static String charRemover1(char skip, String given, String newStr, int start){
        //base case
        if(start == given.length()) return newStr;

        if(given.charAt(start) == skip ){
            return charRemover1(skip, given, newStr, ++start);
        }

        return charRemover1(skip, given, newStr+given.charAt(start), ++start);
    }


    // this method removes the given char(skip) from the string (this method is without arguments)
    static String charRemover2(String given, String newStr){

        //base case
        if(given.isEmpty())  return newStr;


        char ch = given.charAt(0);

        if (ch != 'a') {
            newStr += ch;
        }

        return charRemover2(given.substring(1), newStr);

    }


    static int reverseInt(int x, long y){
        //base case
        if(x%10 == 0 && x/10 == 0 && y<Integer.MAX_VALUE)  return (int)y;

        if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)  return 0;

        return reverseInt(x/10, y*10+x%10);
    }


    //directly prints subset strings
    static void printSubsets(String newStr, String given){

        if(given.isEmpty()) {
            System.out.println(newStr);
            return;
        }

        char c = given.charAt(0);

        printSubsets(newStr+c, given.substring(1));
        printSubsets(newStr, given.substring(1));

    }


    //returns list containing all subsets
    static ArrayList<String> printSubsets2(String newStr, String given){

        //base case
        if(given.isEmpty()){
            ArrayList<String> ls = new ArrayList<>();
            ls.add(newStr);
            return ls;
        }

        ArrayList<String> left = printSubsets2(newStr+given.charAt(0), given.substring(1));
        ArrayList<String> right = printSubsets2(newStr, given.substring(1));

        left.addAll(right);

        return left;

    }


    //prints all permutations of a string
    static void permutations(String newStr, String given){

        if(given.isEmpty()){
            System.out.println(newStr);
            return;
        }

        char ch = given.charAt(0);

        for(int i=0 ; i<=newStr.length() ; i++){
            String first = newStr.substring(0,i);
            String second = newStr.substring(i);

            permutations(second+ch+first, given.substring(1));
        }
    }


    //returns a list containing all permutations of a string
    static List<String> permutationString(String newStr, String given){

        if(given.isEmpty()){
            List<String> x = new ArrayList<>();
            x.add(newStr);
            return x;
        }

        List<String> temp = new ArrayList<>();

        char ch = given.charAt(0);
        for(int i=0 ; i<=newStr.length() ; i++){
            String first = newStr.substring(0,i);
            String second = newStr.substring(i);

            List<String> ls = permutationString(first+ch+second, given.substring(1));
            temp.addAll(ls);
        }

        return temp;
    }


    static List<String> numpadLeetcode(String newStr, String given){

        if(given.isEmpty()){
            List<String> ls = new ArrayList<>();
            ls.add(newStr);
            return ls;
        }

        List<String> arr = new ArrayList<>();

        //48 is the ascii value of '0'
        int digit = (int)( given.charAt(0) - 48);
        //97 is the ascii value of 'a'
        int start = (digit-2)*3 + 97;
        int end = (digit-1)*3 + 97;

        if(digit==7 || digit==8){
            end++;
        }
        if(digit==8 || digit==9){
            start++;
        }
        if(digit==9){
            end+=2;
        }

        for (int i = start; i < end ; i++) {
            char ch = (char) i;
            List<String> temp = numpadLeetcode(newStr + ch, given.substring(1));

            arr.addAll(temp);
        }


        return arr;
    }

}


public class RecursionExLvl2 {
    public static void main(String[] args) {



    }
}
