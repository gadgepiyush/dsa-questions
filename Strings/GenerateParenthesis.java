package solvedArchive.Strings;
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        parenthesisFormer(4, 0, 0, "", str);
        System.out.println(str);
    }

    //leetcode 22 Generate Parenthesis
    static void parenthesisFormer(int n, int open, int close, String parenthesis, List<String> ls){
        if(open==n && close==n)
            ls.add(parenthesis);

        if(open<n){
            parenthesisFormer(n, open+1, close, parenthesis+"(", ls);
        }

        if(close<open){
            parenthesisFormer(n, open, close+1, parenthesis+")", ls);
        }

    }
}
