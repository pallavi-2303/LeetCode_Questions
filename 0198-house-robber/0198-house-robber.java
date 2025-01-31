class Solution {
public int Memo(int[] arr,int idx,int[] dp) {
 if(idx<0) return 0;
 if(idx==0) return arr[0];
 if(dp[idx]!=-1) return dp[idx];
int take=arr[idx]+Memo(arr,idx-2,dp);
int nottake=0+Memo(arr,idx-1,dp);
return dp[idx]=Math.max(take,nottake);}
    public int rob(int[] nums) {
 int n=nums.length;
  int[] dp=new int[n];
 //Arrays.fill(dp,-1);
     //return Memo(nums,n-1,dp);
// dp[0]=nums[0];
int prev=nums[0];
int prev2=0;
 for(int i=1;i<n;i++) {
/* int take=nums[i];
if(i>1) {
   take+=dp[i-2];}
int nottake=0+dp[i-1];
dp[i]=Math.max(take,nottake);*/
int take=nums[i]+prev2;
int nottake=0+prev;
int curr=Math.max(take,nottake);
prev2=prev;
 prev=curr;
}
            //return dp[n-1];
    return prev ;
  
    }
}