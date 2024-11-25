package main;

import java.util.function.Function;

public class Searchtree<T extends Comparable<T>, N extends Node<T,Tree_Element<T>>> {
    protected N root;
    protected Function<T,N> nodeFactory;

    public Searchtree(Function<T, N> nodeFactory) {
        this.nodeFactory = nodeFactory;
    }

    public N getRoot() {
        return root;
    }

    public void setRoot(N root) {
        this.root = root;
    }

    public void create_Tree(T[] treeElements) {
        for (T treeElement : treeElements) {
            insert(treeElement);
        }
    }

    public void insert(T value) {
        N nodeToInsert = nodeFactory.apply(value);
        if (root == null) {
            root = nodeToInsert;
        }
        else {
            insert_Recursion(root, nodeToInsert);
        }
    }

    protected void insert_Recursion(N currentRoot, N nodeToInsert) {
        if (currentRoot == null) {
            currentRoot = nodeToInsert;
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

    public void insert_Iterativ(T value) {
        N currentRoot = root;
        N nodeToInsert = nodeFactory.apply(value);
        boolean gotInserted = false;

        if (root == null) {
            root = nodeToInsert;
        }
        else {
            while (!gotInserted) {
                T rootValue = currentRoot.getValue();
                T insertValue = nodeToInsert.getValue();
                if (insertValue.compareTo(rootValue) < 0) {
                    if (currentRoot.getLeft() == null) {
                        currentRoot.setLeft(nodeToInsert);
                        gotInserted = true;
                    }
                    else {
                        currentRoot = currentRoot.getLeft();
                    }
                } else {
                    if (currentRoot.getRight() == null) {
                        currentRoot.setRight(nodeToInsert);
                        gotInserted = true;
                    }
                    else {
                        currentRoot = currentRoot.getRight();
                    }
                }
            }
        }
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    protected boolean contains(N currentRoot, T value) {
        if (currentRoot == null) {
            System.out.println("The tree doesn't contain the value " + value + ".");
            return false;
        }
        else if (currentRoot.getValue().compareTo(value) == 0) {
            System.out.println("The tree contains the value " + value + ".");
            return true;
        }
        else {
            if (value.compareTo(currentRoot.getValue()) < 0) {
                return contains(currentRoot.getLeft(), value);
            }
            else return contains(currentRoot.getRight(), value);
        }
    }

    public void delete_Tree() {
        root = null;
    }

    public void delete_Iterativ(T value) {
        N currentNode = root;
        N previousNode = null;
        boolean gotDeleted = false;

        while (!gotDeleted) {
            if (currentNode == null) {
                System.out.println("The value " + value + " doesn't exist!");
                gotDeleted = true;
            }
            else {
                if (value.compareTo(currentNode.getValue()) < 0) {
                    previousNode = currentNode;
                    currentNode = currentNode.getLeft();
                } else if (value.compareTo(currentNode.getValue()) > 0) {
                    previousNode = currentNode;
                    currentNode = currentNode.getRight();
                } else {
                    if (previousNode == null) {
                        deleteRoot();
                        gotDeleted = true;
                    } else {
                        deleteNode(previousNode, currentNode);
                        gotDeleted = true;
                    }
                }
            }
        }

    }

    public void delete(T value) {
        N currentNode = root;
        delete(null, currentNode, value);
        //delete_Iterativ(value);
    }

    protected void delete(N previousNode, N currentNode, T value) {
        if (currentNode == null) {
            System.out.println("The value " + value + " doesn't exist!");
        }
        else {
            if (value.compareTo(currentNode.getValue()) < 0) {
                delete(currentNode, currentNode.getLeft(), value);
            } else if (value.compareTo(currentNode.getValue()) > 0) {
                delete(currentNode, currentNode.getRight(), value);
            } else {
                if (previousNode == null) {
                    deleteRoot();
                } else {
                    deleteNode(previousNode, currentNode);
                }
            }
        }
    }

    protected void deleteRoot() {
        boolean hasLeftDescendant = root.getLeft() != null;
        boolean hasRightDescendant = root.getRight() != null;

        if (hasLeftDescendant && hasRightDescendant) {
            delete_With_Two_Descendants(root);
        } else if (hasLeftDescendant) {
            root = root.getLeft();
        } else if (hasRightDescendant) {
            root = root.getRight();
        } else {
            root = null;
        }
    }
    protected void deleteNode(N previousNode, N nodeToDelete) {
        boolean isLeftNode = previousNode.getLeft() == nodeToDelete;
        boolean hasLeftDescendant = nodeToDelete.getLeft() != null;
        boolean hasRightDescendant = nodeToDelete.getRight() != null;

        if (isLeftNode) {
            if (hasLeftDescendant && hasRightDescendant) {
                delete_With_Two_Descendants(nodeToDelete);
            } else if (hasLeftDescendant) {
                previousNode.setLeft(nodeToDelete.getLeft());
            } else if (hasRightDescendant) {
                previousNode.setLeft(nodeToDelete.getRight());
            } else {
                previousNode.setLeft(null);
            }
        }
        else {
            if (hasLeftDescendant && hasRightDescendant) {
                delete_With_Two_Descendants(nodeToDelete);
            } else if (hasLeftDescendant) {
                previousNode.setRight(nodeToDelete.getLeft());
            } else if (hasRightDescendant) {
                previousNode.setRight(nodeToDelete.getRight());
            } else {
                previousNode.setRight(null);
            }
        }
    }

    protected void delete_With_Two_Descendants(N nodeToDelete) {
        T nextGreaterNumber;
        if (nodeToDelete.getRight().getLeft() == null) {
            nextGreaterNumber = nodeToDelete.getRight().getValue();
            nodeToDelete.setRight(nodeToDelete.getRight().getRight());
        }
        else {
            nextGreaterNumber = get_Next_Greater_Number_And_Delete_It(nodeToDelete.getRight(), nodeToDelete.getRight().getLeft());
        }
        nodeToDelete.setValue(nextGreaterNumber);
    }

    protected T get_Next_Greater_Number_And_Delete_It(N previousNode, N currentNode) {
        if (currentNode.getLeft() == null) {
            previousNode.setLeft(null);
            return currentNode.getValue();
        }
        else return get_Next_Greater_Number_And_Delete_It(currentNode, currentNode.getLeft());
    }

    public void print_Inorder() {
        N currentRoot = root;
        print_Inorder(root);
        System.out.print("\n");
    }

    protected void print_Inorder(N currentRoot) {
        if (currentRoot != null) {
            System.out.print("( ");
            print_Inorder(currentRoot.getLeft());
            System.out.print(" , ");
            System.out.print(currentRoot.getValue());
            System.out.print(" , ");
            print_Inorder(currentRoot.getRight());
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
