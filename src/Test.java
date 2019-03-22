public class Test {

    public static void main(String[] args) {
        Intervals test = new Intervals();
        test.intervalInsert(2,3);
        test.intervalInsert(1,3);
        test.intervalInsert(4,7);
        test.printRBTree(test.getRBTree().root);
    }

}
