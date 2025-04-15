class Solution {
    public int maxProduct(int[] nums) {
      //brute force generating all the subarray product
      int max=Integer.MIN_VALUE;
      int n=nums.length;
      for(int i=0;i<n;i++) {
    int ans=1;
    for(int j=i;j<n;j++){
    ans*=nums[j];
    max=Math.max(ans,max);
    }
      } 
      return max;
    }
}