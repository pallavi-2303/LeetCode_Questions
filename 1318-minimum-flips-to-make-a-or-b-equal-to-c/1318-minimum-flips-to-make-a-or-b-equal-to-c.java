class Solution {
    public int minFlips(int a, int b, int c) {
    //for 0 if bthe are 1 we need to flip both but if we need 1 any bit flippe gve the answer
    int flip=0;
    while(a!=0 || b!=0 || c!=0) {
    //if mst of c is 1
    if((c&1)==1){
    if((a&1)==0 && (b&1)==0) flip++;
    }
    else {
    if((a&1)==1) flip++;
    if((b&1)==1) flip++;
    }
    a>>=1;
    b>>=1;
    c>>=1;
    }  
    return flip; 
    }
}