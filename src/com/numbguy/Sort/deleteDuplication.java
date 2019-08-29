package com.numbguy.Sort;

import com.numbguy.Structure.ListNode;

public class deleteDuplication {
    public static void deleteDuplication(ListNode head) {
        if(head == null)
            return;

        ListNode preNode = head;
        ListNode current = head;

        while(current != null) {

            ListNode nextNode = current.next;

            if(nextNode != null&&nextNode.equals(current)) {
                ListNode duplicateNode = nextNode;
                while(nextNode != null&&nextNode.equals(duplicateNode)) {
                    duplicateNode = nextNode;
                    nextNode = nextNode.next;
                }
            }
            current.next = nextNode;
            current = nextNode;
        }
    }

    public static void main(String[] args) {
        //"abbccddeeeefr"
        ListNode head = ListNode.constuctList("abbcddddddssseefg");
        ListNode.printListNode(head);
        deleteDuplication(head);
        System.out.println();
        ListNode.printListNode(head);
    }
}
