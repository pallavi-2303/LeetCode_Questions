class Solution {
    public void buildTree(int idx,int l,int r,int[] baskets,int[] segmentTree){
    //base case
    if(l==r){
    segmentTree[idx]=baskets[l];
    return;
    }
    //go to left side
    int m=(l+r)/2;
    buildTree(2*idx+1,l,m,baskets,segmentTree);
    buildTree(2*idx+2,m+1,r,baskets,segmentTree);
     segmentTree[idx]=Math.max(segmentTree[2*idx+1],segmentTree[2*idx+2]);
    }
public boolean findQuery(int idx,int l,int r,int[] segmentTree,int fruit){
  //base case check
  if(segmentTree[idx]<fruit) {
return false;
  } 
if(l==r){
segmentTree[idx]=-1;
return true;
}
boolean placed=false;
//if we can go left
int mid=l+(r-l)/2;
if(segmentTree[2*idx+1]>=fruit){
placed=findQuery(2*idx+1,l,mid,segmentTree,fruit);
}
else {
 placed=findQuery(2*idx+2,mid+1,r,segmentTree,fruit);   
}
segmentTree[idx]=Math.max(segmentTree[2*idx+1],segmentTree[2*idx+2]);
return placed;
}
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        //since we have to search from left to right and find max value that can hold given basket means range queries we can use segement tree
        int[] segmentTree = new int[4 * n];
        buildTree(0, 0, n - 1, baskets, segmentTree);
    int unplaced=0;
    for(int fruit:fruits){
    boolean placed=findQuery(0,0,n-1,segmentTree,fruit);
    if(!placed){
      unplaced++;  
    }

    }
return unplaced;
    }
}