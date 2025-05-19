class Solution {
    public int findMaxi(int[] child){
int maxi=0;
for(int num:child){
maxi=Math.max(maxi,num);
}
return maxi;}
public void findMin(int idx,int[] cookies,int k,int[] mini,int[] child){
int n=cookies.length;
//if index reaches n means all cookies are distributed find max of particular distribution 
if(idx>=n){
int maxi=findMaxi(child);
mini[0]=Math.min(mini[0],maxi);
return;
}
//try to give this index candy to all children 
//TC-> k^n every child has n possibility Sc-> O(k)
for(int j=0;j<k;j++){
int curr=cookies[idx];
//take;
child[j]=child[j]+cookies[idx];
findMin(idx+1,cookies,k,mini,child);
//backtrack
child[j]=child[j]-curr;
}
}

    public int distributeCookies(int[] cookies, int k) {
       //leetcode 2305
//Since we have to find minimum of all distribution and in one distribution find maximum cookies there are k children we can decide to give a children a cookie or not 
int[] child=new int[k];
int[] mini={Integer.MAX_VALUE};
findMin(0,cookies,k,mini,child);
return mini[0] ;
    }
}