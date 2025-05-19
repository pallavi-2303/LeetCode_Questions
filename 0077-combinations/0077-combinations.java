class Solution {
    //leetcode 77
public void find(int idx,List<Integer> temp,int n,int k,List<List<Integer>> res){
if(temp.size()==k){
res.add(new ArrayList<>(temp));
return;
}
//TC-> 2^n
//Sc->O(n) 
for(int i=idx;i<=n;i++){
//Take case
temp.add(i);
find(i+1,temp,n,k,res);
//Backtrack
temp.remove(temp.size()-1);
}
}
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> res=new ArrayList<>();
find(1,new ArrayList<>(),n,k,res);
return res; 
    }
}