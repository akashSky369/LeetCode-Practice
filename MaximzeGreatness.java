class Solution {
    public int maximizeGreatness(int[] nums) {
       Arrays.sort(nums);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int e: nums)queue.add(e);
        
        
        
        int i =0;
        int score =0;
        while(i<nums.length && !queue.isEmpty()){
            if(queue.peek()>nums[i]){
                score++;
                queue.poll();
                i++;
            }
            else{
                queue.poll();
                
            }
        }
        
        return score;
    }
}
