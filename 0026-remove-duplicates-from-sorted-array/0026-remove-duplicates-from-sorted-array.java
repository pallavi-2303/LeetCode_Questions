class Solution {
    public int removeDuplicates(int[] nums) {
      int n=nums.length;
      int index=0;
      for(int i=1;i<n;i++){
    if(nums[index]!=nums[i]){
    nums[++index]=nums[i];
    }
      } 
      return index+1;
    }
}