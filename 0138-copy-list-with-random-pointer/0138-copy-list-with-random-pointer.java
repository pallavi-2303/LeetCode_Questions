/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      //brute force
//creating copyNode and putting in map and then creating the pointers
HashMap<Node,Node> mp=new HashMap<>();
Node temp=head;
while(temp!=null){
Node copyNode=new Node(temp.val);
mp.put(temp,copyNode);
temp=temp.next;
}
//creating the next and random pointers 
temp=head;
while(temp!=null){
Node copyNode=mp.get(temp);
copyNode.next=mp.get(temp.next);
copyNode.random=mp.get(temp.random);
temp=temp.next;
}
return mp.get(head);  
    }
}