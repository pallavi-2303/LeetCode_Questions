class Solution {
    public boolean check(int[] nums) {
    int n=nums.length;
    //since the array is rotated there will be distuebance only once 
    //edge case if array is originally sorted
    if(n==1) return true;
    //There should be disturbance only at one place if array is rotated
    int count=0;
    if(nums[0]<nums[n-1]) count+=1;
    for(int i=1;i<n;i++){
      if(nums[i]<nums[i-1]) {
    //if it is first distanbance
    count+=1;
      } 
      if(count>1) {
        return false;//means array cant be sorted 
      }
    }
return true;//if whole array is travered
    }
}