class Solution {
    public long countBadPairs(int[] nums) {
    long count=0;
    //brute force
    long n=nums.length;
    /*for(int i=0;i<n;i++) {
    for(int j=i+1;j<n;j++){
        if((j-i)!=(nums[j]-nums[i])){
        count++;
        }
    }
    } 
    return count;*/
    //The condition can be further modified with j-nums[j]=i-nums[i] pairs are good pairs
long totalPairs=n*(n-1)/2;
long goodPairs=0;
HashMap<Integer,Integer> mp=new HashMap<>();
for(int i=0;i<n;i++){
int val=i-nums[i];
//if it is previouly present tham it will form one pair
long prevCount=mp.getOrDefault(val,0);
goodPairs+=prevCount;
mp.put(val,mp.getOrDefault(val,0)+1);
}
return (totalPairs-goodPairs);
    }
}