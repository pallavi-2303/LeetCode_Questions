class Solution {
public boolean isPossible(int[] points,long target,int m){
long move=0;
long normalMove=0;
long advanceMove=0;
int n=points.length;
for(int i=0;i<n && move<=m ;i++){
long score=points[i];
long games=(target+score-1)/score;//(long)Math.ceil((double)target/(double)score);
if(advanceMove>=games) {
advanceMove=0;//at this index no need to play any game
normalMove=1;
}
else {
long pastScore=advanceMove*score;
games=(target+score-pastScore-1)/score;
    
    //(long)Math.ceil((double)(target-pastScore)/(double)score);
move+=(2*games)-1;
advanceMove=Math.max(0,games-1);
move+=normalMove;
normalMove=0;
}  
}

    return move<=m;
}
    public long maxScore(int[] points, int m) {
long low=1;
long high=(long)1e15;
long res=0;
while(low<=high){
long mid=low+(high-low)/2;
if(isPossible(points,mid,m)) {
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