class Solution {
    public int countSubarrays(int[] nums) {
    int count=0;
    int n=nums.length;
    int k=3;
    for(int i=0;i<=n-k;i++){
    int firstEle=nums[i];
    int secondEle=nums[i+1];
    int thirdEle=nums[i+2];
    if((firstEle+thirdEle)==(secondEle/2.0)) count++;
    }
    return count;   
    }
}