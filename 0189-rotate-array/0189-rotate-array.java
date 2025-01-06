class Solution {
    public void rotate(int[] nums, int k) {
      //rotate by using an external array
      int n=nums.length;
      int[] ans=new int[n]; 
      k=k%n;
      if(k==n) return ;//if come back to original 
      //first start from n-k index and go to last
      int idx=0;
      for(int i=n-k;i<n;i++){
ans[idx++]=nums[i];
      }
      //now put 0 to n-k in array
      for(int i=0;i<n-k;i++){
        ans[idx++]=nums[i];
      }
      //puuting all ellements in nums
      for(int i=0;i<n;i++){
        nums[i]=ans[i];
      }
    }
}