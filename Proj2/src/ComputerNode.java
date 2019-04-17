import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComputerNode {

    private int ID;
    private int timestamp;
    private List<ComputerNode> computerNodeList;

    public ComputerNode(int ID, int timestamp) {
        this.ID = ID;
        this.timestamp = timestamp;
        computerNodeList = new LinkedList<>();
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

    /**
     * @param computerNode
     * The computer node to which there is
     * outgoing edge from this ComputerNode object
     */
    public void setOutNeighbors(ComputerNode computerNode){
        computerNodeList.add(computerNode);
    }
}
