class Solution {
    public int maxSubarraySumCircular(int[] nums) {
      //optimal approach 
    // int n=nums.length;
    // int maxsum=Integer.MIN_VALUE;
/*for(int i=0;i<n;i++){
int sum=0;
for(int j=i;j<=n-1+i;j++){
int idx=j%n;
sum+=nums[idx];
maxsum=Math.max(sum,maxsum);
}}*/
/*int sum=0;
for(int i=0;i<=2*n-1;i++){
sum+=nums[i%n];
maxsum=Math.max(sum,maxsum);
if(sum<0) sum=0;
}
return maxsum; */
int n=nums.length;
//let us assume all elements to be in a single array
int maxSum=Integer.MIN_VALUE;
int maxstraightsum=0;
int minSum=Integer.MAX_VALUE;
int minstraightsum=0;
int currsum=0;
for(int num:nums) {
currsum+=num;
maxstraightsum+=num;
if(maxstraightsum>maxSum) {
maxSum=maxstraightsum;
}
if(maxstraightsum<0) {
maxstraightsum=0;}
minstraightsum+=num;
if(minstraightsum<minSum) {
minSum=minstraightsum;
}
if(minstraightsum>0) {
minstraightsum=0;}
}
if(minSum==currsum)
return maxSum;
return Math.max(maxSum,currsum-minSum);
    }
}