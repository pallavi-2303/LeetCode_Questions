class Solution {
    public int wiggleMaxLength(int[] nums) {
    //we just have to find the sequnce with maximum length
int n=nums.length;
if(n<2) return n;
int prev=nums[1]-nums[0];
int count=prev==0 ? 1 :2;
int diff=0;
for(int i=2;i<n;i++){
diff=nums[i]-nums[i-1];
if((prev<=0 && diff>0) || (prev>=0 && diff<0)){
prev=diff;
count++;
}
}

return count;
    }
}