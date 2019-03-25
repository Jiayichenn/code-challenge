/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode singleCheck(boolean carry, ListNode l) {
        if (!carry) {
            return l;
        }
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        int sumval;
        // System.out.print("fff");
        while (carry) {
            if (l == null) {
                temp.next = new ListNode(1);
                carry = false;
            } else {
                sumval = l.val + 1;
                if (sumval >= 10) {
                    temp.next = new ListNode(sumval - 10);
                } else {
                    temp.next = new ListNode(sumval);
                    carry = false;
                }
                l = l.next;
            }
            temp = temp.next;
        }
        temp.next = l;
        return result.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        ListNode _l1 = l1;
        ListNode _l2 = l2;
        int count = 0;
        int val1;
        int val2;
        int sumval;
        boolean carry = false;
        while (_l1 != null && _l2 != null) {
            val1 = _l1.val;
            val2 = _l2.val;
            if (carry) {
                sumval = val1 + val2 + 1;
            } else {
                sumval = val1 + val2;
            }
            if (sumval >= 10) {
                carry = true;
                sumval -= 10;
            } else {
                carry = false;
            }
            temp.next = new ListNode(sumval);
            temp = temp.next;
            _l1 = _l1.next;
            _l2 = _l2.next;
            count += 1;
        }
        if (_l1 != null) {
            temp.next = singleCheck(carry, _l1);
        } else {
            temp.next = singleCheck(carry, _l2);
        }
        return result.next;
    }
}
