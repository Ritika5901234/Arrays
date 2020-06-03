package linkedList;

/**
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 */
public class DeleteNode {

    static void deleteNode(Node node){
        if(node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static void printLinkedList(Node root){
        Node temp = root;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args){
        //[4,5,1,9];
        Node root = new Node(4,null);
        root.next = new Node(5,null);
        root.next.next = new Node(1,null);
        root.next.next.next = new Node(9, null);

        printLinkedList(root);
        deleteNode(root.next.next);
        printLinkedList(root);

    }
}
