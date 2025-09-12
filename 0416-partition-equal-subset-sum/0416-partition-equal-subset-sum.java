class Solution {
    int n;
    public boolean solve(int idx,int[] nums,int target,int[][] dp){
    if(target==0){
    return true;
    }
    if(idx>=n){
    return target==0;
    }
  //we have two cases wheather to take this index for subset or not take it

  if(dp[idx][target]!=-1){
return dp[idx][target]==1 ? true :false;
  }
 boolean take=false;
  if(nums[idx]<=target) {
take=solve(idx+1,nums,target-nums[idx],dp);
  } 
  boolean nottake=solve(idx+1,nums,target,dp);
 dp[idx][target]=(take | nottake)==true ? 1 :0;
  return take | nottake;
    }
    public boolean canPartition(int[] nums) {
      //if the total sum of all the array is odd then it wont be possible to devide the subset in two parts as it will neverr give a equal sum and now we if are given a even aray sum array it is possible to devide it intwo parts
     n=nums.length;
      int totalSum=0;
      for(int num:nums){
      totalSum+=num;  
      }  
    if(totalSum%2==1) return false;
    int target=totalSum/2;//means is a subset can contain this sum
    int[][] dp=new int[n+1][target+1];
   // for(int[] a:dp) Arrays.fill(a,-1);
   // return solve(0,nums,target,dp);
  for(int tar=0;tar<=target;tar++){
dp[n][tar]=tar==0 ? 1 :0;
  }
   for(int i=0;i<n;i++){
dp[i][0]=1;
   }
for(int i=n-1;i>=0;i--){
for(int tar=1;tar<=target;tar++){
boolean take=false;
if(nums[i]<=tar){
take=dp[i+1][tar-nums[i]]==1 ? true : false;
}
boolean nottake=dp[i+1][tar]==1 ? true : false;
dp[i][tar]=(take|nottake) ? 1 :0;
}
}
return dp[0][target]==1 ? true : false;
    }
}