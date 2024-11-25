package main;

public class Main {
    public static void main(String[] args) {

        AvlSearchtree<Integer> test = new AvlSearchtree<>();
        Integer []treeElements = {1,2,3,4};
        test.create_Tree(treeElements);
        String result = test.print_Inorder_As_String();
        System.out.print(result);


    }
}
