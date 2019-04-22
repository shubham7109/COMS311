import java.io.File;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        int POM = 0;
        Intervals intervals = new Intervals();

        try {
            //all small work
            //all medium work
            //all large work
            File file = new File("small_5.txt");

            Scanner input = new Scanner(file);

            input.nextLine();
            int i = 0;

            while (input.hasNextLine()) {
                intervals.intervalInsert(input.nextInt(),input.nextInt());
//                System.out.println(i);
//                i++;
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
