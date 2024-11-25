package main;

public class Tree_Element<T extends Comparable<T>, N extends Node<T,N>> implements Node<T,N> {
    private T value;
    private N left;
    private N right;

    public Tree_Element(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public N getLeft() {
        return left;
    }

    public void setLeft(N left) {
        this.left = left;
    }

    public N getRight() {
        return right;
    }

    public void setRight(N right) {
        this.right = right;
    }
}