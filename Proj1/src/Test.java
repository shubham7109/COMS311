import java.io.File;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        int POM = 0;
        Intervals intervals = new Intervals();

        try {
            File file = new File("small_1.txt");

            Scanner input = new Scanner(file);

            input.nextLine();


            while (input.hasNextLine()) {
                intervals.intervalInsert(input.nextInt(),input.nextInt());
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(intervals.findPOM());
        //System.out.println(POM);

//        test.intervalInsert(7,11);
//        test.intervalInsert(0,4);
//        test.intervalInsert(1,6);
//        test.intervalInsert(3,13);
    }
}
