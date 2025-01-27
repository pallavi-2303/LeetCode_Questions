class Solution {
    public int search(int[] nums, int target) {
     //in rotated soted array we know that one part of the array will be sorted aswe rotate array only at a point
     int n=nums.length;
     int low=0;
     int high=n-1;
     while(low<=high) {
    int mid=low+(high-low)/2;
if(nums[mid]==target) return mid;
//identify the sorted half
if(nums[low]<=nums[mid]){
//left  half is sorted
//check wheater tthe target lies betwwen the sorted half
if(target>=nums[low] && target<=nums[mid]){
high=mid-1;
}
else {
low=mid+1;
}
} 
else {
//other half is sorted
if(target>=nums[mid] && target<=nums[high]){
low=mid+1;
}
else {
    high=mid-1;
}
} 
     } 
     return -1;//if the  target  is not present in array 
    }
}