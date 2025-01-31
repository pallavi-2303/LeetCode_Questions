class Solution {
 public void FindcombinationSum(int[] arr,int idx,int target,List<List<Integer>> ans,List<Integer> ds) {
 //base case
 if(target==0) {
  ans.add(new ArrayList<>(ds));
     return ;}
for(int i=idx;i<arr.length;i++){
 if(i>idx && arr[i]==arr[i-1])
     continue;
if(arr[i]>target) break;
 //pick
    ds.add(arr[i]);
  FindcombinationSum(arr,i+1,target-arr[i],ans,ds);
   ds.remove(ds.size()-1);}
     }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
List<List<Integer>> ans=new ArrayList<>();
Arrays.sort(candidates);
 FindcombinationSum(candidates,0,target,ans,new ArrayList<>());
                    
    return ans;
    }
}