class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
     //since intervals are sorted we need to just find overlapping interval
List<List<Integer>> res=new ArrayList<>();
int n=intervals.length;
int i=0;
//finding the correct left half
while(i<n && intervals[i][1]<newInterval[0]) {
List<Integer> temp=Arrays.asList(intervals[i][0],intervals[i][1]);
i++;
res.add(temp);
}
//finding the overlapping interval
while(i<n && intervals[i][0]<=newInterval[1]) {
newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
i++;
}
List<Integer> tem=Arrays.asList(newInterval[0],newInterval[1]);
res.add(tem);
//finding the right half
while(i<n) {
List<Integer> temp=Arrays.asList(intervals[i][0],intervals[i][1]);
i++;
res.add(temp);
}
int[][] ans=new int[res.size()][2];
for(int idx=0;idx<res.size();idx++){
ans[idx][0]=res.get(idx).get(0);
ans[idx][1]=res.get(idx).get(1);
}
return ans;   
    }
}