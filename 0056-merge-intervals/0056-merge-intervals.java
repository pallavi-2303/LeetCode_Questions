class Solution {
public class ArrayComparator implements Comparator<int[]>{
@Override
public int compare(int[] a,int[] b){
    return a[0]-b[0];//sort o index in ascending order
}
}
    public int[][] merge(int[][] intervals) {
     //sorting the intervals on basis of 0 index 
     int n=intervals.length;
     int m=intervals[0].length;
     ArrayComparator mc=new ArrayComparator();
     Arrays.sort(intervals,mc);
     List<List<Integer>> ans=new ArrayList<>();
    for(int i=0;i<n;i++)   {
        if(ans.size()==0 || ans.get(ans.size()-1).get(1)<intervals[i][0]){
        //it is sorted and it  is not overlaping
        List<Integer> temp=Arrays.asList(intervals[i][0],intervals[i][1]);
        ans.add(temp);
        }
        else {
       //intervals 1 is not greater than it is overlaping 
       ans.get(ans.size()-1).set(1,Math.max(intervals[i][1],ans.get(ans.size()-1).get(1))) ;   
        }
    }                                                       
int size=ans.size();
int[][] result=new int[size][2];
for(int i=0;i<size;i++){
    result[i][0]=ans.get(i).get(0);
     result[i][1]=ans.get(i).get(1);
}
return result;
    }
}