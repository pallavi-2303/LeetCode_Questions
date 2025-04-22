class Solution {
    public int largestAltitude(int[] gain) {
     int n=gain.length;
int maxi=0;
int curr=0;
for(int i=0;i<n;i++){
curr=curr+gain[i];
maxi=Math.max(curr,maxi);}
return maxi;   
    }
}