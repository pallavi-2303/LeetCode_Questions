class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      //by using power set
      int n=nums.length;
      List<List<Integer>> ans=new ArrayList<>();
      int subsets=(1<<n);
      for(int num=0;num<subsets;num++){
        List<Integer> temp=new ArrayList<>();
        //checking weather the iith bit of particular number is set or not
        for(int i=0;i<n;i++){
        if((num&(1<<i))>0){
        //its ith bit is set so numsi can be added
temp.add(nums[i]);
        }
        }
        ans.add(temp);
      }
return ans;
    }
}