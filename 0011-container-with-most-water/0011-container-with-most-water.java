class Solution {
    public int maxArea(int[] nums) {
       int n=nums.length;
int i=0;
int j=n-1;
int maxi=0;
while(i<j){
int area=Math.min(nums[i],nums[j])*(j-i);
maxi=Math.max(area,maxi);
if(nums[i]<nums[j]){
i++;}
else {
j--;}}
return maxi; 
    }
}