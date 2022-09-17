package solvedArchive.Strings;

//leetcode 917
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";

        System.out.println(reverseOnlyLetters(s));
    }

    static String reverseOnlyLetters(String s){
        int i=0, j=s.length()-1;
        StringBuilder sb = new StringBuilder(s);

        while(i<j){
            if(Character.isLetter(sb.charAt(i)) && Character.isLetter(sb.charAt(j))){
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
            else if(Character.isLetter(sb.charAt(i)) && !Character.isLetter(sb.charAt(j))){
                j--;
            }
            else if(!Character.isLetter(sb.charAt(i)) && Character.isLetter(sb.charAt(j))){
                i++;
            }
            else {
                i++;
                j--;
            }
        }

        return sb.toString();
    }
}
