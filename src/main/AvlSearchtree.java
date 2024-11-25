package main;

import java.util.function.Function;

public class AvlSearchtree<T extends Comparable<T>> extends AbstractSearchTree<T, AvlTreeNode<T>> {
    private int height;

    public int getHeight(AvlTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        else {
            return node.getHeight();
        }
    }

    public void updateHeight(AvlTreeNode<T> node) {
        int heightLeftElement = getHeight(node.getLeft());
        //node.setHeight(1 + Math.max());
    }

    @Override
    protected AvlTreeNode<T> create_Node(T value) {
        return new AvlTreeNode<>(value);
    }

    @Override
    protected void insert_Recursion(AvlTreeNode<T> currentRoot, AvlTreeNode<T> nodeToInsert) {

    }

    @Override
    protected boolean contains(AvlTreeNode<T> currentRoot, T value) {
        return false;
    }

    @Override
    protected void delete(AvlTreeNode<T> previousNode, AvlTreeNode<T> currentNode, T value) {

    }
}
