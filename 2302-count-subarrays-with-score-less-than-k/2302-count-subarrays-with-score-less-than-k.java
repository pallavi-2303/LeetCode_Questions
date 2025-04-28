class Solution {
    public long countSubarrays(int[] nums, long k) {
     int l=0;
int r=0;
int n=nums.length;
long sum=0;
long count=0;
while(r<n){
sum+=nums[r];
while(sum*(long)(r-l+1)>=k){
sum-=nums[l];
l++;}
count+=(long)(r-l+1);
r++;}
return count;   
    }
}