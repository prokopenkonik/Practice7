package util;

import static util.Color.*;

public class RedBlackTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public RedBlackTree() {

    }

    private void insertNode(E value) {
        Node<E> newNode = new Node<E>(value);
        if (root == null) {
            root = newNode;
        }
        else {
            root = findPosition(root, newNode);
        }
    }

    private Node<E> findPosition(Node<E> currentNode, Node<E> newNode) {
        int compare = currentNode.getValue().compareTo(newNode.getValue());
        if (compare > 0) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
            }
            else {
                currentNode.setLeft(findPosition(currentNode.getLeft(), newNode));
            }
        }
        else if (compare < 0) {
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
            }
            else {
                currentNode.setRight(findPosition(currentNode.getRight(), newNode));
            }
        }
        return currentNode;
    }

    public void add(E value) {
        size++;
        insertBST(value);
    }

    private Node<E> rotateRight(Node<E> currentNode) {
        Node<E> temp = currentNode.getLeft();
        currentNode.setLeft(temp.getRight());
        temp.setRight(currentNode);
        currentNode = temp;
        return currentNode;
    }

    private Node<E> rotateLeft(Node<E> currentNode) {
        Node<E> temp = currentNode.getRight();
        currentNode.setRight(temp.getLeft());
        temp.setLeft(currentNode);
        currentNode = temp;
        return currentNode;
    }

    private Color indicate(Node<E> node) {
        if (node == null) {
            return BLACK;
        }
        return node.getColor();
    }

    private void insertBST(E value) {
        Node<E> newNode = new Node<E>(value);
        newNode.setColor(RED);
        root = insertTree234(root, newNode, false);
        root.setColor(BLACK);
    }

    private Node<E> insertTree234(Node<E> currentNode, Node<E> newNode, boolean flag) {
        if (currentNode == null) {
            return newNode;
        }

        if (indicate(currentNode.getLeft()) == RED
                && indicate(currentNode.getRight()) == RED) {
            currentNode.setColor(RED);
            currentNode.getLeft().setColor(BLACK);
            currentNode.getRight().setColor(BLACK);
        }

        if (newNode.getValue().compareTo(currentNode.getValue()) < 0) {
            currentNode.setLeft(insertTree234(currentNode.getLeft(), newNode, false));
            if (indicate(currentNode) == RED
                    && indicate(currentNode.getLeft()) == RED
                    && flag) {
                currentNode = rotateRight(currentNode);
            }
            if (indicate(currentNode.getLeft()) == RED
                    && indicate(currentNode.getLeft().getLeft()) == RED) {
                currentNode = rotateRight(currentNode);
                currentNode.setColor(BLACK);
                currentNode.getRight().setColor(RED);
            }
        }
        else {
            currentNode.setRight(insertTree234(currentNode.getRight(), newNode, true));
            flag = !flag;
            if (indicate(currentNode) == RED
                    && indicate(currentNode.getRight()) == RED
                    && flag) {
                currentNode = rotateLeft(currentNode);
            }
            if (indicate(currentNode.getRight()) == RED
                    && indicate(currentNode.getRight().getRight()) == RED) {
                currentNode = rotateLeft(currentNode);
                currentNode.setColor(BLACK);
                currentNode.getLeft().setColor(RED);
            }
        }
        return currentNode;
    }

    public void show() {
        printTree(root);
    }

    private void printTree(Node<E> root) {
        printElementTree(root, 0);
    }

    private void printFromMinToMax(Node<E> currentNode) {
        if (currentNode != null) {
            printFromMinToMax(currentNode.getLeft());
            System.out.println(currentNode);
            printFromMinToMax(currentNode.getRight());
        }
    }

    public void showFromMinToMax() {
        printFromMinToMax(root);
    }

    private void printElementTree(Node<E> currentNode, int level) {
        if (currentNode != null) {
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }
            System.out.println(currentNode);
            level++;
            printElementTree(currentNode.getLeft(), level);
            printElementTree(currentNode.getRight(), level);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
