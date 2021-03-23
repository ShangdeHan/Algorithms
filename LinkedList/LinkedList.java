public class LinkedList {
    /*
    21. Merge Two Sorted Lists
    Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

    Example 1:
    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    Example 2:
    Input: l1 = [], l2 = []
    Output: []

    Example 3:
    Input: l1 = [], l2 = [0]
    Output: [0]
     */
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode n = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                n.next = l1;
                l1=l1.next;
            }else{
                n.next = l2;
                l2=l2.next;
            }
            n = n.next;
        }
        if(l1==null)n.next=l2;
        else n.next = l1;
        return l3.next;
    }

/*
    83. Remove Duplicates from Sorted List
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
    Example 1:
    Input: head = [1,1,2]
    Output: [1,2]

    Example 2:
    Input: head = [1,1,2,3,3]
    Output: [1,2,3]
 */



    public ListNode deleteDuplicates(ListNode head) {
        ListNode n = head;
        while(n!= null && n.next != null){
            if(n.next.val == n.val){
                n.next = n.next.next;
            }else{
                n=n.next;
            }
        }
        return head;
    }
}
