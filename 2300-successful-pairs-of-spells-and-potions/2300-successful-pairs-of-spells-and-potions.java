class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
//         int n=spells.length;
// int m=potions.length;
// Arrays.sort(potions);
// int[] ans=new int[n];
// // for(int i=0;i<n;i++){
// int count=0;
// for(int j=0;j<m;j++){
// if(spells[i]*potions[j]>=success) {
// count+=(m-j);
// break;
// }
// }
// ans[i]=count;
// }
//we can sort potions and for every spelling we can check the starting index where potions is greater than   and equal to success
int n=spells.length;
int m=potions.length;
Arrays.sort(potions);
int[] ans=new int[n];
for(int i=0;i<n;i++){
int low=0;
int high=m-1;
while(low<=high){
int mid=low+(high-low)/2;
long product=(long)(potions[mid]*spells[i]);
if(product>=success){
high=mid-1;}
else {
low=mid+1;}}
ans[i]=m-low;}
return ans;

    }
}