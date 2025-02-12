class Solution {
  //  we have to sort the intervals on basis of starting index 
class sortComparator implements Comparator<int[]> {
@Override
public int compare(int[] a,int[] b){
 return a[0]-b[0];
}
}
    public int[][] merge(int[][] arr) {
        int n=arr.length;
Arrays.sort(arr,new sortComparator());
List<List<Integer>> ans=new ArrayList<>();
//Now the intervals is shorted on the basis of starting index
for(int i=0;i<n;i++){
List<Integer> temp=new ArrayList<>();
int ele1=arr[i][0];
int ele2=arr[i][1];
if(ans.size()==0 || ans.get(ans.size()-1).get(1)<ele1) {
temp.add(ele1);
temp.add(ele2);
ans.add(temp);
}
else {
ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),ele2));
}
}
int m=ans.size();
int[][] res=new int[m][2];
for(int i=0;i<m;i++){
res[i][0]=ans.get(i).get(0);
res[i][1]=ans.get(i).get(1);
}
return res;
    }
}