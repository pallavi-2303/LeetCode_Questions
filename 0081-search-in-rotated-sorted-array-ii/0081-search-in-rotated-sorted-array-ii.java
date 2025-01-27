class Solution {
    public boolean search(int[] nums, int target) {
 int n=nums.length;
 int low=0;
int high=n-1;
   while(low<=high){
  int mid=low+(high-low)/2;
  if(nums[mid]==target){
    return true;}
//for duplicates
if(nums[low]==nums[mid] && nums[mid]==nums[high]){
 low++;
high--;
continue;}
 //finding the sorted part
else if(nums[mid]<=nums[high]){
//mid to end sorted
if(target>=nums[mid] && target<=nums[high]){
low=mid+1;} 
else {
high=mid-1;}}
else {
//low to mid sorted
  if(target>=nums[low] && target<=nums[mid]){
 high=mid-1;}
 else {
low=mid+1;}}}
            return false;
 
        
    }
}