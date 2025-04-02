class Solution {
    public void combination(int idx,int[] nums,List<Integer> temp,int target,List<List<Integer>> res) {
if(idx==nums.length) {
if(target==0) {
res.add(new ArrayList<>(temp));
}
return;}
if(nums[idx]<=target) {
temp.add(nums[idx]);
//call for next index
combination(idx,nums,temp,target-nums[idx],res);
//if we have choosen the index remove that from current
temp.remove(temp.size()-1);
}
//not pick case
combination(idx+1,nums,temp,target,res);
}
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
combination(0,nums,new ArrayList<>(),target,res);
return res;
    }
}