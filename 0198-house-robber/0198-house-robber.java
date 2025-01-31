class Solution {
    public int memo(int idx,int[] nums,int[] dp){
        //base case if we reacch the 0 index we can take all the money
        if(idx==0) return nums[0];
        if(dp[idx]!=-1) return dp[idx];
    int take=nums[idx];
    if(idx-2>=0){
    take+=memo(idx-2,nums,dp);}
    int nottake=memo(idx-1,nums,dp);
    return dp[idx]=Math.max(take,nottake);
    }
    public int rob(int[] nums) {
    ///we would have two cases that either we can take particular house or not take it
  int n=nums.length;
   int[] dp=new int[n] ; 
   Arrays.fill(dp,-1); 
   return memo(n-1,nums,dp) ;
    }
}