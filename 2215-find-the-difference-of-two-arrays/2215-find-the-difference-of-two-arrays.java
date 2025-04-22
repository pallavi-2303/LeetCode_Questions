class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res=new ArrayList<>();
for(int i=0;i<2;i++){
res.add(new ArrayList<>());}
HashMap<Integer,Integer> mp=new HashMap<>();
//Putting all elements of nums2
for(int num:nums2){
mp.put(num,mp.getOrDefault(num,0)+1);}
for(int num:nums1){
if(!mp.containsKey(num)){
res.get(0).add(num);
mp.put(num,mp.getOrDefault(num,0)+1);}}
//For nums 2
mp.clear();
for(int num:nums1){
mp.put(num,mp.getOrDefault(num,0)+1);}
for(int num:nums2){
if(!mp.containsKey(num)){
res.get(1).add(num);
mp.put(num,mp.getOrDefault(num,0)+1);}}
return res;
    }
}