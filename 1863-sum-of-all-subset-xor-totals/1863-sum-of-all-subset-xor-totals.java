class Solution {
    public int subsetXORSum(int[] nums) {
     int or=0;
     int n=nums.length;
     for(int num:nums) {
    or|=num;
     }
     return or*(1<<(n-1)) ; 
    }
}