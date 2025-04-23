class Solution {
    public int equalPairs(int[][] grid) {
     //oprimal storing all rows in hashmap and then iterating through all columns and finding how many similar rows are present this will give equivalent pair count 
     int n=grid.length;
HashMap<String,Integer> mp=new HashMap<>();
for(int i=0;i<n;i++){
String temp="";
for(int j=0;j<n;j++){
temp+=grid[i][j]+"+";
}
mp.put(temp,mp.getOrDefault(temp,0)+1);
}
int count=0;
for(int j=0;j<n;j++){
String temp="";
for(int i=0;i<n;i++){
 temp+=grid[i][j]+"+";
}
if(mp.containsKey(temp)) {
count+=mp.get(temp);
}
}
return count;   
    }
}