import java.util.ArrayList;
import java.util.Random;

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

    @Test
    public void TestVal() {
        Intervals test = new Intervals();

        test.intervalInsert(0,4);
        test.intervalInsert(1,6);
        test.intervalInsert(3,9);
        test.intervalInsert(7,11);

        Assert.assertEquals(test.getRBTree().root.getVal(),0);
        Assert.assertEquals(test.getRBTree().root.getLeft().getVal(),3);
        Assert.assertEquals(test.getRBTree().root.getLeft().getLeft().getVal(),1);
        Assert.assertEquals(test.getRBTree().root.getLeft().getRight().getVal(),1);
        Assert.assertEquals(test.getRBTree().root.getRight().getVal(),-2);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getVal(),-1);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getVal(),-2);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getVal(),-1);
    }
    
    @Test
    public void TestMaxVal() {
        Intervals test = new Intervals();

        for(int j=0; j < 1000; j++) {
        	
        	ArrayList<Integer> ints = new ArrayList<Integer>();
            Random rand = new Random();
            for(int i=0; i< 100; i++) {
            	int num = 1+rand.nextInt(4);
            	if(!ints.contains(num)) {
            		ints.add(num);
            		switch(num) {
            			case 1:
            				insertIntervals1(test);
            				break;
            			case 2:
            				insertIntervals2(test);
            				break;
            			case 3:
            				insertIntervals3(test);
            				break;
            			case 4:
            				insertIntervals4(test);
            				break;
            		}
            	}
            }
    		if(test.getRBTree().root.getMaxVal() != 3) {
    			System.out.println(ints.get(0) +"," + ints.get(1)+"," + ints.get(2) +","+ ints.get(3));
    		} else 
    			System.out.println("Works:"+ ints.get(0) + ints.get(1) + ints.get(2) + ints.get(3)); 
    		
    		Assert.assertEquals(3,test.getRBTree().root.getMaxVal());
    		test = new Intervals();
        }
        
        

    }

    private void insertIntervals1(Intervals intervals) {
    	intervals.intervalInsert(0,4);
    }
    private void insertIntervals2(Intervals intervals) {
    	intervals.intervalInsert(1,6);
    }
    private void insertIntervals3(Intervals intervals) {
    	intervals.intervalInsert(7,11);
    }
    private void insertIntervals4(Intervals intervals) {
    	intervals.intervalInsert(3,9);
    }

    @Test
    public void TestHeight(){
        Intervals test = new Intervals();

        test.intervalInsert(0,4);
        test.intervalInsert(1,6);
        test.intervalInsert(3,9);
        test.intervalInsert(7,11);
        Assert.assertEquals(test.getRBTree().height,3);
    }

    @Test
    public void TestSize(){
        Intervals test = new Intervals();

        test.intervalInsert(0,4);
        test.intervalInsert(1,6);
        test.intervalInsert(3,9);
        test.intervalInsert(7,11);
        Assert.assertEquals(test.getRBTree().size,8);
    }
}
