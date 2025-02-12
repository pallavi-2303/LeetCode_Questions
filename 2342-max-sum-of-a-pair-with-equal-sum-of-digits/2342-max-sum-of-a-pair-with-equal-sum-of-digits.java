class Solution {
    public int sumDigit(int num){
    int sum=0;
    while(num>0){
    int rem=num%10;
    sum+=rem;
    num/=10;
    }
    return sum;
    }
    public int maximumSum(int[] nums) {
    int n=nums.length;
    //sum  of digits ,number
    HashMap<Integer,Integer> mp=new HashMap<>() ; 
     int maxi=-1;
     for(int i=0;i<n;i++) {
    int sum=sumDigit(nums[i]);
    if(mp.containsKey(sum)){
   int first=mp.get(sum);
   maxi=Math.max(maxi,first+nums[i]);
    }
    mp.put(sum,Math.max(nums[i],mp.getOrDefault(sum,0)));
     }
     return maxi;
    }
}