package test;

import main.Searchtree;
import main.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SearchtreeTest {
    private Searchtree<Integer, Node<Integer>> tree;

    @BeforeEach
    public void setup() {
        tree = new Searchtree<>(Node::new);
    }

    @Test
    public void test_Insert() {
        tree.insert_Iterativ(6);
        tree.insert_Iterativ(3);
        tree.insert_Iterativ(8);
        tree.insert_Iterativ(4);
        tree.insert_Iterativ(7);
        tree.insert_Iterativ(10);
        tree.insert_Iterativ(1);
        /*
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(1);
        */
        test_tree();
    }

    @Test
    public void test_PrintInorder() {
        fill_tree();
        tree.print_Inorder();
    }

    @Test
    public void test_Contains() {
        fill_tree();
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(1));
        assertFalse(tree.contains(50));
    }

    @Test
    public void test_Delete() {
        fill_tree();
        tree.delete(8);
        tree.print_Inorder();
    }

    private void fill_tree() {
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(7);
        tree.insert(11);
        tree.insert(1);
        tree.insert(10);
        tree.insert(9);
    }

    private void test_tree() {
        assertEquals(6, tree.getRoot().getValue(), "Root = 6");
        assertEquals(3, tree.getRoot().getLeft().getValue(), "Left = 3");
        assertEquals(1, tree.getRoot().getLeft().getLeft().getValue(), "Left, left = 1");
        assertEquals(4, tree.getRoot().getLeft().getRight().getValue(), "Left, Right = 4");
        assertEquals(8, tree.getRoot().getRight().getValue(), "Right = 8");
        assertEquals(7, tree.getRoot().getRight().getLeft().getValue(), "Right, left = 7");
        assertEquals(10, tree.getRoot().getRight().getRight().getValue(), "Right, right = 10");
    }
}