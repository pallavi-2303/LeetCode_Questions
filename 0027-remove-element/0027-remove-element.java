class Solution {
    public int removeElement(int[] nums, int val) {
    int n=nums.length;
    int count=0;
    List<Integer> temp=new ArrayList<>();
for(int i=0;i<n;i++){
if(nums[i]!=val){
temp.add(nums[i]);
}}
int idx=0;
for(int num:temp){
nums[idx++]=num;
}
return idx;
    }
}