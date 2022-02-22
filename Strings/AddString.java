package solvedArchive.Strings;

public class AddString{
    public static void main(String[] args) {
        System.out.println(addStr("1496", "1111177"));
    }

    //leetcode 415
    static String addStr(String s1, String s2){

        int s1Pointer = s1.length()-1;
        int s2Pointer = s2.length()-1;
        int carry = 0;
        String addition = "";

        while(s1Pointer>=0 && s2Pointer>=0){
            int temp = carry + s1.charAt(s1Pointer) + s2.charAt(s2Pointer) - 96;  //48+48=96 (48 is ascii value of '0')
            if(temp>=10){
                addition = String.valueOf(temp%10) + addition;
                carry = 1;
            }
            else {
                addition = String.valueOf(temp) + addition;
                carry = 0;
            }

            s1Pointer--;
            s2Pointer--;
        }

        System.out.println(carry);

        if(s1Pointer>=0){
            while(carry!=0){
                int temp = carry + s1.charAt(s1Pointer) - 48;
                if(temp>=10){
                    addition = String.valueOf(temp%10) + addition;
                }
                else{
                    addition = String.valueOf(temp) + addition;
                    carry = 0;
                }
                s1Pointer--;
            }

            addition = s1.substring(0, s1Pointer) + s1.charAt(s1Pointer) + addition;
        }
        else if(s2Pointer>=0){
            while(carry!=0){
                int temp = carry + s2.charAt(s2Pointer) - 48;
                if(temp>=10){
                    addition = String.valueOf(temp%10) + addition;
                }
                else{
                    addition = String.valueOf(temp) + addition;
                    carry = 0;
                }
                s2Pointer--;
            }

            addition = s2.substring(0, s2Pointer) + s2.charAt(s2Pointer) + addition;
        }

        if(carry!=0){
            addition = String.valueOf(carry) + addition;
        }


        return addition;
    }

}
