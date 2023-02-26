class Solution {
    public int minDistance(String word1, String word2) {

        //Kind Of Like LCS prroblem
        int n = word1.length();
        int m = word2.length();



        //base case
if(n==0 &&m==0){
    return 0;
}

//creating a dp array for the subproblems
        int[][] dp = new int[n+1][m+1];

for(int[] a : dp){
    Arrays.fill(a,-1);
}
        return  mem(word1,word2,n,m,dp);
    }


    static int mem(String word1, String word2, int n, int m,  int[][] dp){

        //if one string is empty and other is not then the max oper would be the non empty string's length

        if(m-1<0 && n-1>=0){
return n;
        }

        if(m-1>=0 && n-1<0){
            return m;
        }

//if both are empty then 0
        if(m-1<0 && n-1<0){
            return 0;
        }


        //if we have solved the subproblem before then return it
        if(dp[n-1][m-1]!=-1){
            return dp[n-1][m-1];
        }





//no oper is added if characters are same 
if(word1.charAt(n-1)==word2.charAt(m-1)){
   return dp[n-1][m-1]= mem(word1,word2,n-1,m-1,dp);
}
else

//we going all three ways 
// insert
//delete
//replace
//and taking the min one 
       return dp[n-1][m-1] = 1+Math.min(mem(word1,word2,n,m-1,dp),Math.min(mem(word1,word2,n-1,m,dp),mem(word1,word2,n-1,m-1,dp) ));
    }
}


//just needed the intution lol:)








