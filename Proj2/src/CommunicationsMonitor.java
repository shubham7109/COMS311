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
        
        //Checks to see if the two nodes already exist in the graph. If they do it also keeps track of the last
        //node's timestamp with the same id, i.e. the same computer.E.G if (C1, 4) and (C1, 12) exist and we add
        //(C1,16) it will say this new node is not in the graph and will say we need to link it to (C1,12).
        ComputerNode previousTimestamp1 = null;
        ComputerNode previousTimestamp2 = null;
        boolean createNode1 = true;
        boolean createNode2 = true;
        for(ComputerTripleInfo triple : tripleInfoArrayList){
            if(computerMapping.get(triple.getNode1())!=null){
               for(ComputerNode neighbor: computerMapping.get(triple.getNode1())){
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
        
                   
        
            if(computerMapping.get(triple.getNode2())!=null){
               for(ComputerNode neighbor: computerMapping.get(triple.getNode2())){
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
            ComputerNode node1 = null;
            ComputerNode node2 = null;
            if(createNode1 == true){
                node1 = new ComputerNode(triple.getNode1(), triple.getTimeStamp());
                if(previousTimestamp1!=null){
                    previousTimestamp1.setOutNeighbors(node1);
                }
                computerMapping.put(node1.getID(),node1.getOutNeighbors());
            }
            
            if(createNode2 == true){
                node2 = new ComputerNode(triple.getNode2(), triple.getTimeStamp());
                if(previousTimestamp2!=null){
                    previousTimestamp2.setOutNeighbors(node2);
                }
                computerMapping.put(node2.getID(), node2.getOutNeighbors);
            }
            
        }
        
        for(ComputerTripleInfo triple : tripleInfoArrayList){
            int node1 = triple.getNode1();
            int node2 = triple.getNode2();
            ComputerNode compNode1 = null;
            ComputerNode compNode2 = null;
            for(ComputerNode computerNode : getComputerMapping(node1)){
                if(computerNode.getTimeStamp() == triple.getTimeStamp()){
                    compNode1 = computerNode;
                }
            }
            for(ComputerNode computerNode : getComputerMapping(node2)){
                if(computerNode.getTimeStamp() == triple.getTimeStamp()){
                    compNode2 = computerNode;
                }
            }
            compNode1.addOutNeighbors(compNode2);
            compNode2.addOutNeighbors(compNode1);
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

        public Integer getTimeStamp() {
            return timeStamp;
        }
    }



}
