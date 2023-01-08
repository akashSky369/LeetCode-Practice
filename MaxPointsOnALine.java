class Solution {
  
  
  //function with given points
   public int maxPoints(int[][] points) {
        int n = points.length;
        
     //for single point
        if (n == 1) {
            return 1;
        }
        
        int max = 0;    
        
        for (int i=0; i < n; i++) {
            
          //taking a hashmap to store all slopes of all points to every point
          Map<Double, Integer> map = new HashMap<>();
            for (int j=i+1; j < n; j++) {
                double slope = calculateSlope(points[i], points[j]);
                
              //+1 to include the current point
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            //maximizing it
                max = Math.max(max, map.get(slope));
            }    
        }

        return max + 1;
    }
  
  //calculating slope
    
    private double calculateSlope(int[] p1, int[] p2) {
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];
        
      //if same x axis maximize the x2-x1
        if (x1 == x2) return Double.MAX_VALUE;
        if (y1 == y2) return 0;
      //elese return slope
        return (double) (y2 - y1) / (double) (x2 - x1);
    }
}
