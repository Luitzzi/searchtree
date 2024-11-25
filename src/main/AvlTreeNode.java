package main;

import com.sun.source.tree.Tree;

public class AvlTreeNode<T extends Comparable<T>> implements TreeNode<T, AvlTreeNode<T>> {
    private T value;
    private AvlTreeNode<T> left;
    private AvlTreeNode<T> right;
    private int height;

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public AvlTreeNode<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(AvlTreeNode<T> left) {
        this.left = left;
    }

    @Override
    public AvlTreeNode<T> getRight() {
        return right;
    }

    @Override
    public void setRight(AvlTreeNode<T> right) {
        this.right = right;
    }
}
