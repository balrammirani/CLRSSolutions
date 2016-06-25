package Tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Balram
 */
public class BSTBasics {

    BSTNode getNewNode(int data) {
        BSTNode node = new BSTNode();
        node.setValue(data);
        node.setLeft(null);
        node.setRight(null);
        return node;
    }

    BSTNode insert(int data, BSTNode root) {
        if (root == null) {
            root = getNewNode(data);
        } else if (root.getValue() >= data) {
            root.setLeft(insert(data, root.getLeft()));
        } else {
            root.setRight(insert(data, root.getRight()));
        }
        return root;
    }

    BSTNode search(int data, BSTNode root) {
        if (root.getValue() == data) {
            return root;
        } else if (root.getValue() >= data) {
            root.setLeft(search(data, root.getLeft()));
        } else {
            root.setRight(insert(data, root.getRight()));
        }
        return null;
//        return root;
    }

    int getMin(BSTNode root) {
        BSTNode temp = root;
        if (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp.getValue();
    }

    int getMax(BSTNode root) {
        BSTNode temp = root;
        if (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getValue();
    }

    void preOrderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    //will give you sorted output
    void inOrderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        System.out.println(root.getValue());
        inOrderTraversal(root.getRight());
    }

    void postOrderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println(root.getValue());

    }

    void levelOrderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        //working on BFS
        //shall be fixed in next commit
        Queue<BSTNode> discoveredNodes = new PriorityQueue<BSTNode>();
        discoveredNodes.add(root);
        while (!discoveredNodes.isEmpty()) {
            BSTNode current = discoveredNodes.peek();
            System.out.println(current.getValue());
            if (current.getLeft() != null) {
                discoveredNodes.add(current.getLeft());
            }
            if (current.getRight() != null) {
                discoveredNodes.add(current.getRight());
            }
            discoveredNodes.remove();
        }
    }
}
