class Solution {
    public void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
    }
    public int numEquivDominoPairs(int[][] dominoes) {
      // since we have to find pairs we can take number*10+second number
      int[] count=new int[100];
      int res=0;
      int n=dominoes.length;
      for(int i=0;i<n;i++) {
    if(dominoes[i][0]>dominoes[i][1]){
    swap(dominoes[i],0,1);}
    int number=10*dominoes[i][0]+dominoes[i][1];
//how many times this number  is seen previously form that number of pair with current
res+=count[number];
count[number]++;
      }
      return res;
    }
}