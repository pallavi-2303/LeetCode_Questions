class Solution {
    public int[][] insert(int[][] intervals, int[] newIntervals) {
      List<List<Integer>> res=new ArrayList<>();
      int n=intervals.length;
      //finding the left half
      int i=0;
     while(i<n && intervals[i][1] < newIntervals[0]) {
    //means it is the left half
    List<Integer> temp=Arrays.asList(intervals[i][0],intervals[i][1]);
res.add(temp);
i++;
     }  
     //finding the overlaping interval
     while(i<n && intervals[i][0]<=newIntervals[1]){
    newIntervals[0]=Math.min(intervals[i][0],newIntervals[0]);
    newIntervals[1]=Math.max(intervals[i][1],newIntervals[1]);
    i++;
     }
List<Integer> temp=Arrays.asList(newIntervals[0],newIntervals[1]);
res.add(temp);
while(i<n ){
 List<Integer> tem=Arrays.asList(intervals[i][0],intervals[i][1]);
 res.add(tem);
 i++;   
}
int[][] ans=new int[res.size()][2];
for(int idx=0;idx<res.size();idx++){
    ans[idx][0]=res.get(idx).get(0);
    ans[idx][1]=res.get(idx).get(1);
}
return ans;
    }
}