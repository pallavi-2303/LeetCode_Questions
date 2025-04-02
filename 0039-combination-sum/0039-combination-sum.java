class Solution {
    public void solve(int idx,List<List<Integer>> res,List<Integer> ds,int target,int[] nums) {
int n=nums.length;
if(idx==n) {
if(target==0) {
 res.add(new ArrayList<>(ds));}
return ; 
 }
//pick case we can pick unlimited number of times
if(nums[idx]<=target) {
ds.add(nums[idx]);
//we can pick unlimited number of times
solve(idx,res,ds,target-nums[idx],nums);
//not pick case
ds.remove(ds.size()-1);}
solve(idx+1,res,ds,target,nums);}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans=new ArrayList<>();
       solve(0,ans,new ArrayList<>(),target,candidates);
       return ans;
    }
}