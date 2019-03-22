public class Test {

    public static void main(String[] args) {
        Intervals test = new Intervals();
        test.intervalInstert(2,3);
        test.intervalInstert(1,3);
        test.intervalInstert(4,7);
        test.printRBTree(test.getRBTree().root);
    }

}
