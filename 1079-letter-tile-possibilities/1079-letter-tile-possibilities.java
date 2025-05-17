class Solution {
public void solve(String tiles,boolean[] used,HashSet<String> res,StringBuilder curr){
//base case add current sequence 
res.add(curr.toString());
for(int i=0;i<tiles.length();i++){
if(used[i]){
continue;}
used[i]=true;
curr.append(tiles.charAt(i));
solve(tiles,used,res,curr);
//Backtrack after return back
curr.deleteCharAt(curr.length()-1);
used[i]=false;}}
    public int numTilePossibilities(String tiles) {
         //basic backtracking solution is by storing all the subsequences
HashSet<String> res=new HashSet<>();
int n=tiles.length();
boolean[] used=new boolean[n];
solve(tiles,used,res,new StringBuilder());
return res.size()-1;//exclude one for the empty string   
    }
}