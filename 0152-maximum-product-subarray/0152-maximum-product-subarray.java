class Solution {
    public int maxProduct(int[] nums) {
      //brute force generating all the subarray product
//since we have to find the maximum pproduct we can find out leftmax product and rightmax
int n=nums.length;
int leftProduct=1;
int rightProduct=1;
int maxProduct=Integer.MIN_VALUE;
for(int i=0;i<n;i++){
leftProduct=leftProduct==0 ? 1 :leftProduct;
rightProduct=rightProduct==0 ? 1: rightProduct;
leftProduct*=nums[i];
rightProduct*=nums[n-1-i];
maxProduct=Math.max(maxProduct,Math.max(rightProduct,leftProduct));
}
return maxProduct;
    }
}