package main;

import java.util.function.Function;

public class AvlSearchtree<T extends Comparable<T>> extends Searchtree<T, AvlNode<T>> {
    private AvlNode<T> root;

    public AvlSearchtree(Function<T, AvlNode<T>> nodeFactory){
        super(nodeFactory);
    }

    public void setRoot(AvlNode<T> root) {
        this.root = root;
    }

    @Override
    public AvlNode<T> getRoot() {
        return root;
    }

    public int getHeight(AvlNode<T> node) {
        if (node == null) {
            return -1;
        }
        else {
            return node.getHeight();
        }
    }

    public void updateHeight(AvlNode<T> node) {
        int heightLeftElement = getHeight(node.getLeft());
        //node.setHeight(1 + Math.max());
    }

    @Override
    public void insert(T value) {
        AvlNode<T> nodeToInsert = new AvlNode<>(value);
        if (root == null) {
            root = nodeToInsert;
            root.setHeight(0);
        }
        else {
            insert_Recursion_AVL(root, nodeToInsert);
        }
    }

    protected void insert_Recursion_AVL(AvlNode<T> currentRoot, AvlNode<T> nodeToInsert) {
        if (currentRoot == null) {
            currentRoot = nodeToInsert;
            currentRoot.setHeight(0);
        }
        else {
            T rootValue = currentRoot.getValue();
            T insertValue = nodeToInsert.getValue();
            if (insertValue.compareTo(rootValue) < 0) {
                if (currentRoot.getLeft() == null) {
                    currentRoot.setLeft(nodeToInsert);
                }
                else {
                    insert_Recursion(currentRoot.getLeft(), nodeToInsert);
                }
            } else {
                if (currentRoot.getRight() == null) {
                    currentRoot.setRight(nodeToInsert);
                }
                else {
                    insert_Recursion(currentRoot.getRight(), nodeToInsert);
                }
            }
        }
    }




}
