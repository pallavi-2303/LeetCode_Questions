class Solution {
    public int singleNumber(int[] nums) {
    HashMap<Integer,Integer> mp=new HashMap<>();
    for(int num:nums) mp.put(num,mp.getOrDefault(num,0)+1);
    int ans=-1;
    for(int it:mp.keySet()) {
    if(mp.get(it)==1) return it;
    }
    return ans;
    }
}