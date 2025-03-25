class Solution {
    public int longestConsecutive(int[] nums) {
    /* int maxLen=0;
     int n=nums.length;
HashSet<Integer> st=new HashSet<>();
for(int num:nums) st.add(num);
for(int i=0;i<n;i++){
if(!st.contains(nums[i]-1)){
//it is the first coouucrance
int curr=nums[i];
int count=1;
while(st.contains(curr+1)){
count++;
curr+=1;

}
maxLen=Math.max(maxLen,count);}

}
return maxLen;*/
int n=nums.length;
  int maxcount=0;
 int count=0;
HashSet<Integer> st=new HashSet<>();
for(int num:nums){
 st.add(num);}
 for(int it:st){
if(!st.contains(it-1)){
 //first occurence
int num=it;
count=1;
while(st.contains(num+1)){
count+=1;
num=num+1;}
  maxcount=Math.max(maxcount,count);}}
   return maxcount;
    }
}