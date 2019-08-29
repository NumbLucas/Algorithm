package com.numbguy.Structure;

import com.numbguy.Sort.meetingNode;

import java.util.Objects;

public class ListNode {
    public Object value;
    public ListNode next = null;

    public ListNode() {}

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return Objects.equals(value, listNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public ListNode(Object value) {
        this.value = value;
    }

    public static ListNode constuctList(String value) {
        if(value == null)
            return null;

        char[] value_char = value.toCharArray();
        ListNode current = null;
        ListNode head = new ListNode(value_char[0]);
        current = head;
        for (int i = 1; i < value_char.length; i++) {
            ListNode p = new ListNode(value_char[i]);
            current.next = p;
            current = p;
        }

        return head;
    }

    public static ListNode constructCircleListNode(String value) {
        ListNode head = constuctList(value);
        ListNode tail = getTailNode(head);
        tail.next = head;

        return head;
    }

    public static ListNode getTailNode(ListNode head) {
        ListNode current = head;
        ListNode tail = current;
        while(current != null) {
            tail = current;
            current = current.next;
        }
        return tail;
    }

    public static  void printListNode(ListNode head) {
        while(head != null) {
            System.out.print(head.value);
            head = head.next;
        }
    }

    public static  void printCircleListNode(ListNode head) {
        ListNode tmp = head;
        int i = 0;

        while(tmp != null) {
            if(tmp == head&&i!=0)
                break;

            System.out.print(tmp.value);
            i++;
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        ListNode circleHead = constructCircleListNode("fghijkl");
        ListNode straightHead = constuctList("abcde");

        getTailNode(straightHead).next = circleHead;
        printCircleListNode(circleHead);
        meetingNode.getEntryOfLoop(straightHead);
    }
}
