class Solution {
    public int mostBooked(int n, int[][] meetings) {
        //brute force 
//since we have to do earlier start meeting first we will sort the array on basis of start time 
Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
int[] roomUsedCount=new int[n];
long[] lastAvailableRoom=new long[n];
boolean found;// track if a empty room is found 
for(int[] a:meetings) {
int st=a[0];
int end=a[1];
int duration=end-st;
found=false;
int earlyEndRoom=-1;
long earlyEndRoomTime=Long.MAX_VALUE;
for(int room=0;room<n;room++){
if(lastAvailableRoom[room]<=st) {
lastAvailableRoom[room]=end;
roomUsedCount[room]++;
found=true;
break;
}
if(lastAvailableRoom[room]<earlyEndRoomTime){
earlyEndRoomTime=lastAvailableRoom[room];
earlyEndRoom=room;
}
}
//if no room is assigned assign the room that has smaller value
if(!found) {
roomUsedCount[earlyEndRoom]++;
lastAvailableRoom[earlyEndRoom]+=(duration);
}
}
int roomResult=-1;
int maxCount=0;
for(int room=0;room<n;room++){
if(roomUsedCount[room]>maxCount){
maxCount=roomUsedCount[room];
roomResult=room;
}
}
return roomResult;
    }
}