class Solution {
     public class sortComparator implements Comparator<int[]>{
public int compare(int[] a,int[] b){
return Integer.compare(a[1],b[1]);
}
}
    public int findMinArrowShots(int[][] points) {
     
Arrays.sort(points,new sortComparator());
List<List<Integer>> res=new ArrayList<>();
int n=points.length;
int arrow=1;
int preEnd=points[0][1];
for(int i=1;i<n;i++){
if(points[i][0]>preEnd) {
arrow++;
preEnd=points[i][1];
}
}
return arrow;  
    }
}