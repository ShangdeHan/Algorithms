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

    /*
    82. Remove Duplicates from Sorted List II
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    Return the linked list sorted as well.
    Example1:
    Input: head = [1,2,3,3,4,4,5]
    Output: [1,2,5]
    Example2:
    Input: head = [1,1,1,2,3]
    Output: [2,3]
     */

    public ListNode deleteDuplicates2(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }
    /*
        25. Reverse Nodes in k-Group
        Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
        k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
        is not a multiple of k then left-out nodes, in the end, should remain as it is.
        Example1:
        Input: head = [1,2,3,4,5], k = 2
        Output: [2,1,4,3,5]

        Example2:
        Input: head = [1,2,3,4,5], k = 3
        Output: [3,2,1,4,5]

        Example3:
        Input: head = [1,2,3,4,5], k = 1
        Output: [1,2,3,4,5]

        Example4:
        Input: head = [1], k = 1
        Output: [1]
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        while(count!=k && current!=null){//find k+1
            count++;
            current = current.next;
        }
        if(count == k){
            current = reverseKGroup(current, k);
            while(count>0){
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
                count--;
            }
            head = current;
        }
        return head;
    }

    /*
    206. Reverse Linked List
    Given the head of a singly linked list, reverse the list, and return the reversed list.
    Example1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Example2:
    Input: head = [1,2]
    Output: [2,1]

    Example3:
    Input: head = []
    Output: []
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode current = head;
        int count = 0;
        while(current.next!= null){
            current = current.next;
            count++;
        }
        current = null;
        while(count >= 0){
            ListNode temp = head.next;
            head.next = current;
            current = head;
            head = temp;
            count--;
        }
        head = current;
        return head;
    }
}
