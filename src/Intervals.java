import java.util.ArrayList;

/**
 * The Intervals class represents a collection of intervals
 */
public class Intervals {

    private int idCounter;
    private RBTree rbTree;
    private ArrayList<Interval> interval;

    public Intervals() {

        rbTree = new RBTree();
        interval = new ArrayList<>();
        idCounter = 1;
    }

    /**
     * Handles the insertion of an interval
     * @param a left interval
     * @param b right interval
     */
    public void intervalInstert(int a, int b){
        interval.add(new Interval(a,b,idCounter++));
        //TODO Update the RB tree based on the new interval
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

        public Endpoint getLeft() {
            return left;
        }

        public Endpoint getRight() {
            return right;
        }

    }
}
