class Solution {
    public int maxProduct(int[] nums) {
    Arrays.sort(nums);
    if(nums.length==1) return nums[nums.length-1]-1;
    return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}