class Solution {
    public void combination2(int idx,int[] nums, List<List<Integer>> res,List<Integer> temp,int target) {
if(target==0){
res.add(new ArrayList<>(temp));
return;
}
//start from the index and try out combination 
for(int i=idx;i<nums.length;i++){
if(i!=idx && nums[i]==nums[i-1]) 
continue;
//if this index is greater than current then element aftaer that will be greater only 
if(nums[i]>target) break;
temp.add(nums[i]);
combination2(i+1,nums,res,temp,target-nums[i]);
//if the function returns remove the added element 
temp.remove(temp.size()-1);
}
}
    public void combination(int idx,HashSet<List<Integer>> st,List<Integer> temp,int[] nums,int target) {
if(idx==nums.length) {
if(target==0){
st.add(new ArrayList<>(temp));
}
return;
}
if(nums[idx]<=target) {
temp.add(nums[idx]);
combination(idx+1,st,temp,nums,target-nums[idx]);
//if added remove the current
temp.remove(temp.size()-1);
}
//not pick case
combination(idx+1,st,temp,nums,target);
}
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
      HashSet<List<Integer>> st=new HashSet();
      Arrays.sort(nums);
       combination(0,st,new ArrayList<>(),nums,target);
       return new ArrayList<>(st);
    }
}