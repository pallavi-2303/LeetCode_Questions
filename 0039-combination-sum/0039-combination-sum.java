class Solution {
 public void CombinationSum1(int[] arr,int idx,List<List<Integer>> ans,int target,List<Integer> ds) {
 //base case
  if(idx==arr.length) {
   if(target==0) {
  ans.add(new ArrayList<Integer>(ds));}
      return;}
  //if we choose given idx
  if(arr[idx]<=target) {
   ds.add(arr[idx]);
  CombinationSum1(arr,idx,ans,target-arr[idx],ds);
      ds.remove(ds.size()-1);}
 //if we dont choose current idx
  CombinationSum1(arr,idx+1,ans,target,ds);
     }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
  List<List<Integer>> ans=new ArrayList<>();
 CombinationSum1(candidates,0,ans,target,new ArrayList<>());
        return ans;
    }
}