class Solution {
    public int maxSubArray(int[] nums) {
      int n=nums.length;
      /*brute force generating all subaaray sum and finding out the maximum of all
      int maxSum=Integer.MIN_VALUE;
      for(int i=0;i<n;i++)  {
        int sum=0;
        for(int j=i;j<n;j++){
            sum+=nums[j];
            maxSum=Math.max(maxSum,sum);
        }
      }
      return maxSum;*/
      //better apraoch of using the kedanes algorithm if summ becomes less than zero then it is not going to contribute to the maxsum so make it zero
      int maxSum=Integer.MIN_VALUE;
      int sum=0;
      for(int i=0;i<n;i++){
sum+=nums[i];
if(sum>maxSum){
    maxSum=sum;
}
if(sum<0) sum=0;
      }
return maxSum;
    }
}