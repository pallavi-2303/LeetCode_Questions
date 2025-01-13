class Solution {
    public int longestConsecutive(int[] nums) {
  //optimal
  int n=nums.length;
  int maxcount=0;
 int count=0;
HashSet<Integer> st=new HashSet<>();
for(int num:nums){
 st.add(num);}
 for(int i=0;i<n;i++){
if(!st.contains(nums[i]-1)){
 //first occurence
int num=nums[i];
count=1;
while(st.contains(num+1)){
count+=1;
num=num+1;}
  maxcount=Math.max(maxcount,count);}}
   return maxcount;
    }
}