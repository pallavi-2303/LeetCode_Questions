class Solution {
    public int findSteps(int[] tops,int[] bottom,int val){
int n=tops.length;
int topswap=0;
int bottomswap=0;
for(int i=0;i<n;i++){
if(tops[i]!=val && bottom[i]!=val){
return -1;}
else if(tops[i]!=val){
topswap++;}
else if(bottom[i]!=val) bottomswap++;}
return Math.min(topswap,bottomswap);}
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //since the values on domminos are fixed we can use brute force and try to check for every value.
int result=Integer.MAX_VALUE;
int n=tops.length;
for(int val=1;val<=6;val++){
int steps=findSteps(tops,bottoms,val);
if(steps!=-1)
result=Math.min(result,steps);
}
return result==Integer.MAX_VALUE ? -1 :result;
    }
}