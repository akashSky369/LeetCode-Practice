 public static String frequencySort(String s) {
 
 //hashMap
      Map<Character,Integer> mp = new HashMap<>();
for (char c:s.toCharArray()){
    mp.put(c,mp.getOrDefault(c,0)+1);
}


//maxheap with lambada function to putting max freq char on top of heap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> mp.get(b)-mp.get(a));
maxHeap.addAll(mp.keySet());
StringBuilder str = new StringBuilder();
while (!maxHeap.isEmpty()){
    char c = maxHeap.remove();
    str.append(String.valueOf(c).repeat(Math.max(0, mp.get(c))));
}
return str.toString();
    }
