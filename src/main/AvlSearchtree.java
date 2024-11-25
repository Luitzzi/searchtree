package main;

public class AvlSearchtree<T extends Comparable<T>> extends AbstractSearchTree<T, AvlTreeNode<T>> {
    private int treeHeight;

    private int get_Height(AvlTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        else {
            return node.getHeight();
        }
    }

    public void update_Height(AvlTreeNode<T> node) {
        int heightLeftTree = get_Height(node.getLeft());
        int heightRightTree = get_Height(node.getRight());
        node.setHeight(1 + Math.max(heightLeftTree, heightRightTree));
    }

    @Override
    protected AvlTreeNode<T> create_Node(T value) {
        return new AvlTreeNode<>(value);
    }

    @Override
    protected void insert_Recursion(AvlTreeNode<T> currentRoot, AvlTreeNode<T> nodeToInsert) {
        T rootValue = currentRoot.getValue();
        T insertValue = nodeToInsert.getValue();
        // Check which branch the recursion needs to follow to get to the insertion place.
        if (insertValue.compareTo(rootValue) < 0) {
            if (currentRoot.getLeft() == null) {
                // Base case: Insert as left element.
                currentRoot.setLeft(nodeToInsert);
            }
            else {
                insert_Recursion(currentRoot.getLeft(), nodeToInsert);
            }
            check_Rotation(currentRoot, true);
        } else {
            if (currentRoot.getRight() == null) {
                // Base case: Insert as right element.
                currentRoot.setRight(nodeToInsert);
            }
            else {
                insert_Recursion(currentRoot.getRight(), nodeToInsert);
            }
            check_Rotation(currentRoot, false);
        }
    }

    private void check_Rotation(AvlTreeNode<T> currentRoot, boolean insertedToLeftBranch) {
        int heightLeftSubtree = get_Height(currentRoot.getLeft());
        int heightRightSubtree = get_Height(currentRoot.getRight());
        if (Math.abs(heightLeftSubtree - heightRightSubtree) > 1) {
            // Check if the inner or outer Branch is the problem
            int heightOuterBranch;
            int heightInnerBranch;
            if (insertedToLeftBranch) {
                check_Rotation_Right(currentRoot);
            }
            else {
                check_Rotation_Left(currentRoot);
            }
        }
        else {
            update_Height(currentRoot);
        }
    }

    private void check_Rotation_Right(AvlTreeNode<T> currentRoot) {
        int heightOuterBranch = get_Height(currentRoot.getLeft().getLeft());
        int heightInnerBranch = get_Height(currentRoot.getLeft().getRight());

        if (heightOuterBranch > heightInnerBranch) {
            rotation_Right(currentRoot);
        }
        else {
            double_Rotation_Right(currentRoot);
        }
    }

    private void check_Rotation_Left(AvlTreeNode<T> currentRoot) {
        int heightOuterBranch = get_Height(currentRoot.getRight().getRight());
        int heightInnerBranch = get_Height(currentRoot.getRight().getLeft());

        if (heightOuterBranch > heightInnerBranch) {
            rotation_Left(currentRoot);
        }
        else {
            double_Rotation_Left(currentRoot);
        }
    }

    protected void rotation_Right(AvlTreeNode<T> currentRoot) {
        AvlTreeNode<T> leftNode = currentRoot.getLeft();
        AvlTreeNode<T> newRightNode = new AvlTreeNode<>(currentRoot.getValue());

        // Copy the currentRoot into the newLeftNode
        newRightNode.setRight(currentRoot.getRight());
        newRightNode.setLeft(leftNode.getRight());
        currentRoot.setRight(newRightNode);

        // Swap the insides of the rightNode with the currentRoot
        currentRoot.setValue(leftNode.getValue());
        currentRoot.setLeft(leftNode.getLeft());

        // Update
        update_Height(newRightNode);
        update_Height(currentRoot);
    }

    protected void rotation_Left(AvlTreeNode<T> currentRoot) {
        AvlTreeNode<T> rightNode = currentRoot.getRight();
        AvlTreeNode<T> newLeftNode = new AvlTreeNode<>(currentRoot.getValue());

        // Copy the currentRoot into the newLeftNode
        newLeftNode.setLeft(currentRoot.getLeft());
        newLeftNode.setRight(rightNode.getLeft());
        currentRoot.setLeft(newLeftNode);

        // Swap the insides of the rightNode with the currentRoot
        currentRoot.setValue(rightNode.getValue());
        currentRoot.setRight(rightNode.getRight());

        // Update
        update_Height(newLeftNode);
        update_Height(currentRoot);
    }

    protected void double_Rotation_Right(AvlTreeNode<T> currentRoot) {
        rotation_Left(currentRoot.getLeft());
        rotation_Right(currentRoot);
    }

    protected void double_Rotation_Left(AvlTreeNode<T> currentRoot) {
        rotation_Right(currentRoot.getRight());
        rotation_Left(currentRoot);
    }

    @Override
    protected boolean contains(AvlTreeNode<T> currentRoot, T value) {
        return false;
    }

    @Override
    protected void delete(AvlTreeNode<T> previousNode, AvlTreeNode<T> currentNode, T value) {

    }
}
