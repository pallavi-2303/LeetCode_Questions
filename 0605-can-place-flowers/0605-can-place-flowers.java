class Solution {
    public boolean canPlaceFlowers(int[] flower, int n) {
   int count=0;
   for(int i=0;i<flower.length;i++) {
if(flower[i]==0 && (i==0 ||flower[i-1]==0) &&(i==flower.length-1 ||flower[i+1]==0)){
flower[i]=1;
count++;
if(count>=n) return true;
}
   }  
   return count>=n;  
    }
}