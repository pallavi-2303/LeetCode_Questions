class Solution {
public boolean findDivisionResult(int[] nums,int divisor,int threshold) {
 int n=nums.length;
 int sum=0;
 for(int i=0;i<n;i++){
 sum+=Math.ceil((double)nums[i]/(double)divisor);
 }
 return sum<=threshold;
}
  public int findMax(int[] arr) {
 int maxi=Integer.MIN_VALUE;
 for(int num:arr) {
 maxi=Math.max(maxi,num);
 }
 return maxi;}
    public int smallestDivisor(int[] nums, int threshold) {
       int low=1;
int high=findMax(nums);
// for(int i=low;i<=high;i++){
// if(findDivisionResult(nums,i, threshold)){
//  return i;
// }
// else continue;
// }
// return -1;
//binary Search
while(low<=high){
int mid=low+(high-low)/2;
if(findDivisionResult(nums,mid, threshold)) {
// ans=mid;
high=mid-1;
}
else {
 low=mid+1;
}
}
//return ans;
return low; 
    }
}