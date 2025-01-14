class Solution {
    public List<Integer> majorityElement(int[] nums) {
     int n=nums.length;
     HashMap<Integer,Integer> mp=new HashMap<>() ;
     //putting all the elements in hashmap
     for(int it:nums){
    mp.put(it,mp.getOrDefault(it,0)+1);
     }
     List<Integer> ans=new ArrayList<>();
     for(int it:mp.keySet()){
    if(mp.get(it)>n/3){
        ans.add(it);
    }
     }
     return ans;
    }
}