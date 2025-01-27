class Solution {
    public int singleNonDuplicate(int[] nums) {
int n=nums.length;
//using hashmap
/*HashMap<Integer,Integer> mp=new HashMap<>();
for(int num:nums){
 mp.put(num,mp.getOrDefault(num,0)+1);}
 int ans=-1;
 for(int it:mp.keySet()){
 if(mp.get(it)==1){
   ans=it;
    break;}}
  return ans;*/
 /*int xor=0;
 for(int num:nums){
  xor=xor^num;}
    return xor;*/
 //comparing the element;
/*if(n==1) return nums[0];
for(int i=0;i<n;i++){
if(i==0){
if(nums[i]!=nums[i+1]){
return nums[i];} }
else if(i==n-1){
if(nums[i]!=nums[i-1]){
return nums[i];}}
else {
 if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1]){
  return nums[i];}}
        }
            return -1;*/
if(n==1) return nums[0];
//edge cases
 if(nums[0]!=nums[1])
   return nums[0];
if(nums[n-1]!=nums[n-2])
 return nums[n-1];
int low=1;
int high=n-2;
 while(low<=high){
int mid=low+(high-low)/2;
//checking the condition for single Element
if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
  return nums[mid];}
//we if are on left half and single element is on right half as index starts from even odd even odd and then single element come and index become odd even odd even
else if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])) {
  //left half
low=mid+1;}
 else {
high=mid-1;}}
            return -1;








   
        
    }
}