class Solution {
    public int pivotIndex(int[] nums) {
     int n=nums.length;
int[] leftsum=new int[n];
int[] rightsum=new int[n];
int left=nums[0];
int right=nums[n-1];
for(int i=1;i<n;i++){
leftsum[i]=left;
left+=nums[i];
rightsum[n-1-i]=right;
right+=nums[n-1-i];}
for(int i=0;i<n;i++){
if(leftsum[i]==rightsum[i]){
return i;}}
return -1;   
    }
}