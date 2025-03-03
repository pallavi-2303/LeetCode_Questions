class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
     int n=nums.length;
     int lcount=0;
     int pcount=0;
     int gcount=0;
     for(int num:nums) {
       if(num<pivot) lcount++;
       else if(num>pivot) gcount++;
       else pcount++;
     }  
     int i=0;
     int j=lcount;
     int k=lcount+pcount;
     int[] res=new int[n];
     for(int num:nums){
      if(num<pivot)  {
    res[i++]=num;
      }
      else if(num==pivot){
        res[j++]=num;
      }
      else res[k++]=num;
     }
     return res;
    }
}