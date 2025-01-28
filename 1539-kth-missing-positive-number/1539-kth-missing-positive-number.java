class Solution {
    public int findKthPositive(int[] arr, int k) {
    int n=arr.length;
   /* for(int i=0;i<n;i++)  {
        if(arr[i]<=k){
            k++;
        }
        else {
            break;
        }
    }  
    return k;*/
    //optimal aproach of binary search as array is sorted
//We are able to find the nearby index between which a ekement can oocur we can get the answr
//number if missing is equal to arr[idx]-idx+1;
//high will point to lower index 
//answer->arr[high]+more missing->
//arr[high]-(high+1) more->k-missing
//k-(arr[high]-(high+1))
//arr[high]+k-arr[high]+(high+1)
//high+1+k
int low=0;
int high=n-1;
while(low<=high) {
int mid=low+(high-low)/2;
int missing=arr[mid]-(mid+1);
if(missing<k) {
 low=mid+1;
}
else {
high=mid-1;
}
}
return high+1+k;//low+k;
    }
}