class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
     //since we have to find out the count of subarray whose array% mod is equal to k and count module is also equal to k

     //from l to r count should also be divisble by k      long result=0;
    int n=nums.size();
//     for(int i=0;i<n;i++){
//    int count=0;
//     for(int j=i;j<n;j++){
//     if(nums.get(j)%modulo==k){
//     count++;
//     }
//     if(count%modulo==k) result+=1;
//     }
//     } 
//     return result;  
//if nums[j] is divied by module it increaes to 1 count so if we store it as cumulative sum  1 or 0 it can give us actual count from i to j if s1 % m is divisilbe by  m and gve remainder k and give  s2 aso give remaider k tthen s1 -s2 is also divible by m s1-s2%m==k r1 -r2 %m=k r2=r1-k+m%m;
long result=0;
long sum=0;
HashMap<Integer,Long> mp=new HashMap<>();
mp.put(0,1L);
for(int i=0;i<n;i++){
if(nums.get(i)%modulo==k) sum+=1;
int r1=(int)sum%modulo;
int r2=(r1-k+modulo)%modulo;
if(mp.containsKey(r2)){
result+=mp.get(r2);
}
mp.put(r1,(long)mp.getOrDefault((long)r1,0L)+1);
}
return result;
    }
}