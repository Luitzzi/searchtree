package main;

public class AVL_Tree_Element<T extends Comparable<T>> extends Tree_Element<T,AVL_Tree_Element<T>>{
    private int height;

    public AVL_Tree_Element(T value) {
        super(value);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
