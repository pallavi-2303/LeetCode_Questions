class Solution {
    public int candy(int[] nums) {
int n=nums.length;
/*int[] left=new int[n];
int[] right=new int[n];
left[0]=1;
right[n-1]=1;
for(int i=1;i<n;i++){
if(nums[i]>nums[i-1]) {
left[i]=left[i-1]+1;
}
else {
left[i]=1;
}
}
for(int i=n-2;i>=0;i--) {
if(nums[i]>nums[i+1]) {
right[i]=right[i+1]+1;
}
else {
right[i]=1;
}
}
int sum=0;
for(int i=0;i<n;i++){
sum+=Math.max(right[i], left[i]);
}
return sum;*/  
int[] left=new int[n];
left[0]=1;
for(int i=1;i<n;i++){
if(nums[i]>nums[i-1]){
left[i]=left[i-1]+1;
}
else {
left[i]=1;
}
}
int sum=Math.max(left[n-1],1);
int right=1;
for(int i=n-2;i>=0;i--){
if(nums[i]>nums[i+1]){
right=right+1;
}
else {
right=1;
}
sum+=Math.max(left[i],right);}
return sum;
    }
}