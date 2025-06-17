class Solution {
    public long minimumReplacement(int[] nums) {
        int n=nums.length;
        long minOperations=0;
for(int i=n-2;i>=0;i--){
if(nums[i]<=nums[i+1]){
continue;
}
int parts=(int)Math.ceil((double)nums[i]/nums[i+1]);
minOperations+=(long)parts-1;
nums[i]=nums[i]/parts;
}
return minOperations;
    }
}