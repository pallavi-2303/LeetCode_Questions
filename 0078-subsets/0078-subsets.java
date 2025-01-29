class Solution {
    public List<List<Integer>> subsets(int[] nums) {
 int n=nums.length;
 List<List<Integer>> ans=new ArrayList<>();
 int subsets=1<<n;
for(int num=0;num<subsets;num++) {
 List<Integer> subset=new ArrayList<>();
  for(int i=0;i<n;i++) {
   //check whether ith bit is set in given number or not 
  if((num & (1<<i))>0) {
   subset.add(nums[i]);}
      }
 ans.add(subset);}
   return ans;
    }
}