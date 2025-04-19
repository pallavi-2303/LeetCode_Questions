class Solution {
    public int LowerBound(int start,int end,int[] nums,int target){
while(start<end){
int mid=(start+end)/2;
if(nums[mid]<target){
start=mid+1;}
else {
end=mid;}}
return start;}
public int UpperBound(int start,int end,int[] nums,int target){
while(start<end){
int mid=(start+end)/2;
if(nums[mid]<=target){
start=mid+1;}
else {
end=mid;}}
return start;}
    public long countFairPairs(int[] nums, int lower, int upper) {
      long result=0;
      int n=nums.length;
Arrays.sort(nums);
for(int i=0;i<nums.length;i++){
// From i+1 to end how many elements sum are less than lower bound
int left=LowerBound(i+1,n,nums,lower-nums[i]);
int right=UpperBound(i+1,n,nums,upper-nums[i]);
int lc=left-1-i;
int rc=right-1-i;
result+=(rc-lc);}
return result;  
    }
}