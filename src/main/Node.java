package main;

public interface Node <T extends Comparable<T>, N extends Node<T,N>>{
    public T getValue();
    public void setValue(T value);
    public N getLeft();
    public void setLeft(N left);
    public N getRight();
    public void setRight(N right);
}
