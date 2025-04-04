class Solution {
    public int singleNonDuplicate(int[] nums) {
      /*int xor=0;
      for(int num:nums) {
        xor=xor^num;
      }
      return xor; */
     /* int n=nums.length;
      if(n==1) return nums[0];
for(int i=0;i<n;i++) {
if(i==0 && nums[i]!=nums[i+1]){
return nums[i];
} 
else if(i==n-1 && nums[i] !=nums[i-1] ){
    return nums[i];
}
else if(i!=0 && i!=n-1){
if(nums[i] !=nums[i-1] && nums[i]!=nums[i+1]){
    return nums[i];
}
}
}
return -1;*/
//we know that if we are on odd index if we get same elelemt in even index this means we areon right half of single element
int n=nums.length;
if(n==1) return nums[0];
if(nums[0]!=nums[1]) return nums[0];
if(nums[n-1]!=nums[n-2]) return nums[n-1];
int low=1;
int high=n-2;
while(low<=high){
int mid=low+(high-low)/2;
//comparing with mid
if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
    return nums[mid];
}
//if we are on left half and single element is not right halh
if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1]) ){
low=mid+1;
}
else {
high=mid-1;
}
}
return -1;//if not found
    }
}