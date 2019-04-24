/**
 * @author Carter Ronald
 * @author Shubham Sharma
 */


import java.util.LinkedList;
import java.util.List;

public class ComputerNode {

    private int ID;
    private int timestamp;
    private List<ComputerNode> computerNodeList;
    private int color;//0 is white, 1 is grey, 2 is black



    private ComputerNode pred = null;

    public ComputerNode(int ID, int timestamp) {
        this.ID = ID;
        this.timestamp = timestamp;
        computerNodeList = new LinkedList<>();
        color = 0;
    }

    public ComputerNode getPred() {
        return pred;
    }

    public void setPred(ComputerNode pred) {
        this.pred = pred;
    }

    public int getID() {
        return ID;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public List<ComputerNode> getOutNeighbors(){
        return computerNodeList;
    }
    
    public int getColor(){return color;}

    public void setColor(int color){
        this.color = color;
    }

    /**
     * @param computerNode
     * The computer node to which there is
     * outgoing edge from this ComputerNode object
     */
    public void addOutNeighbors(ComputerNode computerNode){
        computerNodeList.add(computerNode);
    }
}
