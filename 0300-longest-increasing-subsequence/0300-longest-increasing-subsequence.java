class Solution {
    public int maxLen(int idx,int prev,int[] arr,int[][] dp) {
if(idx==arr.length) return 0;
if(dp[idx][prev+1]!=-1)
return dp[idx][prev+1];
int nottake=0+maxLen(idx+1,prev,arr,dp);
int take=0;
if(prev==-1 || arr[idx]>arr[prev]){
take=1+maxLen(idx+1,idx,arr,dp);
}
return dp[idx][prev+1]=Math.max(take,nottake);
}
    public int lengthOfLIS(int[] arr) {
       int n=arr.length;
int[][] dp=new int[n+1][n+1];
// for(int[] a:dp)
// Arrays.fill(a,-1);
// return maxLen(0,-1,arr,dp); 
int[] pre=new int[n+1];
int[] curr=new int[n+1];
for(int i=n-1;i>=0;i--){
 for(int prev=i-1;prev>=-1;prev--){
  //int nottake=0+dp[i+1][prev+1];
  int nottake=0+pre[prev+1];
  int take=0;
  if(prev==-1 || arr[i]>arr[prev]) {
 // take=1+dp[i+1][i+1];
 take=1+pre[i+1];
  }
 // dp[i][prev+1]=Math.max(take,nottake);
 curr[prev+1]=Math.max(take,nottake);
 }
 pre=curr;
}
//return dp[0][-1+1];
return pre[0];
    }
}