package main;

public class AvlNode<T extends Comparable<T>> extends Node<T> {
    private int height;

    public AvlNode(T value) {
        super(value);
    }

    @Override
    public AvlNode<T> getLeft() {
        return (AvlNode<T>) super.getLeft();
    }

    @Override
    public void setLeft(Node<T> left) {
        super.setLeft(left);
    }

    @Override
    public AvlNode<T> getRight() {
        return (AvlNode<T>) super.getRight();
    }

    @Override
    public void setRight(Node<T> right) {
        super.setRight(right);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
