class Solution {
    class sortComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] a,int[] b){
    return a[1]-b[1];    
    }    
    }
    public int eraseOverlapIntervals(int[][] intervals) {
     //how many can be accomodated in one interval
     int n=intervals.length;   
     int count=1;
     Arrays.sort(intervals,new sortComparator());
     int lastlimit=intervals[0][1];
     for(int i=1;i<n;i++){
    if(intervals[i][0]>=lastlimit){
    //this can be accomodated
    count++;
    lastlimit=intervals[i][1];
    }
     }
     return n-count;
    }
}