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
        int[] temp = new int[] { 1, 2, 3 };
        ListNode z = new ListNode(0);
        for (int i : temp) {
            ListNode y = new ListNode(i, z);
            z = y;
        }
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

}
