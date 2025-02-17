class Solution {
public void backTrack(String tiles,String curr,boolean[] used,HashSet<String> st) {
//if the character already exist
if(st.contains(curr)) return;
st.add(curr);
for(int i=0;i<tiles.length();i++){
if(used[i]) continue;
used[i]=true;
backTrack(tiles,curr+tiles.charAt(i),used,st);
used[i]=false;
}
}
    public int numTilePossibilities(String tiles) {
      int n=tiles.length();
HashSet<String> st=new HashSet<>();
boolean[] used=new boolean[n];
Arrays.fill(used,false);
backTrack(tiles,"",used,st);
return st.size()-1;  
    }
}