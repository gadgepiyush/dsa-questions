package solvedArchive.Arrays;
import java.util.*;

//leetcode 599. Minimum Index Sum of Two Lists
public class MinimumIndexSum{
    public static void main(String[] args) {
            String arr1[] = {"Shogun","Piatti","Tapioca Express","Burger King","KFC"};
            String arr2[] = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

            for(String i : findRestaurant(arr1, arr2)){
                System.out.print(i + " ");
            }
    }

    static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String , Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int min = Integer.MAX_VALUE;

        if(list1.length < list2.length) {
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }

            for (int i = 0; i < list2.length; i++) {
                if (map.containsKey(list2[i])) {
                    min = map.get(list2[i]) + i < min ? map.get(list2[i]) + i : min;
                    map2.put(list2[i], map.get(list2[i]) + i);
                }
                else {
                    map.remove(list2[i]);
                }
            }
        }
        else{
            for (int i = 0; i < list2.length; i++) {
                map.put(list2[i], i);
            }

            for (int i = 0; i < list1.length; i++) {
                if (map.containsKey(list1[i])) {
                    min = map.get(list1[i]) + i < min ? map.get(list1[i]) + i : min;
                    map2.put(list1[i], map.get(list1[i]) + i);
                }
                else {
                    map.remove(list1[i]);
                }
            }
        }

        List<String> temp = new ArrayList<>();
        for(var i : map2.entrySet()){
            if(i.getValue() == min)
                temp.add(i.getKey());
        }


        return temp.toArray(new String[temp.size()]);
    }
}
