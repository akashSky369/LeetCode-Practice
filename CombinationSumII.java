class Solution {
    static void backtrack(int[] arr, int idx,  int k, List<Integer> tracker, List<List<Integer>> res){
 
      
      //base case
 if(k==0){
     res.add(new ArrayList<>(tracker));
     return;
 }

for(int i =idx; i<arr.length; i++){
  //checking for duplicates
    if(i>idx && arr[i]==arr[i-1])continue;
  
  //if sum becomes greater
    if(arr[i]>k){
        break;
    }

  //adding the sum
    tracker.add(arr[i]);
    backtrack(arr,i+1,k-arr[i],tracker,res);
    tracker.remove(tracker.size()-1);
}

 }
        

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
       
        List<List<Integer>> res = new ArrayList();

        backtrack(candidates,0,target,new ArrayList<>(),res);
        return res;
    }
}

