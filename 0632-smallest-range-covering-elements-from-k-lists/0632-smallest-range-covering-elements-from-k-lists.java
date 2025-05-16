class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
      //since we are traveling through the entire the  array to find minimum element we can use priority queue to find min element
//it stores min element listidx and element idx
PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
//initially add all 0th element of every list
int k=nums.size();
int[] range={-100000,100000};
int maxElement=Integer.MIN_VALUE;
//TC-> k*logk logk for pq insertion
for(int i=0;i<k;i++){
pq.add(new int[]{nums.get(i).get(0),0,i});
maxElement=Math.max(maxElement,nums.get(i).get(0));
}
//TC-> n*logk n is number of elemnt  min of all size lt n*logk sc->0(k)
while(!pq.isEmpty()){
int[] it=pq.poll();
int minElement=it[0];
int eleIdx=it[1];
int listIdx=it[2];
if(maxElement-minElement<range[1]-range[0]){
range[0]=minElement;
range[1]=maxElement;
}
int nextEleIdx=eleIdx+1;
if(nextEleIdx>=nums.get(listIdx).size()){
break;
}
else {
pq.add(new int[]{nums.get(listIdx).get(nextEleIdx),nextEleIdx, listIdx});
maxElement=Math.max(maxElement,nums.get(listIdx).get(nextEleIdx));
}
}
return range;  
    }
}