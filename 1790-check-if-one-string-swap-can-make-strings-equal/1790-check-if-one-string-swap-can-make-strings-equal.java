class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
     int n1=s1.length();
     int n2=s2.length() ;
     if(n1!=n2)  return false;
     int first=0;
     int second=0;
     int idx1=-1;
     int idx2=-1;
     int count=0;
     while(first<n1 && second<n2){
    if(s1.charAt(first)!=s2.charAt(second)){
        count++;
        if(idx1==-1) idx1=second;
        else idx2=second;
    }
   first++;
   second++;}
   if(count==0) return true;
   if(count==2){
if(s2.charAt(idx1)==s1.charAt(idx2) && s2.charAt(idx2)==s1.charAt(idx1))
return true;
   }
   return false;
    }
}