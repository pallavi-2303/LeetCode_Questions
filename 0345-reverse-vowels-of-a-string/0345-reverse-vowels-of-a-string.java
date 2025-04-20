class Solution {
public boolean isVowel(char ch){
return ch=='a' || ch=='e' ||ch=='i' ||ch=='o' ||ch=='u' ||ch=='A' ||ch=='E' ||ch=='I' ||ch=='O' ||ch=='U' ;
}
    public String reverseVowels(String s) {
    //since string are imutable in java we have to convet it in array of string
    char[] word=s.toCharArray();
int start=0;
int end=word.length-1;
while(start<end){
while(start<end && !isVowel(word[start])){
start++;
}
while(start<end && !isVowel(word[end])){
end--;
}
if(start<end){
//both pointer are standing at vowel index swapp
char temp=word[start];
word[start]=word[end];
word[end]=temp;
start++;
end--;
}

}
String str=new String(word);
return str;
    }
}