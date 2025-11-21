package Step6_LinkedList.MediumLL;
/*
 * Problem Statement: Given a linked list containing only 0's,
 *  1's, and 2's, sort the linked list by rearranging the 
 * links (not by changing the data values).

Examples
Input: 1 -> 2 -> 0 -> 1 -> 0 -> 2 -> NULL
Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2 -> NULL

Input: 2 -> 1 -> 2 -> 0 -> 0 -> 1 -> NULL
Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2 -> NULL
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class SortZeroOneTwos {
    public static ListNode sortList(ListNode head){
        if (head==null || head.next==null)
        return head;

        ListNode zerod=new ListNode(-1);
        ListNode oned= new ListNode (-1);
        ListNode twod=new ListNode(-1);
        ListNode zero=zerod;
        ListNode one=oned;
        ListNode two=twod;
//1 -> 2 -> 0 -> 1 -> 0 -> 2 -> NULL
//Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2 -> NULL
        ListNode curr=head;
        while(curr!=null){
            if(curr.val==0){
                zero.next=curr;
                zero=zero.next;
            }
            else if(curr.val==1){
                one.next=curr;
                one=one.next;
            }
            else{
                two.next=curr;
                two=two.next;
            }
            curr=curr.next;

        }
        zero.next=(oned.next!=null)?oned.next:twod.next;
        one.next=twod.next;
        two.next=null;
        return zerod.next;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1,null);
        ListNode temp=head;
        temp.next=new ListNode (2,null);
        temp=temp.next;
        temp.next=new ListNode (0,null);
        temp=temp.next;
        temp.next=new ListNode (1,null);
        temp=temp.next;
        temp.next=new ListNode (0,null);
        temp=temp.next;
        temp.next=new ListNode (2,null);
        head=sortList(head);
        temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }

    }
}
