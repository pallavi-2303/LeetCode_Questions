class Solution {
    public boolean carsPossible(int[] ranks,int cars,long time){
    long carsreq=0;
    for(int num:ranks){
    carsreq+=(long)(Math.sqrt((1*time)/num));
    if(carsreq>=cars) return true;
    }
    return false;
    }
    public long repairCars(int[] ranks, int cars) {
    long ans=0;
    long low=0;
    long high=0;
    for(int num:ranks) {
    low=Math.min(low,num);
    high=Math.max(num,high);
    }   
    high=high*cars*cars;
    while(low<=high){
    long mid=low+(high-low)/2;
    if(carsPossible(ranks,cars,mid)){
    ans=mid;
    high=mid-1;
    }
    else {
    low=mid+1;
    }
    }
    return ans;
    }
}