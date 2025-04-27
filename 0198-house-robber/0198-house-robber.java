class Solution {
    public int findProfit(int idx,int[] nums,int[] dp){
    if(idx<0) return 0;
    if(idx==0) return nums[0];
    if(dp[idx]!=-1) return dp[idx];
int take=nums[idx]+findProfit(idx-2,nums,dp);
int nottake=0+findProfit(idx-1,nums,dp);
return dp[idx]=Math.max(take,nottake);
    }
    public int rob(int[] nums) {
    int n=nums.length;
    int[] dp=new int[n];
    Arrays.fill(dp,-1);
    return findProfit(n-1,nums,dp) ;  
    }
}