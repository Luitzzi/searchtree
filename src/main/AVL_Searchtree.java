package main;

import java.util.function.Function;

public class AVL_Searchtree<T extends Comparable<T>> extends Searchtree<T,AVL_Tree_Element<T>> {
    private AVL_Tree_Element<T> root;

    public AVL_Searchtree(Function<T, AVL_Tree_Element<T>> nodeFactory){
        super(nodeFactory);
    }

    public void setRoot(AVL_Tree_Element<T> root) {
        this.root = root;
    }

    @Override
    public AVL_Tree_Element<T> getRoot() {
        return root;
    }

    public int getHeight(AVL_Tree_Element<T> node) {
        if (node == null) {
            return -1;
        }
        else {
            return node.getHeight();
        }
    }

    public void updateHeight(AVL_Tree_Element<T> node) {
        int heightLeftElement = getHeight(node.getLeft());
        //node.setHeight(1 + Math.max());
    }

    @Override
    public void insert(T value) {
        AVL_Tree_Element<T> nodeToInsert = new AVL_Tree_Element<>(value);
        if (root == null) {
            root = nodeToInsert;
            root.setHeight(0);
        }
        else {
            insert_Recursion_AVL(root, nodeToInsert);
        }
    }

    protected void insert_Recursion_AVL(AVL_Tree_Element<T> currentRoot, AVL_Tree_Element<T> nodeToInsert) {
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
