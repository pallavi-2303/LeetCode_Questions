class Solution {
public List<Integer> generateCol(int row){
int ans=1;
List<Integer> temp=new ArrayList<>();
temp.add(ans);
for(int col=1;col<row;col++){
ans=(ans*(row-col))/col;
temp.add(ans);}
return temp;}
    public List<List<Integer>> generate(int numRows) {
List<List<Integer>> ans=new ArrayList<>();
for(int i=1;i<=numRows;i++){
 ans.add(generateCol(i));}
   return ans;
        
    }
}