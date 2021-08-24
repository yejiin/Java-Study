package graph.tree;

public class CompleteBinaryTreeTest {

    public static void main(String[] args) {

        int size = 9;
        CompleteBinaryTree tree = new CompleteBinaryTree(size);

        for (int i =0; i< size; i++) {
            tree.add((char)(65+i));
        }
//        graph.tree.bfs();
//        graph.tree.bfs2();

//        graph.tree.dfsByPreOrder();
//        graph.tree.dfsByInOrder();
        tree.dfsByPostOrder();
    }
}
