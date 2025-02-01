class Solution {
 public int tabuSum(int[] arr,int sum) {
int n=arr.length;
//int[][] dp=new int[n][sum+1];
int[] prev=new int[sum+1];
int[] curr=new int[sum+1];
//base case
 //idx==0;
for(int tar=0;tar<=sum;tar++) {
 if(tar%arr[0]==0) 
 // dp[0][tar]=tar/arr[0];
  prev[tar]=tar/arr[0];
 //else dp[0][tar]=(int)(1e9);}
  else prev[tar]=(int)(1e9);}
for(int i=1;i<n;i++) {
for(int target=0;target<=sum;target++) {
 //int nottake=0+dp[i-1][target];
int nottake=0+prev[target];
 int take=(int)(1e9);
 if(arr[i]<=target)
 //take=1+dp[i][target-arr[i]];
 take=1+curr[target-arr[i]];
//dp[i][target]=Math.min(take,nottake);
curr[target]=Math.min(take,nottake);}
prev=curr;}
return prev[sum];}
   // return dp[n-1][sum];     }
 public int memoSum(int idx,int[] arr,int target,int[][] dp) {
  if(idx==0) {
 if(target%arr[0]==0) 
  return target/arr[0];
else return (int)(1e9);}
 if(dp[idx][target]!=-1)
         return dp[idx][target];
 int nottake=0+memoSum(idx-1,arr,target,dp);
int take=(int)(1e9);
if(arr[idx]<=target) 
 take=1+memoSum(idx,arr,target-arr[idx],dp);
  return dp[idx][target]=Math.min(take,nottake);}
    public int coinChange(int[] coins, int amount) {
int n=coins.length;
int[][] dp=new int[n][amount+1];
for(int[] a:dp) {
 Arrays.fill(a,-1);}
//int ans=memoSum(n-1,coins,amount,dp);
 int ans=tabuSum(coins,amount);
 return ans==(int)(1e9)?-1:ans;           
        
    }
}