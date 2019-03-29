/**
 * @author Shubham Sharma & Carter Ronald
 */
public class Test {

    public static void main(String[] args) {
        Intervals test = new Intervals();
        System.out.println(test.getRBTree().nil);

        test.intervalInsert(7,11);
        test.intervalInsert(0,4);
        test.intervalInsert(1,6);
        test.intervalInsert(3,13);
        test.printRBTree(test.getRBTree().root);

        System.out.println(test.getRBTree().height);
        System.out.println(test.getRBTree().size);
        System.out.println(test.getRBTree().nil);
    }

}
