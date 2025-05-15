class Solution {
    public int findLowerBound(int[] nums,int target){
int low=0;
int high=nums.length-1;
int fo=-1;
while(low<=high){
int mid=(low+high)>>1;
if(nums[mid]==target){
fo=mid;
high=mid-1;}
else if(target>nums[mid]) {
low=mid+1;}
else{
  high=mid-1;}  }
return fo;}
public int findUpperBound(int[] nums,int target){
int low=0;
int high=nums.length-1;
int lo=-1;
while(low<=high){
int mid=(low+high)>>1;
if(nums[mid]==target){
lo=mid;
low=mid+1;}
else if(target<nums[mid]){
high=mid-1;}
else {
low=mid+1;}}
return lo;}
    public int[] searchRange(int[] nums, int target) {
      int n=nums.length;
int fo=findLowerBound(nums,target);
int lo=findUpperBound(nums,target);
int[] ans={fo,lo};
return ans;  
    }
}