class Solution {
    int n1;
    int n2;
    HashMap<String,Integer> mp;
    public int upperBound(int target,int[] arr){
    int l=0;
    int h=n2;
while(l<h){
int mid=l+(h-l)/2;
if(arr[mid]>target){
h=mid;
}
else l=mid+1;
}
return l;
    }
    public int solve(int idx,int prev,int[] arr1,int[] arr2){
if(idx>=n1) return 0;
String key=prev+"_"+idx;
if(mp.containsKey(key)) return mp.get(key);
int res1=(int)1e9+1;
//if current is greater than prev
if(arr1[idx]>prev){
res1=solve(idx+1,arr1[idx],arr1,arr2);
}
int res2=(int)1e9+1;
int ub=upperBound(prev,arr2);
if(ub!=n2){
res2=1+solve(idx+1,arr2[ub],arr1,arr2);
}
mp.put(key,Math.min(res1,res2));
return Math.min(res1,res2);
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
     //we the rray is strictly increaing then previoulsy we can jsut move to next ndex but sometime it will give us wrong snwer so when array i strckly increaing we need to try both
     n1=arr1.length;
     n2=arr2.length;
     mp=new HashMap<>();
Arrays.sort(arr2);
int res= solve(0,Integer.MIN_VALUE,arr1,arr2);
return res==(int)1e9+1 ? -1 :res;
    }
}