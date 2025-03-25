class Solution {
    public int hIndex(int[] citations) {
    int n=citations.length;
    int[] arr=new int[n+1];
     for(int it:citations){
    if(it>n) arr[n]++;
    else {
arr[it]++;
    }
     } 
int count=0;
for(int i=n;i>=0;i--) {
count+=arr[i];
if(count>=i) return i;
} 
return 0;//not possbiile
    }
}