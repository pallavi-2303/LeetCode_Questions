class Solution {
    public int singleNonDuplicate(int[] nums) {
   /* int xor=0;
      for(int num:nums){
    xor=xor^num;
      } 
      return xor; */
    int n=nums.length;
    if(nums[0]!=nums[1]) return nums[0];
    if(nums[n-1]!=nums[n-2]) return nums[n-1];
   /* for(int i=1;i<n-1;i++){
    if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
    return nums[i];
    }
    }*/
int low=1;
int high=n-2;
while(low<=high){
int mid=(low+high)>>1;
if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
    return nums[mid];
}
else if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])){
//we are on left side of single elelemt
low=mid+1;
}
else {
high=mid-1;
}
}
    return -1;
    }
}