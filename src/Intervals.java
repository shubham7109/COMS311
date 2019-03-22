import java.util.ArrayList;

/**
 * The Intervals class represents a collection of intervals
 */
public class Intervals {

    private int idCounter;
    private RBTree rbTree;
    private ArrayList<Interval> intervals;

    public Intervals() {

        rbTree = new RBTree();
        intervals = new ArrayList<>();
        idCounter = 1;
    }

    /**
     * Handles the insertion of an interval
     * @param a left interval
     * @param b right interval
     */
     public void intervalInsert(int a, int b){
        intervals.add(new Interval(a,b,idCounter));
        Endpoint leftE = new Endpoint(a);
        Endpoint rightE = new Endpoint(b);
        Node leftENode = new Node();
        Node rightENode = new Node();
        leftENode.setEndpoint(leftE);
        rightENode.setEndpoint(rightE);
        rbtreeInsert(leftENode);
        rbtreeInsert(rightENode);
        idCounter++;
    }

    //Insert method to add new nodes to the rbtree based on the rbtree properties and the node/endpoint's key
    public void rbtreeInsert(Node n){
        n.setColor(0);
        //if the tree is empty set the first node to be the root with the parent being the nil node
        if(rbTree.root == null){
            n.setColor(1);
            rbTree.root = n;
            n.setParent(rbTree.nil);
            n.setRight(rbTree.nil);
            n.setLeft(rbTree.nil);
        }
        else{
            Node cur = rbTree.root;
            while(cur != null){                     //while loop condition is really not necessary.
                if(n.getKey() < cur.getKey()){
                    if(cur.getLeft() != rbTree.nil){
                        cur = cur.getLeft();
                    }
                    else{
                        cur.setLeft(n);
                        n.setParent(cur);
                        n.setLeft(rbTree.nil);
                        n.setRight(rbTree.nil);
                        break;
                    }
                }
                else{
                    if(cur.getRight() != rbTree.nil){
                        cur = cur.getRight();
                    }
                    else{
                        cur.setRight(n);
                        n.setParent(cur);
                        n.setLeft(rbTree.nil);
                        n.setRight(rbTree.nil);
                        break;
                    }

                }
            }
            rbTree.height++;
            rbTreeInsertFix(n);



        }



    }
    //Insert fix based on the example code given in Section A's lecture slides
    public void rbTreeInsertFix(Node x){
        while(x.getParent().getColor() == 0){
            if(x.getParent() == x.getParent().getParent().getLeft()){
               Node y = x.getParent().getParent().getRight();
               if(y.getColor() == 0){
                   x.getParent().setColor(1); //Case 1
                   y.setColor(1);             //Case 1
                   x.getParent().getParent().setColor(0); //Case 1
                   x = x.getParent().getParent(); //Case 1
               }
               else{
                   if(x == x.getParent().getRight()){// case 2
                       x = x.getParent();            //Case 2
                       leftRotate(x);                //Case 2
                   }
                   x.getParent().setColor(1);        //Case 3
                   x.getParent().getParent().setColor(0); //Case 3
                   rightRotate(x.getParent().getParent()); //Case 3
               }
            }
            else{
                Node y = x.getParent().getParent().getLeft();
                if(y.getColor() == 0){
                    x.getParent().setColor(1); //Case 1
                    y.setColor(1);             //Case 1
                    x.getParent().getParent().setColor(0); //Case 1
                    x = x.getParent().getParent(); //Case 1
                }
                else{
                    if(x == x.getParent().getLeft()){ //Case 2
                        x = x.getParent();              //Case 2
                        rightRotate(x);                 //Case 2
                    }
                    x.getParent().setColor(1);          //Case 3
                    x.getParent().getParent().setColor(0); //Case 3
                    leftRotate(x.getParent().getParent()); //Case 3
                }

            }
        }
        rbTree.root.setColor(1);
    }

    public void leftRotate(Node x){
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft() != rbTree.nil){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == rbTree.nil){
            rbTree.root = y;
        }
        else if(x == x.getParent().getLeft()){
            x.getParent().setLeft(y);
        }
        else{
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);

    }
    public void rightRotate(Node x){
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        if(y.getRight() != rbTree.nil){
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == rbTree.nil){
            rbTree.root = y;
        }
        else if( x == x.getParent().getLeft()){
            x.getParent().setLeft(y);
        }
        else{
            x.getParent().setRight(y);
        }
        y.setRight(x);
        x.setParent(y);
    }

    /**
     * Deletes an interval based on its ID
     * @return Returns true if deletion was successful. Else return false.
     */
    public boolean intervalDelete(int intervalID){
        //TODO
        return false;
    }

    /**
     * @return Returns the val of the max overlap.
     */
    public int findPOM(){
        return rbTree.root.getMaxVal();
    }

    /**
     * @return Return the rb tree used
     */
    public RBTree getRBTree(){
        return rbTree;
    }
    
    //Prints the rbTree, used for testing purposes only, can start printing from any node to see its subtrees, normally start at the root to see the whole tree.
    public void printRBTree(Node n) {
        if(n.getLeft() == rbTree.nil && n.getRight() == rbTree.nil){
            if(n == rbTree.root){
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + "nil," + "nil" + "," + "nil" + ")");
            }
            else{
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + n.getParent().getKey() + "," + "nil" + "," + "nil" + ")");
            }

        }
        else if(n.getLeft() == rbTree.nil && n.getRight() != rbTree.nil){
            if(n == rbTree.root){
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + "nil," + "nil" + "," + n.getRight().getKey() + ")");
            }
            else{
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + n.getParent().getKey() + "," + "nil" + "," + n.getRight().getKey() + ")");
            }
            printRBTree(n.getRight());
        }
        else if(n.getLeft() != rbTree.nil && n.getRight() == rbTree.nil){
            if(n == rbTree.root){
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + "nil," + n.getLeft().getKey() + "," + "nil" + ")");
            }
            else{
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + n.getParent().getKey() + "," + n.getLeft().getKey() + "," + "nil" + ")");
            }
            printRBTree(n.getLeft());
        }
        else{
            if(n == rbTree.root){
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + "nil," + n.getLeft().getKey() + "," + n.getRight().getKey() + ")");
            }
            else{
                System.out.println("(" + n.getKey() + "," + n.getColor() + "," + n.getParent().getKey() + "," + n.getLeft().getKey() + "," + n.getRight().getKey() + ")");
            }
            printRBTree(n.getLeft());
            printRBTree(n.getRight());
        }

    }

    /**
     * Interval class used to keep record of each interval
     */
    public class Interval{
        private int intervalID;
        private Endpoint left;
        private Endpoint right;

        Interval(int a, int b, int count) {
            left = new Endpoint(a);
            right = new Endpoint(b);
            intervalID = count;
        }

        public int getIntervalID() {
            return intervalID;
        }

        public Endpoint getLeftEndpoint() {
            return left;
        }

        public Endpoint getRightEndpoint() {
            return right;
        }

    }
}
