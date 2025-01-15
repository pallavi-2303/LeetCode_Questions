class Solution {
    public int longestOnes(int[] nums, int k) {
      int n=nums.length;
      int maxlen=0;
      //brute force genearting all the subarray
   /* for(int i=0;i<n;i++) {
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
    } */
//optimal aproch of using a sliding window maximum
int l=0;
int r=0;
int zeroes=0;
while(r<n){
if(nums[r]==0) zeroes++;
while(zeroes>k){
if(nums[l]==0){
    zeroes--;
}
//increase l pointer in both casees
l++;
}
maxlen=Math.max(maxlen,r-l+1);
r++;
}
    return maxlen;
    }

}