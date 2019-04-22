import java.util.HashMap;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        CommunicationsMonitor communicationsMonitor = new CommunicationsMonitor();

        // Example 1 from the project desc
        communicationsMonitor.addCommunication(2,4,8);
        communicationsMonitor.addCommunication(1,4,12);
        communicationsMonitor.addCommunication(1,2,4);
        communicationsMonitor.addCommunication(3,4,8);


        communicationsMonitor.createGraph();

        List<ComputerNode> list = communicationsMonitor.queryInfection(1,3,4,8);

        if(list == null)
            System.out.println("No path found");
        else{
            System.out.println();
            for(ComputerNode computerNode : list){
                System.out.print("("+computerNode.getID() +  ","  + computerNode.getTimestamp() + ") ");
            }
            System.out.println();
        }

        //communicationsMonitor.printGraph();




    }
}
