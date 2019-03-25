import org.junit.Assert;
import org.junit.Test;

public class JUnitTests {

    private final int COLOR_RED = 0;
    private final int COLOR_BLACK = 1;

    @Test
    public void TestInsertion() {
        Intervals test = new Intervals();

        //Basic test
        test.intervalInsert(2,3);
        Assert.assertEquals(test.getRBTree().root.getKey(),2);
        Assert.assertEquals(test.getRBTree().root.getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getKey(),3);
        Assert.assertEquals(test.getRBTree().root.getRight().getColor(),COLOR_RED);

        //More insertion
        test.intervalInsert(1,3);
        Assert.assertEquals(test.getRBTree().root.getKey(),2);
        Assert.assertEquals(test.getRBTree().root.getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getKey(),3);
        Assert.assertEquals(test.getRBTree().root.getRight().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getLeft().getKey(),1);
        Assert.assertEquals(test.getRBTree().root.getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getKey(),3);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getColor(),COLOR_RED);


        test.intervalInsert(4,7);
        Assert.assertEquals(test.getRBTree().root.getKey(),2);
        Assert.assertEquals(test.getRBTree().root.getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getKey(),3);
        Assert.assertEquals(test.getRBTree().root.getRight().getColor(),COLOR_RED);
        Assert.assertEquals(test.getRBTree().root.getLeft().getKey(),1);
        Assert.assertEquals(test.getRBTree().root.getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getKey(),4);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getKey(),3);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getKey(),7);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getColor(),COLOR_RED);




    }
}
