class Solution {
int n;
TreeSet<int[]> main;
TreeSet<int[]> sec;//to store elelments both in ascending order
HashMap<Integer,Integer> mp;//to store frequency 
long sum=0;
public void addToSet(int[] p,int x){
if(main.size()<x || compareToPair(p,main.first())>0){
//the current pair is bigger than smallest element
main.add(p);
sum+=1L*p[0]*p[1];
if(main.size()>x) {
int[] smallest=main.first();
main.remove(smallest);
sum-=1L*smallest[0]*smallest[1];
sec.add(smallest);
}
}
else {
//add this in secondary 
sec.add(p);
}
}
public void removeFromSet(int[] p,int x){
//first check if its present in main
if(main.contains(p)) {
sum-=1L*p[0]*p[1];
main.remove(p);
if(!sec.isEmpty()) {
int[] largest=sec.last();
sec.remove(largest);
main.add(largest);
sum+=1L*largest[0]*largest[1];
}
}
else {
sec.remove(p);
}
}
public int compareToPair(int[] a,int[] b){
if(a[0]!=b[0]){
return Integer.compare(a[0],b[0]);
}
else return Integer.compare(a[1],b[1]);
}
    public long[] findXSum(int[] nums, int k, int x) {
n=nums.length;
mp=new HashMap<>();
Comparator<int[]> comp=(a,b)->{
if(a[0]!=b[0]) 
return Integer.compare(a[0],b[0]);//on basis of frequency 
else return Integer.compare(a[1],b[1]);//on basis of numbers 
};
main=new TreeSet<>(comp);
sec=new TreeSet<>(comp);
List<Long> res=new ArrayList<>();
int l=0;
int r=0;
    while(r<n) {
int num=nums[r];
//check if this element already exist in nums
if(mp.getOrDefault(num,0)>0){
//remove its frequency 
removeFromSet(new int[]{mp.get(num),num},x);
}
mp.put(num,mp.getOrDefault(num,0)+1);
addToSet(new int[]{mp.get(num),num},x);
//if size reaches x
if(r-l+1==k){
res.add(sum);
int outLook=mp.get(nums[l]);
removeFromSet(new int[]{outLook,nums[l]},x);
mp.put(nums[l],mp.get(nums[l])-1);
if(mp.get(nums[l])==0){
mp.remove(nums[l]);
}
else {
addToSet(new int[]{mp.get(nums[l]),nums[l]},x);
}
l++;
}
    r++;
    }
long[] result=new long[res.size()];
for(int i=0;i<res.size();i++){
result[i]=res.get(i);
}
        return result;
        
    }
}