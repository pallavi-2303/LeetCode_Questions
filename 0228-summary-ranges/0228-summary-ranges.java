class Solution {
    public List<String> summaryRanges(int[] nums) {
      List<String> ans=new ArrayList<>();
int n=nums.length;
for(int i=0;i<n;i++){
int start=nums[i];
while(i+1<n && nums[i]==nums[i+1]-1) {
i++;
}
ans.add(nums[i]==start? Integer.toString(start) : Integer.toString(start)+"->"+Integer.toString(nums[i]));
}
return ans;  
    }
}