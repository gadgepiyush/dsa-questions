package solvedArchive.Hashing;
import java.util.*;

public class Intersection{

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1,2,2,4,5,6);
        List<Integer> l2 = Arrays.asList(2,2,2,3,4,5);

        System.out.println(intersection2(l1,l2));

    }


    // finding union of two lists
    static List<Integer> union(List<Integer> l1, List<Integer> l2){

        Set<Integer> set = new HashSet<>();

        // adding all elements of l1 and l2 to set, set would not accept duplicates
        set.addAll(l1);

        set.addAll(l2);

        return new ArrayList<>(set);
    }


    //finding intersection of two lists (not adding duplicates)
    static List<Integer> intersection1(List<Integer> l1, List<Integer> l2){

        Set<Integer> set = new HashSet<>();

        set.addAll(l1);

        Set<Integer> intersection = new HashSet<>();
        for(int i : l2){
            if(set.contains(i))
                intersection.add(i);
        }


        return new ArrayList<>(intersection);
    }


    //finding intersection of two lists (adding duplicates)
    static List<Integer> intersection2(List<Integer> l1, List<Integer> l2){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : l1){
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);

            else
                map.put(i,1);

        }

        List<Integer> ls = new ArrayList<>();

        for(int i : l2){
            if(map.containsKey(i) && !map.get(i).equals(0)){
                ls.add(i);
                map.put(i, map.get(i)-1);
            }
        }

        return ls;

    }


    //finding intersection of two lists (without Hashing, using frequency array)
//    static List<Integer> intersection3(List<Integer> l1, List<Integer> l2){
//
//    }

}
