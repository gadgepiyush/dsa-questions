package solvedArchive.Graph;

import java.util.*;

//leetcode - 127
//https://youtu.be/ZVJ3asMoZ18?si=Df_ow0-F_wOrzB29&t=210
public class WordLadder {
    public static void main(String[] args) {
        List<String> list = List.of("hot","dot","dog","lot","log","cog");

        System.out.println(ladderLength("hit", "cog", list));
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList){
        int res = 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>(List.of(beginWord));

        while (!queue.isEmpty()){
            int sizeOfCurrLevel = queue.size();
            res++;

            for(int i=0 ; i< sizeOfCurrLevel ; i++){
                String curr = queue.poll();

                for(int j=0 ; j<curr.length() ; j++){
                    char[] newStr = curr.toCharArray();

                    for(char k='a' ; k<='z' ; k++){
                        newStr[j] = k;
                        String temp  = new String(newStr);
                        if(set.contains(temp)){
                            queue.add(temp);
                            set.remove(temp);

                            if(temp.equals(endWord))
                                return res+1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
