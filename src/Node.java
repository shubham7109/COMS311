
public class Node {

    private Node parent;
    private Node left;
    private Node right;
    private int key;
    private int val;
    private int P;
    private int maxVal;
    private int color;
    private Endpoint endpoint;
    private Endpoint eMax;

    public Node() {
    }

    /**
     * @return Returns the parent of this node
     */
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * @return Returns the left child
     */
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @return Returns the right child
     */
    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * @return Returns the endpoint value
     */
    public int getKey() {
        return endpoint.getValue();
    }

    /**
     * @return  Returns the value of the function p based on this endpoint
     */
    public int getP() {
        return P;
    }

    /**
     * @param p p=-1 if left endpoint else p=+1
     */
    public void setP(int p) {
        P = p;
    }

    /**
     * @return Returns the val of the node based on the v.val formula
     */
    public int getVal() {
        if(val == 0){
            //This node is a T.nil node
            return 0;
        } else{
            //From the formula in the assignment description
            return getLeft().getVal() + getP() + getRight().getVal();
        }
    }

    /**
     * @return Returns the maxval of the node
     */
    public int getMaxVal() {
        //Using the formula in the assignment description
        int case1,case2,case3;
        case1 = getLeft().getMaxVal();
        case2 = getLeft().getVal();
        case3 = getLeft().getVal() + P + getRight().getMaxVal();

        maxVal = Math.max(case1,case2);
        if(maxVal>case3){
            maxVal = Math.max(case1,case3);
        }
        else{
            maxVal = Math.max(case2,case3);
        }

        return maxVal;
    }

    /**
     * @return Returns 0 if red. Returns 1 if black
     */
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    /**
     * @return Returns the Endpoint object that this node represents
     */
    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * @return Returns an Endpoint object that represents e_max
     */
    public Endpoint getMax() {
        //TODO Not sure if this is the correct way to find the e_max
        int case1,case2,case3;
        case1 = getLeft().getMaxVal();
        case2 = getLeft().getVal();
        case3 = getLeft().getVal() + P + getRight().getMaxVal();

        if(case1 > case2 && case1 > case3)
            eMax = getLeft().getEndpoint();
        else if(case2 > case3 && case2 > case1)
            eMax= getLeft().getEndpoint();
        else
            eMax= getRight().getEndpoint();
        return eMax;
    }
}
