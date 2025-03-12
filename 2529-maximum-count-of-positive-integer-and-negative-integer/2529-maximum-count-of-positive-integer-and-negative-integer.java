class Solution {
    public int maximumCount(int[] nums) {
       int n=nums.length;
int pos=0;
int neg=0;
for(int number:nums){
if(number>0) pos++;
else if(number<0) neg++;}
return Math.max(pos,neg); 
    }
}