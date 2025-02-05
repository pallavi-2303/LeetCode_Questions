class Solution {
    public int findNumberOfLIS(int[] nums) {
   int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        int maxiLIS=1;
        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
            for(int prev=0;prev<i;prev++){
            //lis condition
                if(nums[i]>nums[prev] && 1+dp[prev]>dp[i]){
                dp[i]=1+dp[prev];
                count[i]=count[prev];
                }
                //it is the time when same lis occur
                else if(nums[i]>nums[prev] && 1+dp[prev]==dp[i]){
                count[i]+=count[prev];
                }
            }//storing the max length of lcs
            maxiLIS=Math.max(maxiLIS,dp[i]);
        }
        int ncs=0;
        for(int i=0;i<n;i++){
        if(maxiLIS==dp[i]) ncs+=count[i];
        }
       return ncs; 
    }
}