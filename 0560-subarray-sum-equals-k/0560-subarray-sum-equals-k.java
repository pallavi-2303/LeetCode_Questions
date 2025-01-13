class Solution {
    public int subarraySum(int[] nums, int k) {
//brute force
//generating all the subarray
int n=nums.length;
int count=0;
/*for(int i=0;i<n;i++){
int sum=0;
for(int j=i;j<n;j++){
sum+=nums[j];
if(sum==k){
count++;}}}
   return count;*/
//optimal aproach of using hashMap
HashMap<Integer,Integer> mp=new HashMap<>();
mp.put(0,1);
int sum=0;
for(int i=0;i<n;i++){
sum+=nums[i];
//remaining sum
int remSum=sum-k;
if(mp.containsKey(remSum)){
count=count+mp.get(remSum);}
mp.put(sum,mp.getOrDefault(sum,0)+1);}
  return count;
 
    }
}