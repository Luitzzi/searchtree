package main;

public abstract class AbstractSearchTree <T extends Comparable<T>, N extends TreeNode<T,N>> {
    protected N root;

    public AbstractSearchTree() {
        root = null;
    }

    public N getRoot() {
        return root;
    }

    public void setRoot(N root) {
        this.root = root;
    }

    protected abstract N create_Node(T value);

    // Create from elements, insert and check if tree contains an element

    public void create_Tree(T[] treeElements) {
        for (T treeElement : treeElements) {
            insert(treeElement);
        }
    }

    public void insert(T value) {
        N nodeToInsert = create_Node(value);
        if (root == null) {
            root = nodeToInsert;
        }
        else {
            insert_Recursion(root, nodeToInsert);
        }
    }

    protected abstract void insert_Recursion(N currentRoot, N nodeToInsert);

    public boolean contains(T value) {
        return contains(root, value);
    }

    protected abstract boolean contains(N currentRoot, T value);

    // Delete tree or an element

    public void delete_Tree() {
        root = null;
    }

    public void delete(T value) {
        N currentNode = root;
        delete(null, currentNode, value);
    }

    protected abstract void delete(N previousNode, N currentNode, T value);

    // Print

    public void print_Inorder_On_Console() {
        N currentRoot = root;
        print_Inorder_On_Console(root);
        System.out.print("\n");
    }

    protected void print_Inorder_On_Console(N currentRoot) {
        if (currentRoot != null) {
            System.out.print("( ");
            print_Inorder_On_Console(currentRoot.getLeft());
            System.out.print(" , ");
            System.out.print(currentRoot.getValue());
            System.out.print(" , ");
            print_Inorder_On_Console(currentRoot.getRight());
            System.out.print(" )");
        }
        else System.out.print("n");
    }

    public String print_Inorder_As_String() {
        N currentRoot = root;
        return print_Inorder_As_String(root);
    }

    protected String print_Inorder_As_String(N currentRoot) {
        if (currentRoot != null) {
            return ("( " + print_Inorder_As_String(currentRoot.getLeft()) + " , " + currentRoot.getValue() + " , " + print_Inorder_As_String(currentRoot.getRight()) + " )");
        }
        else return "n";
    }

}