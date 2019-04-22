import java.util.*;

public class CommunicationsMonitor {

    private boolean isCreateGraphCalled = false;
    private LinkedList<ComputerTripleInfo> tripleInfoArrayList;
    private HashMap<Integer, List<ComputerNode>> computerMapping;

    public CommunicationsMonitor(){
        tripleInfoArrayList = new LinkedList<>();
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
        tripleInfoArrayList.sort((ComputerTripleInfo o1, ComputerTripleInfo o2) -> {
            if (o1.getTimeStamp() > o2.getTimeStamp())
                return 1;
            else if (o1.getTimeStamp().equals(o2.getTimeStamp()))
                return 0;
            else
                return -1;
        });
        
        //Checks to see if the two nodes already exist in the graph. If they do it also keeps track of the last
        //node's timestamp with the same id, i.e. the same computer.E.G if (C1, 4) and (C1, 12) exist and we add
        //(C1,16) it will say this new node is not in the graph and will say we need to link it to (C1,12).

        for(ComputerTripleInfo triple : tripleInfoArrayList){
            ComputerNode previousTimestamp1 = null;
            ComputerNode previousTimestamp2 = null;
            boolean createNode1 = true;
            boolean createNode2 = true;
            if(computerMapping.get(triple.getNode1())!=null){
               for(ComputerNode neighbor: computerMapping.get(triple.getNode1())){
                   if(neighbor.getID()== triple.getNode1()){
                       if(neighbor.getTimestamp() != triple.getTimeStamp()){
                           previousTimestamp1 = neighbor;
                       }
                       else{
                           createNode1 = false;
                       }
                   }                           
               }               
            }           
        
                   
        
            if(computerMapping.get(triple.getNode2())!=null){
               for(ComputerNode neighbor: computerMapping.get(triple.getNode2())){
                   if(neighbor.getID()== triple.getNode2()){
                       if(neighbor.getTimestamp() != triple.getTimeStamp()){
                           previousTimestamp2 = neighbor;
                       }
                       else{
                           createNode2 = false;
                       }
                   }                           
               }               
            } 
            ComputerNode node1;
            ComputerNode node2;
            if(createNode1){
                LinkedList<ComputerNode> hashList = new LinkedList<>();
                node1 = new ComputerNode(triple.getNode1(), triple.getTimeStamp());

                if(previousTimestamp1!=null){
                    previousTimestamp1.addOutNeighbors(node1);
                    computerMapping.get(previousTimestamp1.getID()).add(node1);
                }
                else {
                    hashList.add(node1);
                    computerMapping.put(node1.getID(), hashList);
                }
            }
            
            if(createNode2){
                node2 = new ComputerNode(triple.getNode2(), triple.getTimeStamp());
                LinkedList<ComputerNode> hashList = new LinkedList<>();
                if(previousTimestamp2!=null){
                    previousTimestamp2.addOutNeighbors(node2);
                    computerMapping.get(previousTimestamp2.getID()).add(node2);
                }
                else {
                    hashList.add(node2);
                    computerMapping.put(node2.getID(), hashList);
                }
            }
            
        }
        
        for(ComputerTripleInfo triple : tripleInfoArrayList){
            int node1 = triple.getNode1();
            int node2 = triple.getNode2();
            ComputerNode compNode1 = null;
            ComputerNode compNode2 = null;
            for(ComputerNode computerNode : getComputerMapping(node1)){
                if(computerNode.getTimestamp() == triple.getTimeStamp()){
                    compNode1 = computerNode;
                }
            }
            for(ComputerNode computerNode : getComputerMapping(node2)){
                if(computerNode.getTimestamp() == triple.getTimeStamp()){
                    compNode2 = computerNode;
                }
            }
            compNode1.addOutNeighbors(compNode2);
            compNode2.addOutNeighbors(compNode1);
        }
    }

    public void printGraph(){
        System.out.println();
        for ( Integer key: computerMapping.keySet()) {
            System.out.println("Computer: " + computerMapping.get(key).get(0).getID());
            for(ComputerNode computerNode : computerMapping.get(key)){
                System.out.print("->TimeStamp " +  computerNode.getTimestamp()+": ");
                for(ComputerNode neighbors: computerNode.getOutNeighbors()){
                    System.out.print("("+neighbors.getID() +  ","  + neighbors.getTimestamp() + ") ");
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    /**
     *
     * @param c1 Computer infected at time x
     * @param c2 Check if computer infected by time y
     * @return Ordered list that represents
     * the transmission sequence.
     */
    public List<ComputerNode> queryInfection(int c1, int c2, int x, int y){

        if(y < x){
            return null; // C2 cannot get infected when C1 is not infected
        }


        //Get the starting computer node
        ComputerNode startingNode = null;

        List<ComputerNode> computerNodes = computerMapping.get(c1);

        for (ComputerNode node: computerNodes) {
            if(node.getTimestamp() >= x){
                startingNode = node;
                break;
            }
        }

//        for ( Integer key: computerMapping.keySet()) {
//            for(int i=0; i<computerMapping.get(key).size(); i++){
//                if(computerMapping.get(key).get(i).getID() == c1){
//                    if(computerMapping.get(key).get(i).getTimestamp() >= x){
//                        startingNode  = computerMapping.get(key).get(i);
//                        break;
//                    }
//                }
//            }
//        }

        if(startingNode == null){
            return null; //c1 does not exist in graph or c1 does not communicate when infected
        }


        //Get the end computer node
        ComputerNode endNode = null;
//        for ( Integer key: computerMapping.keySet()) {
//            for(int i=0; i<computerMapping.get(key).size(); i++){
//                if(computerMapping.get(key).get(i).getID() == c2){
//                    if(computerMapping.get(key).get(i).getTimestamp() >= y){
//                        endNode  = computerMapping.get(key).get(i);
//                        break;
//                    }
//                }
//            }
//        }

        computerNodes = computerMapping.get(c2);

        for (ComputerNode node: computerNodes) {
            if(node.getTimestamp() >= y){
                endNode = node;
                break;
            }
        }

        if(endNode == null){
            return null; //c2 does not exist in graph or c2 does not communicate when infected
        }

        // TODO Check that this is in 0(m) time
        // BFS starts here

        Queue<ComputerNode> queue = new LinkedList<>();
        ArrayList<ComputerNode> explored = new ArrayList<>();

        if(startingNode.equals(endNode)){
            explored.add(startingNode);
            return explored;
        }


        queue.add(startingNode);
        explored.add(startingNode);

        while(!queue.isEmpty()){
            ComputerNode current = queue.remove();
            if(current.equals(endNode)) {
                explored.add(current);
                return explored;
            }
            else{
                if(current.getOutNeighbors().isEmpty())
                    return null;
                else
                    queue.addAll(current.getOutNeighbors());
            }
            explored.add(current);
        }

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
            this.timeStamp = timestamp;
        }

        public int getNode1() {
            return node1;
        }

        public int getNode2() {
            return node2;
        }

        public Integer getTimeStamp() {
            return timeStamp;
        }
    }

}
