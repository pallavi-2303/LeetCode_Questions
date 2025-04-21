class Solution {
    public int maxOperations(int[] nums, int k) {
       int n=nums.length;
Arrays.sort(nums);
int i=0;
int j=n-1;
int count=0;
while(i<j){
int sum=nums[i]+nums[j];
if(sum==k){
count++;
i++;
j--;}
else if(sum<k){
i++;}
else {
j--;}}
return count; 
    }
}