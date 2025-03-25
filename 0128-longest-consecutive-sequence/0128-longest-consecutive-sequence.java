class Solution {
    public boolean Search(int[] arr,int target){
    int n=arr.length;
    for(int i=0;i<n;i++){
    if(arr[i]==target) return true;
    }
    return false;
    }
    public int longestConsecutive(int[] nums) {
    //   int n=nums.length;
    //   int maxcount=0;
    //   //brute force 
    //   for(int i=0;i<n;i++)  {
    // int curr=nums[i];
    // int count=1;
    // while(Search(nums,curr+1)){
    // count++;
    // curr=curr+1;
    // }
    // maxcount=Math.max(count,maxcount);
    //   }
//     HashSet<Integer> st=new HashSet<>();
//     int count=0;
//     for(int num:nums){
//     st.add(num);
//     }
//     //iterate through all the elements
//     for(int i=0;i<n;i++){
// //if curr is fist occuence 
// if(!st.contains(nums[i]-1)){
//  count=1;
// int num=nums[i];
// while(st.contains(num+1)){
// count+=1;
// num=num+1;
// }
// maxcount=Math.max(count,maxcount);
// }
//     }
//       return maxcount;
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