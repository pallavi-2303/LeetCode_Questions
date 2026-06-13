class Solution {
    class pair{
        char ch;
        int f;
        pair(char ch,int f){
        this.ch=ch;
        this.f=f;
        }
    }
    public String frequencySort(String s) {
     int n=s.length();
     HashMap<Character,Integer> mp=new HashMap<>();
     for(char ch:s.toCharArray()){
    mp.put(ch,mp.getOrDefault(ch,0)+1);
     } 
    PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.f,a.f));
    StringBuilder sb=new StringBuilder();
    for(char k:mp.keySet()){
    int f=mp.get(k);
    pq.offer(new pair(k,f));
    }
    while(!pq.isEmpty()){
    pair it=pq.poll();
    char ch=it.ch;
    int f=it.f;
    for(int i=1;i<=f;i++){
    sb.append(ch);
    }
    }
    return sb.toString();
    }
}