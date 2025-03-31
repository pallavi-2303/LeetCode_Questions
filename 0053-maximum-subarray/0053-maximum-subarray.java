class Solution {
    public int maxSubArray(int[] nums) {
     int maxsum=Integer.MIN_VALUE;
     int sum=0;
     for(int num:nums){
    sum+=num;
    maxsum=Math.max(sum,maxsum);
    if(sum<0) sum=0;
     } 
     return maxsum;  
    }
}