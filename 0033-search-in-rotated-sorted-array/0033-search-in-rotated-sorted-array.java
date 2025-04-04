class Solution {
    public int search(int[] nums, int target) {
    //in rotated sorted array we know that one half of the array will be osted if we will find the mid index we just need to find the soted half  to search the elelemrnt
int n=nums.length;
 int low=0;
int high=n-1;
while(low<=high) {
int mid=(low+high)>>1;
if(nums[mid]==target) return mid;
else if(nums[low]<=nums[mid]){
//means left half is sorted
if(target>=nums[low] && target<=nums[mid]){
high=mid-1;
}
else {
low=mid+1;
}
}
else {
//right half is sorted
if(target>=nums[mid] && target<=nums[high]){
low=mid+1;
}
else {
high=mid-1;
}
}
} 
return  -1; 
    }
}