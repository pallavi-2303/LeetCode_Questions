class Solution {
    public void findSum(int[] nums,int idx,int target,int size,List<Integer> temp,List<List<Integer>> res){
int n=nums.length;
//Base case
if(temp.size()==size && target==0){
res.add(new ArrayList<>(temp));
return;}
//trying out all the possible ways
for(int i=idx;i<n;i++){
if(nums[i]>target) break;
//Take and not take;
temp.add(nums[i]);
findSum(nums,i+1,target-nums[i],size,temp,res);
temp.remove(temp.size()-1);
}}
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums={1,2,3,4,5,6,7,8,9};
List<List<Integer>> res=new ArrayList<>();
findSum(nums,0,n,k,new ArrayList<>(),res);
return res;
    }
}