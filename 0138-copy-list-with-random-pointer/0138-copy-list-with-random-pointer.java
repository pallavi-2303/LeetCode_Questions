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
    public void insertCopyNode(Node temp) {
while(temp!=null) {
Node copyNode=new Node(temp.val);
copyNode.next=temp.next;
temp.next=copyNode;
temp=temp.next.next;
}
}
public void connectRandomPointer(Node temp) {
 while(temp!=null) {
 Node copyNode=temp.next;
 if(temp.random!=null) {
 copyNode.random=temp.random.next;
 }
 else {
 copyNode.random=null;
 }
 temp=temp.next.next;
 }
}
public Node deepCopyExtract(Node temp) {
Node dummy=new Node(0);
Node res=dummy;
while(temp!=null) {
res.next=temp.next;
temp.next=temp.next.next;
res=res.next;
temp=temp.next;
}
return dummy.next;
}
    public Node copyRandomList(Node head) {
      //brute force
//creating copyNode and putting in map and then creating the pointers
/*HashMap<Node,Node> mp=new HashMap<>();
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
return mp.get(head);  */
//first step-> Inserting the copy Node inbetween 
insertCopyNode(head);
//step->2 Connecting the Random pointer
connectRandomPointer(head);
//step->3 extrating deep copy and connecting the next pointer
return deepCopyExtract(head);
    }
}