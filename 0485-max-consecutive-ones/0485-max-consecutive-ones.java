class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
     int n=nums.length;
     int maxcount=0;
     //generating all pairs 
//      for(int i=0;i<n;i++)  {
// int j=i;
// while(j<n && nums[j]!=0){
//     j++;
// }
// maxcount=Math.max(maxcount,j-i);
//      } 
//      return maxcount;
//optimal aproch
int sum=0;
for(int i=0;i<n;i++){
sum+=nums[i];
if(sum>maxcount){
maxcount=sum;
}
if(nums[i]==0) sum=0;
}
return maxcount;
    }
}