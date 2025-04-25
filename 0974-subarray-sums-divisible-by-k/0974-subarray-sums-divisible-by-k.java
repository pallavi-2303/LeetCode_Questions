class Solution {
    public int subarraysDivByK(int[] nums, int k) {
    //we there is a subarray divisble by k means sum%k==0 we s1 is divible by k give remainder x and s2 also give remainder x then s1-s2 is also divivle byk
    int n=nums.length;
    int count=0;
    HashMap<Integer,Integer> mp=new HashMap<>();
    mp.put(0,1) ;
    int sum=0;
for(int i=0;i<n;i++) {
sum+=nums[i];
int rem=sum%k;
if(rem<0) rem+=k;
if(mp.containsKey(rem)){
count+=mp.get(rem);
}
mp.put(rem,mp.getOrDefault(rem,0)+1);
} 
return count;
    }
}