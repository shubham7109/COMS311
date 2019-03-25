public class RBTree {

    public Node root;
    public Node nil;
    public int size;
    public int height;


    public RBTree() {
       size = 0;
       height = 0;
       root = null;
       nil = new Node();
       nil.setNodeNil(true);
       nil.setColor(1);

    }


}
