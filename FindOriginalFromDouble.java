package LeetCode;

import java.util.*;

public class OriginalFromDouble {



    public static int[] findOriginalArray(int[] changed) {
      
      //sorting the array to get the greedy approach
        Arrays.sort(changed);
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        if ((changed.length&1)!=0){
            return new int[]{};
        }
        for (int e: changed){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        //  System.out.println(map);
        for (int i=0; i<changed.length; i++){
            int key = changed[i];
            int val = map.get(changed[i]);

            // 1  3  4  2  6  8
            if (val>=1) {
                val--;
                map.put(key, val);



                if (map.containsKey(key * 2) && map.get(key*2)!=0 ) {
                    list.add(key);
                    map.put(key * 2, map.get(key * 2) - 1);
                } else {
                    map.put(key, val + 1);

                }

            }
            //  System.out.println(list);
        }

        if (list.size()*2!= changed.length){
            return new int[]{};
        }
        int[] res = new int[list.size()];

        for (int i =0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
int[] arr = {2,4,2,1};
        System.out.println(Arrays.toString(findOriginalArray(arr)));
    }
}
