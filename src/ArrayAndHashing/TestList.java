package ArrayAndHashing;

import practice.website.linkedlist.ListNode;

public class TestList {

    public ListNode createList(int[] nums) {
        ListNode z = null;
        for (int index = nums.length - 1; index >= 0; index--) {
            ListNode y = new ListNode(nums[index], z);
            z = y;
        }
        return z;
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        TestList obj = new TestList();
        ListNode res = obj.createList(new int[] { 0, 1, 2, 3, 4 });
        obj.printLinkedList(res);
    }

}
