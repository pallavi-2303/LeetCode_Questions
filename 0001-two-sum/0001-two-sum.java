class Solution {
    public int[] twoSum(int[] nums, int target) {
      int n=nums.length;
      //brute force ->generating all the subarray and finding out the sum
      int[] ans={-1};
      for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
       if(nums[i]+nums[j]==target) {
        ans=new int[]{i,j};
       }    
        }
      }
return ans;
    }
}