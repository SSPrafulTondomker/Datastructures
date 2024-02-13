import java.util.*;

/**
 * Loop in LinkedList,
 *
 * 1->2->3->4(-->3)->null
 *
 *
 * TC := O(n)
 * Sc := O(n)
 *
 * p1 + 1 & p2 + 2
 *
 *
 * */

class Node implements Comparator<Node> {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int compareTo(Node o) {
        return 0;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return 0;
    }
}

class LinkedListService {

    LinkedListService() {

    }

    boolean findLoop(Node head) {
        Map<Node, Boolean> visited = new HashMap<>();
        Node newHead = head;

        while (newHead != null) {
            if (visited.containsKey(newHead)) return true;
            visited.put(newHead, true);
            newHead = newHead.next;
        }
        return false;
    }
    void createLinkedList(Node head) {
        Node nextNextNext = new Node(4, null);
        Node nextNext = new Node(3, nextNextNext);
        Node next = new Node(2, nextNext);
        head.next = next;
    }

}
public class Kotak {
    public static void main(String args[]) {
        LinkedListService linkedListService = new LinkedListService();
        Node head = new Node(1, null);
        linkedListService.createLinkedList(head);
        System.out.println("Is loop: " + linkedListService.findLoop(head));
    }
}
