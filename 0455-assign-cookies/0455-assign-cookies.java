class Solution {
    public int findContentChildren(int[] g, int[] s) {
       int n=g.length;
       int m=s.length;
       //since s is children and g is greed factor we will first sort both of thsse array
       Arrays.sort(s) ;
       Arrays.sort(g);
       int cookie=0;
       int child=0;
       while(child<n && cookie<m){
        if(s[cookie]>=g[child]){
        //we can assign this to current child
        child++;
        cookie++;
        }
        else {
            cookie++;
        }
       }
       return child;
    }
}