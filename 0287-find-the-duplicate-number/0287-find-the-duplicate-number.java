class Solution {
    public int findDuplicate(int[] nums) {
//     int n=nums.length;
//     HashSet<Integer> st=new HashSet();
//     for(int num:nums)  {
//     if(st.contains(num)){
//     return num;
//     }
// else {
// st.add(num);
// }
//     } 
//     return -1; 
//we are teating nums as a linkkedlist
int slow=nums[0];
int fast=nums[0];
//to find the cycle 
do{
slow=nums[slow];
fast=nums[nums[fast]];
} while(slow!=fast);
fast=nums[0];
while(slow!=fast){
slow=nums[slow];
fast=nums[fast];
}
return slow;


     }
}