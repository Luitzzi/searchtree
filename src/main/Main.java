package main;

public class Main {
    public static void main(String[] args) {
        Searchtree <Integer, Node <Integer, Node <Integer, Node <Integer, ...>>>> test = new Searchtree<>(Node::new);
        Integer []treeElements = {6,3,8,1,4,7,10};
        test.create_Tree(treeElements);
        String result = test.print_Inorder_As_String();
        System.out.print(result);
    }
}
