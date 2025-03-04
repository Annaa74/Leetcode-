import java.util.*;
class ListNode {
    int val;
    ListNode next;  
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }  
    public static ListNode deserialize(String data) {
        if (data == null || data.equals("[]")) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String node : nodes) {
            current.next = new ListNode(Integer.parseInt(node.trim()));
            current = current.next;
        }
        return dummy.next;
    }
    public String serialize() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        ListNode current = this;
        while (current != null) {
            joiner.add(String.valueOf(current.val));
            current = current.next;
        }
        return joiner.toString();
    }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}