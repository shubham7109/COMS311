import java.util.HashMap;

public class MainTest {

    public static void main(String[] args) {

        CommunicationsMonitor communicationsMonitor = new CommunicationsMonitor();

        // Example 1 from the project desc
        communicationsMonitor.addCommunication(2,4,8);
        communicationsMonitor.addCommunication(1,4,12);
        communicationsMonitor.addCommunication(1,2,4);
        communicationsMonitor.addCommunication(3,4,8);


        communicationsMonitor.createGraph();

        communicationsMonitor.printGraph();

    }
}
