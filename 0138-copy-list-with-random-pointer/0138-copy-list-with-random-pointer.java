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
    //Creating a copyNode and storing its value in hashmap
HashMap<Node,Node> mp=new HashMap<>();
Node temp=head;
while(temp!=null) {
Node copyNode=new Node(temp.val);
mp.put(temp,copyNode);
temp=temp.next;
}
//Connecting the random and next pointer
temp=head;
while(temp!=null) {
Node copyNode=mp.get(temp);
Node nextNode=mp.get(temp.next);
Node Random=mp.get(temp.random);
copyNode.next=nextNode;
copyNode.random=Random;
temp=temp.next;
}
return mp.get(head);    
    }
}