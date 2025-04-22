class Solution {
    public boolean uniqueOccurrences(int[] nums) {
       HashMap<Integer,Integer> mp=new HashMap<>();
int n=nums.length;
for(int num:nums){
mp.put(num,mp.getOrDefault(num,0)+1);}
//HashSet to store count if count occurs this already occurred
HashSet<Integer> st=new HashSet<>(); 
for(int key:mp.keySet()){
int count=mp.get(key);
if(st.contains(count)){
return false;}
st.add(count);}
return true; 
    }
}