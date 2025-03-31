class Solution {
    public int memo(int idx,int[] dp,int[] nums) {
if(idx<0) return 0;
if(idx==0) return nums[0];
if(dp[idx]!=-1) return dp[idx];
int take=nums[idx]+memo(idx-2,dp,nums);
int nottake=0+memo(idx-1,dp,nums);
return dp[idx]=Math.max(take,nottake);
}
    public int rob(int[] nums) {
int n=nums.length;
int[] dp=new int[n];
Arrays.fill(dp,-1);
return memo(n-1,dp,nums);
/*int prev2=0;
prev=nums[0];
dp[0]=nums[0];
for(int i=1;i<n;i++){
int take=nums[i];
if(idx>1)
take+=dp[i-2];
//take+=prev2;
int nottake=dp[i-1];
//int nottake=prev
dp[i]=Math.max(take,nottake);
/*int curr=Math.max(take,nottake);
prev2=prev;
prev=curr;
}
return dp[n];
//return prev;*/
    }
}