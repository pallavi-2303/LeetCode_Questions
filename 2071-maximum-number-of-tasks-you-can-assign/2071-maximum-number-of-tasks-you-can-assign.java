class Solution {
    public boolean  canPerform(int[] task, int[] workers, int pills, int strength,int mid){
    int p=pills;
    //here we will try to  assin greter tak to strongest  worer  sothat low strength worker can  perform  weak task and try to give pills to weak workers so that theyy can pperfform strong task;
TreeMap<Integer,Integer> ws=new TreeMap<>();
//keep worker in ascending order
for(int i=workers.length-mid;i<workers.length;i++){
ws.put(workers[i],ws.getOrDefault(workers[i],0)+1);
}
//performthe task from strongest worker 
for(int i=mid-1;i>=0;i--){
Integer key=ws.lastKey();
if(key>=task[i]){
ws.put(key,ws.get(key)-1);
if(ws.get(key)==0){
ws.remove(key);
}
}
else {
//worrkers need  apill to perform task
if(p==0) return false;
//find ceil key 
key=ws.ceilingKey(task[i]-strength);
if(key==null) return false;
ws.put(key,ws.get(key)-1);
if(ws.get(key)==0)  ws.remove(key);
p--;
}
} 
return true;
    }
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
   //since we have to assign the maximum number of task that can be assigned we can use use binary seearhc on answer to check if this umber of  task can be done or not 
int n=tasks.length;
int m=workers.length;
Arrays.sort(tasks);
Arrays.sort(workers);
int low=0;
 int high=Math.min(n,m) ;//number of task to be performed or workers avaibale
 int result=0;
 while(low<=high) {
int  mid=low+(high-low)/2;
if(canPerform(tasks,workers,pills,strength,mid)){
result=mid;
low=mid+1;
}
else {
high=mid-1;
}
 } 
 return result;
    }
}