package util;

class Node<E extends Comparable<E>> {
    private Node<E> left;
    private Node<E> right;
    private Node<E> parent;
    private Color color;
    private E value;

    Node() {
        color = Color.BLACK;
    }

    Node(Node<E> left, Node<E> right, Node<E> parent, Color color, E value) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
        this.value = value;
    }

    Node(E value) {
        color = Color.BLACK;
        this.value = value;
    }

    public boolean isRed() {
        return color == Color.RED;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString() + " (" + color + ")";
    }
}
