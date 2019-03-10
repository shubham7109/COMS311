import java.util.ArrayList;

public class Intervals {

    private int idCounter;
    private RBTree rbTree;
    private ArrayList interval;

    public Intervals() {

        rbTree = new RBTree();
        interval = new ArrayList();
        idCounter = 1;
    }

    public void intervalInstert(int a, int b){

    }

    public boolean intervalDelete(int intervalID){
        return false;
    }

    public int findPOM(){
        return rbTree.getRoot().getMaxVal();
    }

    public RBTree getRBTree(){
        return rbTree;
    }





    public class Interval{
        private int intervalID;
        private Endpoint left;
        private Endpoint right;

        public Interval(int a, int b, int id) {
            left = new Endpoint(a);
            right = new Endpoint(b);
            intervalID = id;
        }

        public int getIntervalID() {
            return intervalID;
        }

        public Endpoint getLeft() {
            return left;
        }

        public Endpoint getRight() {
            return right;
        }

    }
}
