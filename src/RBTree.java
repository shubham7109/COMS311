/**
 * @author Shubham Sharma & Carter Ronald
 */
public class RBTree {

    public Node root;
    public Node nil;
    public int size;
    public int height;


    public RBTree() {
       size = 0;
       height = 0;
       nil = new Node();
       root = nil;
       nil.setNodeNil(true);
       nil.setColor(1);
       nil.setEndpoint(null);
    }

    public Node getRoot() {
        return root;
    }

    public Node getNILNode() {
        return nil;
    }

    public int getSize() {
        return size;
    }

    public int getHeight() {
        return height;
    }
}
