class Solution {
  
  
  public int canCompleteCircuit(int[] gas, int[] cost) {
    
    //finding total cost and gas
    int total_gas=0,total_cost=0;
        for(int i=0;i<gas.length;i++)
        {
            total_gas+=gas[i];
            total_cost+=cost[i];
        }
    
    //cost is more than gas 
        if(total_gas<total_cost)
            return -1;
        int start=0;
        int tank_me_gas=0;
    
    //finding valid idx
        for(int i=0;i<gas.length;i++)
        {
            tank_me_gas+=gas[i];
            tank_me_gas-=cost[i];
            
            if(tank_me_gas<0)
            {
                start=i+1;
                tank_me_gas=0;
            }  
        }
        return start;   
 
    }
}
