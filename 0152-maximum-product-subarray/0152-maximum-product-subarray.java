class Solution {
    public int maxProduct(int[] nums) {
     int largestProduct=Integer.MIN_VALUE;
     int n=nums.length;
     //generating all the product
     for(int i=0;i<n;i++) {
    int pro=1;
    for(int j=i;j<n;j++){
        pro*=nums[j];
        largestProduct=Math.max(largestProduct,pro);
    }
     }  
     return largestProduct;
    }
}