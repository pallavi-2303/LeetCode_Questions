class Solution {
    public class sortComparator implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
    return a[0]-b[0];
    }
    }
    public int[][] merge(int[][] intervals) {
    //sort the intervals  on  ascending order of zeroth element
    int n=intervals.length; 
    Arrays.sort(intervals,new sortComparator());
    List<List<Integer>> res=new ArrayList<>();
    for(int i=0;i<n;i++) {
    if(res.size()==0 || intervals[i][0] >res.get(res.size()-1).get(1)){
    List<Integer> temp=Arrays.asList(intervals[i][0],intervals[i][1]);
    res.add(temp);   
    }
    //if 0th element is smaller than the 1st element of res then merge
    else {
    res.get(res.size()-1).set(1,Math.max(intervals[i][1],res.get(res.size()-1).get(1)));
    }
    }
    int m=res.size();
int[][] ans=new int[m][2];
for(int i=0;i<m;i++){
ans[i][0]=res.get(i).get(0);
ans[i][1]=res.get(i).get(1);
}
return ans;
    }
}