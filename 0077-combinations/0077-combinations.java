class Solution {
    public void combination(int start,int n,int k,List<Integer> temp,List<List<Integer>> res){
    if(temp.size()==k){
    res.add(new ArrayList<>(temp));
    return;
    }
if(start> n) return ;
//choose the current element
temp.add(start);
combination(start+1,n,k,temp,res);
temp.remove(temp.size()-1);
combination(start+1,n,k,temp,res);
    }
    public List<List<Integer>> combine(int n, int k) {
List<List<Integer>> res=new ArrayList<>();
combination(1,n,k,new ArrayList<>(),res);
return res;
        
    }
}