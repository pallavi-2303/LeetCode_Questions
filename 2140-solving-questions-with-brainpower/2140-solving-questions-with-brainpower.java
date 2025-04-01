class Solution {
    public long memo(int idx,int[][] arr,long[] dp){
    if(idx>=arr.length) return 0;
    if(dp[idx]!=-1) return dp[idx];
    //choose the current index
    long take=arr[idx][0]+memo(idx+arr[idx][1]+1,arr,dp);
    long nottake=memo(idx+1,arr,dp);
    return dp[idx]=Math.max(take,nottake);
    }
    public long mostPoints(int[][] questions) {
      int n=questions.length;
      long[] dp=new long[n]; 
      Arrays.fill(dp,-1);
      return memo(0,questions,dp);
    }
}