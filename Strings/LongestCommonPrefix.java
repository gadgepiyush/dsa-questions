package solvedArchive.Strings;

//leetcode 14
public class LongestCommonPrefix{
    public static void main(String[] args) {
        String arr[] = {"ab","ab"};

        System.out.println(longestCommonPrefix(arr));
    }

    static String longestCommonPrefix(String str[]){
        String res = str[0];

        for(int i=1 ; i<str.length ; i++){
            int j;
            for(j=0 ; j<str[i].length() ; j++){
                if(j>=res.length()){
                    break;
                }
                if(str[i].charAt(j) != res.charAt(j)){
                    res = res.substring(0, j);
                    break;
                }
            }

            if(j<res.length())
                res = res.substring(0, j);

            if(res.length()==0)
                break;
        }

        return res;
    }

}
