class Solution {
    public long maximumTripletValue(int[] nums) {
long maxi=Long.MIN_VALUE;
int n=nums.length;
for(int i=0;i<n;i++){
for(int j=i+1;j<n;j++){
for(int k=j+1;k<n;k++){
long value=(long)(nums[i]-nums[j])*nums[k];
maxi=Math.max(value,maxi);
}
} }
if(maxi<0) return 0;
return   maxi;
    }
}