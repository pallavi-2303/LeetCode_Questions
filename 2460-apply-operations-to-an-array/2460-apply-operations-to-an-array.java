class Solution {
    public int[] applyOperations(int[] nums) {
         int nz=0;
         int n=nums.length;
int i=0;
while(i<n) {
if(i<n-1 && nums[i]!=0 && nums[i]==nums[i+1]){
nums[i] =nums[i]*2;
nums[i+1]=0;
}
if(nums[i]!=0){
if(i!=nz) {
int temp=nums[i];
nums[i]=nums[nz];
nums[nz]=temp;
}
nz++;
}
i++;
}
return nums; 
    }
}