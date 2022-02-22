package solvedArchive.Arrays;
import java.util.*;

//989. Add to Array-Form of Integer
public class ArrayFromInt {

    public static void main(String[] args) {
        int arr[] = {9,9,9,9,9,9,9,9,9};
        System.out.println(arrayForm(arr, 1));

    }

    static List<Integer> arrayForm(int arr[] , int k){

        List<Integer> ls = new ArrayList<>();
        int i = arr.length-1;
        int carry = 0;
        while(i>=0){
            if(k!=0 || carry==1){
                int temp = carry + arr[i] + k%10;
                if(temp>=10){
                    carry = 1;
                    ls.add(temp%10);
                }
                else {
                    ls.add(temp);
                    carry = 0;
                }
                k /= 10;
                i--;
                continue;
            }

            ls.add(arr[i]);
            i--;
        }


        if(k>0){
            while(k!=0){
                int temp = carry + k%10;
                if(temp>=10){
                    ls.add(temp%10);
                    carry=1;
                }
                else {
                    ls.add(temp);
                    carry = 0;
                }
                k/=10;

            }
        }

        if(carry == 1)
            ls.add(carry);

        Collections.reverse(ls);
        return ls;
    }

}
