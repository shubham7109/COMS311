import java.util.List;

public class ComputerNode {

    int ID;
    int timestamp;

    public ComputerNode(int ID, int timestamp) {
        this.ID = ID;
        this.timestamp = timestamp;
    }

    public int getID() {
        return ID;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public List<ComputerNode> getOutNeighbors(){
        return null;
    }
}
