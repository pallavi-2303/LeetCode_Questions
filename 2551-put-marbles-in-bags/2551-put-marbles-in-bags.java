class Solution {
    public long putMarbles(int[] weights, int k) {
    if(k==1) return 0;
     List<Integer> pair=new ArrayList<>();
     int n=weights.length;
    for(int i=0;i<n-1;i++){
    pair.add(weights[i]+weights[i+1]);
    } 
    Collections.sort(pair);
    long maxsum=0;
    long minsum=0;
    for(int i=0;i<k-1;i++){
minsum+=pair.get(i);
maxsum+=pair.get(pair.size()-1-i);
    }
    return maxsum-minsum;
    }
}