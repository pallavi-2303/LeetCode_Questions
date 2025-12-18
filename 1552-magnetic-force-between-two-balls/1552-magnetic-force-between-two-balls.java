class Solution {
    public boolean canPlace(int[] position,int mid,int m){
    int n=position.length;
    int ball=1;
    int lastPos=position[0];
    for(int i=1;i<n;i++){
    if(position[i]-lastPos>=mid){
    ball++;
    lastPos=position[i];
    }
    }
    return ball>=m;
    }
    public int maxDistance(int[] position, int m) {
     //since we have to find the min of max the find the max force we will apply buinary search on answer check if this force can be present between very basket by keep checking for evry force 
  //we will sort the bacset so that we can keep track of the force
int n=position.length;
Arrays.sort(position);
int low=1;
int high=position[n-1]-position[0];
int res=0;
while(low<=high) {
int mid=low+(high-low)/2;
if(canPlace(position,mid,m)){
res=mid;
low=mid+1;
}
else {
high=mid-1;
}
}  
return res;    
    }
}