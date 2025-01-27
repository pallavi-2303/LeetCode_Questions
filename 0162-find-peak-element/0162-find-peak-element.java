class Solution {
    public int findPeakElement(int[] nums) {
//int n=nums.length;
/*brute force;
if(n==1) return 0;
for(int i=0;i<n;i++){
if(i==0){
if(nums[i]>nums[i+1]) {
  return i;
}
}
else if(i==n-1) {
 if(nums[i]>nums[i-1]){
 return i;
 }
}
else {
if(nums[i]>nums[i+1] && nums[i]>nums[i-1]) {
 return i;}
}
}
return -1;*/
 int n=nums.length;
int low=0;
int high=n-1;
while(low<=high) {
int mid=low+(high-low)/2;
if((mid==0 || nums[mid]>nums[mid-1]) && (mid==n-1 || nums[mid]>nums[mid+1])) {
return mid;
}
else if(nums[mid]<nums[mid+1]) {
low=mid+1;
}
else {
 high=mid-1;
} }
return -1;
        
    }
}