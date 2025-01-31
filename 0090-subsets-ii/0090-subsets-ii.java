class Solution {
 public void FindSubsets(int[] arr,int idx,List<List<Integer>> ans,List<Integer> ds) {
 ans.add(new ArrayList<>(ds));
for(int i=idx;i<arr.length;i++) {
  if(i!=idx && arr[i]==arr[i-1])
    continue;
  ds.add(arr[i]);
  FindSubsets(arr,i+1,ans,ds);
 ds.remove(ds.size()-1);
}}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
 Arrays.sort(nums);
 List<List<Integer>> ans=new ArrayList<>();
FindSubsets(nums,0,ans,new ArrayList<>());
        return ans;
    }
}