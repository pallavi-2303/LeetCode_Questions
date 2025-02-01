class Solution {
public boolean subset(int idx,int[] arr,int target,int[][] dp){
    if(target==0) return true;
    if(idx==0){
    if(target==0 || arr[0]==target) return true;
    return false;
    }
if(dp[idx][target]!=-1) return dp[idx][target]==0 ? false :true;
boolean pick=false;
if(arr[idx]<=target) pick=subset(idx-1,arr,target-arr[idx],dp);
boolean notpick=subset(idx-1,arr,target,dp);
dp[idx][target]=pick|notpick==true ? 1:0;
return pick|notpick;
}
    public boolean canPartition(int[] nums) {
     //sum of one part will be sum/2;
     int total=0;
     for(int num:nums)  total+=num;
     int n=nums.length;
   // if it canot be divided  
   if(total%2!=0) return false;
   int target=total/2;
   int[][] dp=new int[n][target+1];
   for(int[] a:dp) Arrays.fill(a,-1);
return subset(n-1,nums,target,dp);

    }
}