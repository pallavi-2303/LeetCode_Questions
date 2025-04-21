class Solution {
    public double findMaxAverage(int[] nums, int k) {
       //Since K is fixed so we have to find maxSum and devide that by k
//Calculating initial window sum
double sum=0;
int n=nums.length;
for(int i=0;i<k;i++){
sum+=nums[i];}
double maxi=sum;
for(int i=k;i<n;i++){
sum=sum+nums[i];
sum=sum-nums[i-k];
maxi=Math.max(maxi,sum);}
return (double)maxi/k; 
    }
}