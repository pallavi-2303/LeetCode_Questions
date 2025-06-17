class Solution {
    public int minTaps(int n, int[] taps) {
      //Here we are tracking max distance we can travel from this particular index and index we are taking left most range of i

int[] startEnd=new int[n];
for(int i=0;i<n;i++){
int left=Math.max(0,i-taps[i]);
int right=Math.min(i+taps[i],n);
startEnd[left]=Math.max(right,startEnd[left]);
}
int maxEnd=0;// maximum it can water the plants 
int currEnd=0;//to keep track of taps 
int minTaps=0;
for(int i=0;i<n;i++){
if(i>maxEnd) {
return -1;}
if(i>currEnd){
minTaps++;
currEnd=maxEnd;
}
maxEnd=Math.max(maxEnd,startEnd[i]);
}
return minTaps;  
    }
}