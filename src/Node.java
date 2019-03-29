
public class Node {

    private Node parent;
    private Node left;
    private Node right;
    private int val;
    private int P;
    private int maxVal;
    private int color;
    private Endpoint endpoint;
    private Endpoint eMax;
    private boolean isNodeNil = false;

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
        if(isNodeNil){
            //This node is a T.nil node so return 0 as the value
            return 0;
        } else{
            return val;
        }
    }

    /**
     * @return Returns the maxval of the node
     */
    public int getMaxVal() {
        if(isNodeNil)
            return 0;
        else
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

    public void setNodeNil(boolean nodeNil) {
        isNodeNil = nodeNil;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setMaxVal(int maxVal) {
        this.maxVal = maxVal;
    }

    public Endpoint geteMax() {
        return eMax;
    }

    public void seteMax(Endpoint eMax) {
        this.eMax = eMax;
    }

    public boolean isNodeNil() {
        return isNodeNil;
    }
}
