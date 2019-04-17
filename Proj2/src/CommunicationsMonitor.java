import java.util.*;

public class CommunicationsMonitor {

    private boolean isCreateGraphCalled = false;
    private ArrayList<ComputerTripleInfo> tripleInfoArrayList;

    public CommunicationsMonitor(){
        tripleInfoArrayList = new ArrayList<>();
    }

    //Should run in O(1)
    public void addCommunication(int c1, int c2, int timestamp){

        if(isCreateGraphCalled)
            return;

        ComputerNode node1 = new ComputerNode(c1,timestamp);
        ComputerNode node2 = new ComputerNode(c2,timestamp);
        tripleInfoArrayList.add(new ComputerTripleInfo(node1,node2)); // Basically does (C1,C2,time)

    }

    //Should run in O(n + m log m)
    // where (n = number of nodes, m = number of triples)
    public void createGraph(){
        isCreateGraphCalled = true;

        // Step1:
        // Sort the triples by nondecreasing timestamp
        // TODO Check if this is O(mlogm)
        tripleInfoArrayList.sort((o1, o2) -> {
            if (o1.getTimeStamp() < o2.getTimeStamp())
                return -1;
            else if (o1.getTimeStamp().equals(o2.getTimeStamp()))
                return 0;
            else
                return 1;
        });


        // Step2:
        // Maintain a map where the keys are the computers and the associated values are lists.
        // Initially, the list associated with each computer is empty.
        //TODO
    }

    public List<ComputerNode> queryInfection(int c1, int c2, int x, int y){
        return null;
    }

    public HashMap<Integer, List<ComputerNode>> getComputerMapping(){
        return null;
    }

    public List<ComputerNode> getComputerMapping(int c){
        return null;
    }


    // Custom class used to keep track of each computer interaction.
    private class ComputerTripleInfo{

        ComputerNode node1;
        ComputerNode node2;
        Integer timeStamp;

        ComputerTripleInfo(ComputerNode node1, ComputerNode node2) {
            this.node1 = node1;
            this.node2 = node2;
            timeStamp = node1.getTimestamp();
        }

        public ComputerNode getNode1() {
            return node1;
        }

        public ComputerNode getNode2() {
            return node2;
        }

        public Integer getTimeStamp() {
            return timeStamp;
        }
    }



}
