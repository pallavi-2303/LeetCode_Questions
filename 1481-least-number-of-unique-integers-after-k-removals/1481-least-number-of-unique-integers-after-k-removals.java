class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
     //since we have to  remove only k  integers and we need least number of uniqueintegers we try to remove elemts whose frequnceis lest so nuber of elemnts becomes less
    HashMap<Integer,Integer> mp=new HashMap<>();
    int n=arr.length;
    for(int i=0;i<n;i++) {
    mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
    }
List<int[]> arr2=new ArrayList<>();
//it will store element and iits frequency
for(Map.Entry<Integer,Integer> it:mp.entrySet()){
int count=it.getValue();
int ele=it.getKey();
arr2.add(new int[]{count,ele});
}
Collections.sort(arr2,(a,b)->Integer.compare(a[0],b[0]));
int idx=0;
while(k>0){
int[] a=arr2.get(idx);
int ele=a[1];
int count=a[0];
k-=count;
if(k<0) break;
idx++;
}
return arr2.size()-idx;

    }
}