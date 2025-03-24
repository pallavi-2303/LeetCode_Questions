class Solution {
    public class sortComparator implements Comparator <int[]>{
    public int compare(int[] a,int[] b){
    return a[0]-b[0];
    }
    }
    public int countDays(int days, int[][] meetings) {
    Arrays.sort(meetings,new sortComparator());
    int n=meetings.length;
    List<List<Integer>> res=new ArrayList<>();
    for(int i=0;i<n;i++) {
    if(res.size()==0 || meetings[i][0]>res.get(res.size()-1).get(1)){
    List<Integer> temp=Arrays.asList(meetings[i][0],meetings[i][1]);
  res.add(temp);
    }
    else {
    res.get(res.size()-1).set(1,Math.max(meetings[i][1],res.get(res.size()-1).get(1)));
    }
    }
int countdays=0;
for(int i=0;i<res.size();i++){
countdays+=(res.get(i).get(1)-res.get(i).get(0)+1);
}
return days-countdays;
    }
}