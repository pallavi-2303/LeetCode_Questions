class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
    //if we can generate one sequence we can generate other sequence by shifting the values of number by a single constant making sure that it doesnot exceed lower and upper bound
    int curr=0;
    int maxi=0;
    int mini=0;
    //maxi+#<=upperbound and mini+#>=lowerbound range  of alpha should be less than upperbound-maxi and greater than lowerbound-mini
    //a to b b-a +1
    for(int d: differences) {
    curr=curr+d;
    mini=Math.min(mini,curr);
    maxi=Math.max(maxi,curr);
    if((upper-maxi)-(lower-mini)+1<=0){
    return 0;
    }
    } 
    return ((upper-maxi)-(lower-mini))+1;
    }
}