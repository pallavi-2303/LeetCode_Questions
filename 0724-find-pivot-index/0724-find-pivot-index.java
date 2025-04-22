class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
//Brute force 
for(int i=0;i<n;i++){
int left=0;
int right=n-1;
int leftsum=0;
int rightsum=0;
while(left<i){
leftsum+=nums[left++];}
while(right>i){
rightsum+=nums[right--];}
if(leftsum==rightsum){
return i;}}
return -1;
    }
}