package practice.website.linkedlist;

public class ReverseLinkedLIst {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedLIst list = new ReverseLinkedLIst();
        ListNode z = list.createList(new int[] { 0, 1, 2, 3 });
        list.printLinkedList(z);
        ListNode res = list.reverseList(z);
        System.out.println("==========");
        list.printLinkedList(res);
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode createList(int[] nums) {
        ListNode z = null;
        for (int index = nums.length - 1; index >= 0; index--) {
            ListNode y = new ListNode(nums[index], z);
            z = y;
        }
        return z;
    }

}
