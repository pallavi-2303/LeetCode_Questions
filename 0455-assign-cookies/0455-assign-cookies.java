class Solution {
    public int findContentChildren(int[] g, int[] s) {
int n=g.length;
int m=s.length;
  Arrays.sort(g);
  Arrays.sort(s);
 int child=0;
 int cookie=0;
 while(child<n && cookie<m) {
 if(g[child]<=s[cookie]) {
  child++;}
   //if the cookie satisfy the children or not we need to move the cookie pointer
    cookie++ ;}
        return child;
              
        
    }
}