/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;

        // Find middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare both halves
        ListNode left = head;
        ListNode right = prev;

        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
/*What does “reverse the second half” actually mean?

Suppose the list is:

1 → 2 → 2 → 1


After finding the middle using slow and fast:

slow points here ↓
1 → 2 → 2 → 1
          ↑


So the second half is:

2 → 1


We want to reverse it to become:

1 → 2

The Reverse Code (Only This Part)
ListNode prev = null;

while (slow != null) {
    ListNode nextNode = slow.next; // save next
    slow.next = prev;              // reverse link
    prev = slow;                   // move prev forward
    slow = nextNode;               // move slow forward
}


Let’s walk through this line by line.

Step-by-Step Example

Starting second half:

slow → 2 → 1 → null
prev → null

🔹 First loop

nextNode = 1

slow.next = prev → 2 → null

prev = 2

slow = 1

Now:

prev → 2 → null
slow → 1 → null

🔹 Second loop

nextNode = null

slow.next = prev → 1 → 2

prev = 1

slow = null

Now:

prev → 1 → 2 → null


✅ Reversal complete

What is prev now?

prev is the head of the reversed second half.

So now we compare:

First half:    1 → 2
Second half:   1 → 2


Perfect match → palindrome ✅
*/