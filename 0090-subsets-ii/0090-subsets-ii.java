class Solution {
    public void findSum(int idx,int[] nums,HashSet<List<Integer>> st,List<Integer> temp){
//Base case
if(idx==nums.length){
st.add(new ArrayList<>(temp));
return;}
//Choose case
temp.add(nums[idx]);
findSum(idx+1,nums,st,temp);
//Remove the current 
temp.remove(temp.size()-1);
findSum(idx+1,nums,st,temp);}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
        HashSet<List<Integer>> st=new HashSet<>();
findSum(0,nums,st,new ArrayList<>());
return new ArrayList<>(st);
    }
}