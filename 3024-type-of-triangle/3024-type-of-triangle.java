class Solution {
    public String triangleType(int[] nums) {
       boolean flag=(nums[0]+nums[1]>nums[2] )&& (nums[1]+nums[2]>nums[0] )&& (nums[0]+nums[2]>nums[1]);
if(!flag){
return "none";}
if(nums[0]==nums[1] && nums[1]==nums[2] && nums[0]== nums[2]){
return "equilateral";}
else if(nums[0]!=nums[1] && nums[1]!=nums[2] && nums[0]!=nums[2]){
return "scalene";}
else {
return "isosceles";} 
    }
}