class Solution {
    public int longestOnes(int[] nums, int k) {
      int n=nums.length;
      int maxlen=0;
      //brute force genearting all the subarray
    for(int i=0;i<n;i++) {
        int zeroes=0;
        for(int j=i;j<n;j++){
        if(nums[j]==0) zeroes++;
        //finding the length if zeroes is less than or equal to k
        if(zeroes<=k){
        maxlen=Math.max(maxlen,j-i+1);
        }
        else {
            break;
        }
        }
    } 
    return maxlen;
    }
}