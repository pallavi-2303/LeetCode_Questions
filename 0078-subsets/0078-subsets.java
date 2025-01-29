class Solution {
// public void findSubsets(int idx,int[] nums,List<Integer> temp,List<List<Integer>> res,int size){
//     //base case
//     if(idx==size){
//         res.add(new ArrayList<>(temp));}
//         return;
//     }
//     //let us pick the current element index
//    temp.add(nums[idx]);
//     //function call for next elelement
//     findSubsets(idx+1,nums,temp,res,size);
//     //after the idx reches n and it priints the first subsequence remove the lst elelemt 
//     temp.remove(temp.size()-1);
//     //not pick case for the current index
//     findSubsets(idx+1,nums,temp,res,size);
// }
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans=new ArrayList<>() ;
   // List<Integer> temp=new ArrayList<>();
   /* int n=nums.length;
    findSubsets(0,nums,temp,ans,n);  
    return ans;*/
    //power set
    int n=nums.length;
  int subsets=1<<n;
  //finding out for for the numbers from 0 to 7  wheater the ith bit is set or not
  for(int num=0;num<subsets;num++) {
List<Integer> temp=new ArrayList<>();
for(int i=0;i<n;i++){
//check whewgetr the ith bit is set for givrn number or not
if((num&(1<<i))>0){
temp.add(nums[i]);
}
}
ans.add(temp);
  }
  return ans;
    }
}