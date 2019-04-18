import java.util.*;

public class CommunicationsMonitor {

    private boolean isCreateGraphCalled = false;
    private ArrayList<ComputerTripleInfo> tripleInfoArrayList;
    private HashMap<Integer, List<ComputerNode>> computerMapping;

    public CommunicationsMonitor(){
        tripleInfoArrayList = new ArrayList<>();
    }

    //Should run in O(1)
    public void addCommunication(int c1, int c2, int timestamp){

        if(isCreateGraphCalled)
            return;

//         ComputerNode node1 = new ComputerNode(c1,timestamp);
//         ComputerNode node2 = new ComputerNode(c2,timestamp);
        tripleInfoArrayList.add(new ComputerTripleInfo(c1,c2,timestamp)); // Basically does (C1,C2,time)

    }

    //Should run in O(n + m log m)
    // where (n = number of nodes, m = number of triples)
    public void createGraph(){
        computerMapping = new HashMap<Integer, List<ComputerNode>>();
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
        ComputerNode previousTimestamp1 = null;
        ComputerNode previousTimestamp2 = null;
        boolean createNode1 = true;
        boolean createNode2 = true;
        for(ComputerTripleInfo triple : tripleInforArrayList){
            if(computerMapping.get(triple.getNode1())!=null){
               for(ComputerNode neighbor: computerMapping.get(triple.getNode1().getOutNeighbors()){
                   if(neighbor.getID()== triple.getNode1()){
                       if(neighbor.getTimestamp() != triple.getTimestamp()){
                           previousTimestamp1 = neighbor;
                       }
                       else{
                           createNode1 = false;
                       }
                   }                           
               }               
            }           
        }
                   
        for(ComputerTripleInfo triple : tripleInforArrayList){
            if(computerMapping.get(triple.getNode2())!=null){
               for(ComputerNode neighbor: computerMapping.get(triple.getNode2().getOutNeighbors()){
                   if(neighbor.getID()== triple.getNode2()){
                       if(neighbor.getTimestamp() != triple.getTimestamp()){
                           previousTimestamp2 = neighbor;
                       }
                       else{
                           createNode2 = false;
                       }
                   }                           
               }               
            }           
        }           
        


        // Step2:
        // Maintain a map where the keys are the computers and the associated values are lists.
        // Initially, the list associated with each computer is empty.
        //TODO
    }

    public List<ComputerNode> queryInfection(int c1, int c2, int x, int y){
        return null;
    }

    public HashMap<Integer, List<ComputerNode>> getComputerMapping(){
        return computerMapping;
    }

    public List<ComputerNode> getComputerMapping(int c){
        return computerMapping.get(c);
    }


    // Custom class used to keep track of each computer interaction.
    private class ComputerTripleInfo{

        int node1;
        int node2;
        Integer timeStamp;

        ComputerTripleInfo(int node1, int node2, int timestamp) {
            this.node1 = node1;
            this.node2 = node2;
            this.timeStamp = timestamp
        }

        public int getNode1() {
            return node1;
        }

        public int getNode2() {
            return node2;
        }

        public Integer getTimestamp() {
            return timeStamp;
        }
    }



}
