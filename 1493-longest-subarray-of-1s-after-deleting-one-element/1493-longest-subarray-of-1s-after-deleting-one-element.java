class Solution {
    public int longestSubarray(int[] nums) {
//        int n=nums.length;
// int sum=0;
// for(int num:nums)
// sum+=num;
// if(sum==n) return n-1;
// int maxi=0;
// for(int i=0;i<n;i++){
// int zero=0;
// for(int j=i;j<n;j++){
// if(nums[j]==0) zero++;
// if(zero<=1){
// maxi=Math.max(maxi,j-i+1);}}}
// return maxi-1; 
int n=nums.length;
int maxi=0;
int l=0;
int r=0;
int zero=0;
while(r<n){
if(nums[r]==0) {
zero++;}
while(zero>1){
if(nums[l]==0){
zero--;}
l++;}
maxi=Math.max(maxi,r-l+1);
r++;}
return maxi-1;
    }
}