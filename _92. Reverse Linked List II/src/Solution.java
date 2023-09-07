/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 * <p>
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * Follow up: Could you do it in one pass?
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        while (left < right) {
            ListNode leftNode = get(head, left);
            ListNode rightNode = get(head, right);
            int x = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = x;
            left++;
            right--;
        }
        return head;
    }

    public ListNode get(ListNode head, int index) {
        ListNode temp = head;
        for (int i = 1; i != index; i++) {
            temp = temp.next;
        }
        return temp;
    }
}