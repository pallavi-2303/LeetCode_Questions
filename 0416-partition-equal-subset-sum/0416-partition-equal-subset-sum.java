class Solution {
    public boolean findSubset(int idx,int target,int[] nums,int[][] dp){
    //base case
if(target==0) return true;
if(idx==0)
return nums[0]==target;
if(dp[idx][target]!=-1) return dp[idx][target]==1 ? true :false;
boolean take=false;
if(nums[idx]<=target){
take=findSubset(idx-1,target-nums[idx],nums,dp);
}
//nottake case
boolean nottake=findSubset(idx-1,target,nums,dp);
 dp[idx][target]=(take||nottake) ? 1:0;
 return take||nottake;
    }
    public boolean canPartition(int[] nums) {
   //we can devide an array in subset if and only if sum if even if sum is odd we will not be able to devide in 2 subset
    int sum=0;
    int n=nums.length;
    for(int num:nums) sum+=num;
    if(sum%2==1)   return false;
    int target=sum/2;
int[][] dp=new int[n][target+1];
for(int[] a:dp) Arrays.fill(a,-1);
return findSubset(n-1,target,nums,dp);
    }
}