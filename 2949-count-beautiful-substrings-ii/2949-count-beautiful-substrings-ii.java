class Solution {
    public boolean isVowel(char ch){
    return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    public long beautifulSubstrings(String s, int k) {
    int n=s.length();
    //number psum vowel count and how many times this vowel count occur
  HashMap<Long,HashMap<Long,Long>> mp=new HashMap<>();
long result=0;
mp.put(0L,new HashMap<>());
mp.get(0L).put(0L,1L);///prefic sum vowel count and how manyy times this has occur;
long v=0;
long c=0;
for(char ch:s.toCharArray()){
if(isVowel(ch)) v++;
else c++;
long pSum=v-c;
for(Map.Entry<Long,Long> e:mp.getOrDefault(pSum,new HashMap<>()).entrySet()){
long pastVowelCnt=e.getKey();
long count=e.getValue();
//substring starating after that will have same nuber of vweol and consotant count;
if((v%k-pastVowelCnt)*(v%k-pastVowelCnt)%k==0){
result+=count;
}
}
mp.computeIfAbsent(pSum,K->new HashMap<>()).merge(v%k,1L,Long::sum);
}
return result;
    }
}