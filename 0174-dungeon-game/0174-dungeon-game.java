class Solution {
int n;
int m;
HashMap<String,Boolean> mp;
public boolean canReach(int health,int[][] dungeon,int i,int j){
if(i>=n || j>=m) return false;
health+=dungeon[i][j];
if(health<=0) return  false;
if(i==n-1 && j==m-1) return true;
String curr=i+"_"+j+"_"+health;
if(mp.containsKey(curr)){
return mp.get(curr);
}
boolean reach=canReach(health,dungeon,i+1,j) || canReach(health,dungeon,i,j+1);
mp.put(curr,reach);
return reach;
}
    public int calculateMinimumHP(int[][] dungeon) {
    //brute force aproch of binary search
n=dungeon.length;
m=dungeon[0].length;
int low=1;
int high=4*(int)1e7;
int result=high;
mp=new HashMap<>();
while(low<=high){
int mid=low+(high-low)/2;
mp.clear();
if(canReach(mid,dungeon,0,0)){
result=mid;
high=mid-1;
}
else{
low=mid+1;
}
}
return result;
    }
}