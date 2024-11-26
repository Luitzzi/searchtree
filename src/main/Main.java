package main;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        AvlSearchtree<Integer> test = new AvlSearchtree<>();
        Integer []treeElements = {5,3,6,2,4,8};
        test.create_Tree(treeElements);

        test.print_Inorder_On_Console();
        test.print_Preorder_On_Console();
        test.print_Postorder_On_Console();
    }

    public static void exercise3() {
        AvlSearchtree<Integer> test = new AvlSearchtree<>();
        Integer []treeElements = {5,6,9,12,13,3,8,10,11,16,15,14};
        test.create_Tree(treeElements);
        String result = test.print_Inorder_As_String();
        System.out.print(result);
    }
}
