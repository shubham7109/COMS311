import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComputerNode {

    private int ID;
    private int timestamp;
    private List<ComputerNode> computerNodeList;
    private int color;//0 is white, 1 is grey, 2 is black

    public ComputerNode(int ID, int timestamp) {
        this.ID = ID;
        this.timestamp = timestamp;
        computerNodeList = new LinkedList<>();
        color = 0;
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
    
    public int getColor(){
        return color;
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
