class Solution {
    public void moveZeroes(int[] nums) {
int n=nums.length;
//optimal aproach 
ArrayList<Integer> temp=new ArrayList<>();
 //storing all non zero element
 for(int i=0;i<n;i++) {
if(nums[i]!=0)  temp.add(nums[i]);
         }
int idx=0;
 for(int it:temp) {
  nums[idx++]=it;}
for(int i=idx;i<n;i++) {
   nums[i]=0;}
         
        
    }
}