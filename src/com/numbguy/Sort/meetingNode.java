package com.numbguy.Sort;

import com.numbguy.Structure.ListNode;

public class meetingNode {
    public static ListNode meetingNode(ListNode head) {
        if(head == null)
            return null;

        ListNode slow = head.next;
        if(slow == null)
            return null;

        ListNode fast = slow.next;

        while(slow != null&&fast != null) {
            if(slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null)
                fast = fast.next;
        }
        return null;
    }

    public static ListNode getEntryOfLoop(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        ListNode current = meetingNode;
        int nodesInLoop = 0;

        while(meetingNode != current||nodesInLoop==0) {
            nodesInLoop++;
            current = current.next;
        }
        System.out.println(nodesInLoop);
        ListNode node1 = head;
        ListNode node2 = head;

        for(int i = 0;i < nodesInLoop;i++)
            node1 = node1.next;

        while(node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    public static void main(String[] args) {
        ListNode circleHead = ListNode.constructCircleListNode(" fghijkl");
        ListNode straightHead = ListNode.constuctList("abcde");
        ListNode.getTailNode(straightHead).next = circleHead;


        System.out.println(getEntryOfLoop(straightHead));
    }
}
