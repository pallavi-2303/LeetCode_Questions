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
   boolean[][] dp=new boolean[n][target+1];
//    for(int[] a:dp) Arrays.fill(a,-1);
// return subset(n-1,nums,target,dp);
for(int i=0;i<n;i++) dp[i][0]=true;
if(nums[0]<=target) dp[0][nums[0]]=true;
for(int i=1;i<n;i++){
for(int tar=1;tar<=target;tar++){
  boolean pick=false;
if(nums[i]<=tar) pick=dp[i-1][tar-nums[i]];
boolean notpick=dp[i-1][tar];
dp[i][tar]=pick|notpick; 
}
}
return dp[n-1][target];
    }
}