class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int n=nums.length;
      int minLen=Integer.MAX_VALUE;
      //brute force
   /*   for(int i=0;i<n;i++){
    int sum=0;
    for(int j=i;j<n;j++){
sum+=nums[j];
if(sum>=target){
minLen=Math.min(j-i+1,minLen);
break;
}
    }
      }
    return minLen==Integer.MAX_VALUE?0:minLen;*/
//using sliding window maximum 
int l=0;
int r=0;
int sum=0;
while(r<n){
sum+=nums[r];
while(sum>=target){
minLen=Math.min(minLen,r-l+1);
sum-=nums[l];
l++;
}
r++;
}
return minLen==Integer.MAX_VALUE?0:minLen;

    }
}