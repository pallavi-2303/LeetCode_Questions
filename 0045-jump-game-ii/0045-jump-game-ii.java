class Solution {
    public int jump(int[] nums) {
    int n=nums.length;
if(n<=1) return 0;
if(nums[0]==0) return -1;
int l=0;
int r=0;
int jumps=0;
while(r<n-1) {
int farthest=0;
for(int i=l;i<=r;i++){
farthest=Math.max(farthest,nums[i]+i);
}
if(farthest<=r) return -1;
l=r+1;
r=farthest;
jumps++;
}
return jumps;    
    }
}