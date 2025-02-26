import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Shubham Sharma & Carter Ronald
 */
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

        test = new Intervals();
        test.intervalInsert(0,4);
        Assert.assertEquals(test.getRBTree().root.getKey(),0);
        Assert.assertEquals(test.getRBTree().root.getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getKey(),4);
        Assert.assertEquals(test.getRBTree().root.getRight().getColor(),COLOR_RED);

        test.intervalInsert(1,6);
        Assert.assertEquals(test.getRBTree().root.getKey(),1);
        Assert.assertEquals(test.getRBTree().root.getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getKey(),4);
        Assert.assertEquals(test.getRBTree().root.getRight().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getLeft().getKey(),0);
        Assert.assertEquals(test.getRBTree().root.getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getKey(),6);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getColor(),COLOR_RED);

        test.intervalInsert(7,11);
        Assert.assertEquals(test.getRBTree().root.getKey(),1);
        Assert.assertEquals(test.getRBTree().root.getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getKey(),6);
        Assert.assertEquals(test.getRBTree().root.getRight().getColor(),COLOR_RED);
        Assert.assertEquals(test.getRBTree().root.getLeft().getKey(),0);
        Assert.assertEquals(test.getRBTree().root.getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getKey(),7);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getKey(),4);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getKey(),11);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getColor(),COLOR_RED);

        test.intervalInsert(3,9);
        Assert.assertEquals(test.getRBTree().root.getKey(),1);
        Assert.assertEquals(test.getRBTree().root.getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getKey(),6);
        Assert.assertEquals(test.getRBTree().root.getRight().getColor(),COLOR_RED);
        Assert.assertEquals(test.getRBTree().root.getLeft().getKey(),0);
        Assert.assertEquals(test.getRBTree().root.getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getKey(),9);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getKey(),4);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getColor(),COLOR_BLACK);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getLeft().getKey(),3);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getLeft().getColor(),COLOR_RED);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getKey(),11);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getColor(),COLOR_RED);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getLeft().getKey(),7);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getLeft().getColor(),COLOR_RED);




    }

    @Test
    public void TestVal() {
        Intervals test = new Intervals();

        test.intervalInsert(0,4);
        test.intervalInsert(1,6);
        test.intervalInsert(3,9);
        test.intervalInsert(7,11);

         

        Assert.assertEquals(test.getRBTree().root.getLeft().getVal(),3);
        Assert.assertEquals(test.getRBTree().root.getLeft().getLeft().getVal(),1);
        Assert.assertEquals(test.getRBTree().root.getLeft().getRight().getVal(),1);
        Assert.assertEquals(test.getRBTree().root.getRight().getVal(),-2);
        Assert.assertEquals(test.getRBTree().root.getRight().getLeft().getVal(),-1);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getVal(),-2);
        Assert.assertEquals(test.getRBTree().root.getRight().getRight().getRight().getVal(),-1);
        Assert.assertEquals(test.getRBTree().root.getVal(),0);
    }
    
    @Test
    public void TestMaxValAutomated() {
        Intervals test = new Intervals();

        // Random automated testing for MaxVals
        
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
    
    @Test
    public void TestMaxValIndividually() {
    	Intervals test = new Intervals();
    	test.intervalInsert(0,4);
    	
    	Assert.assertEquals(1,test.getRBTree().root.getMaxVal());
    	Assert.assertEquals(0,test.getRBTree().root.getLeft().getMaxVal());
    	Assert.assertEquals(0,test.getRBTree().root.getRight().getMaxVal());
    	
        test.intervalInsert(1,6);
        
    	Assert.assertEquals(2,test.getRBTree().root.getMaxVal());
    	Assert.assertEquals(1,test.getRBTree().root.getLeft().getMaxVal());
    	Assert.assertEquals(0,test.getRBTree().root.getRight().getMaxVal());
    	Assert.assertEquals(0,test.getRBTree().root.getRight().getRight().getMaxVal());

         System.out.println("\n\n");
        
        test.intervalInsert(7,11);

         
        
        Assert.assertEquals(2,test.getRBTree().root.getMaxVal());
    	Assert.assertEquals(1,test.getRBTree().root.getLeft().getMaxVal());
    	Assert.assertEquals(0,test.getRBTree().root.getRight().getMaxVal());
    	Assert.assertEquals(0,test.getRBTree().root.getRight().getLeft().getMaxVal());
    	Assert.assertEquals(1,test.getRBTree().root.getRight().getRight().getMaxVal());
    	Assert.assertEquals(0,test.getRBTree().root.getRight().getRight().getRight().getMaxVal());
        
        test.intervalInsert(3,9);

         

        Assert.assertEquals(3,test.getRBTree().root.getMaxVal());
    	Assert.assertEquals(1,test.getRBTree().root.getLeft().getMaxVal());//0
    	Assert.assertEquals(1,test.getRBTree().root.getRight().getMaxVal());//6
    	Assert.assertEquals(1,test.getRBTree().root.getRight().getLeft().getMaxVal());//4
    	Assert.assertEquals(1,test.getRBTree().root.getRight().getRight().getMaxVal());//9
    	Assert.assertEquals(1,test.getRBTree().root.getRight().getLeft().getLeft().getMaxVal());//3
    	Assert.assertEquals(0,test.getRBTree().root.getRight().getRight().getRight().getMaxVal());//11
    	Assert.assertEquals(1,test.getRBTree().root.getRight().getRight().getLeft().getMaxVal());//7

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

    @Test
    public void TestEmax(){
        Intervals test = new Intervals();

        test.intervalInsert(0,4);
        test.intervalInsert(1,6);
        test.intervalInsert(3,9);
        test.intervalInsert(7,11);

         

        Assert.assertEquals(test.getRBTree().root.getLeft().getEmax(),test.getRBTree().root.getLeft().getRight().getEndpoint());

        Intervals i = new Intervals();

        i.intervalInsert(4, 5);
        i.intervalInsert(0, 5);
        i.intervalInsert(5, 7);

        i.printRBTree(i.getRBTree().getRoot());

        assertEquals(i.findPOM(), 4);
    }

    @Test
    public void testZeroNodeTree() {
        Intervals test = new Intervals();

        assertEquals(0,test.getRBTree().getHeight());
        assertEquals(0,test.getRBTree().getSize());
        assertEquals(0,test.getRBTree().getRoot().getMaxVal());
    }

    @Test
    public void testGetValue() {
        Endpoint endpoint = new Endpoint(4);
        assertEquals(4, endpoint.getValue());
    }

    @Test
    public void PointIntervals(){

        Intervals test = new Intervals();
        test.intervalInsert(1,2);
        test.intervalInsert(3,4);


        test.printRBTree(test.getRBTree().getRoot());
        Assert.assertEquals(1,test.getRBTree().getRoot().getMaxVal());

    }

    @Test
    public void MoreInrervalInsertion(){

        Intervals test = new Intervals();

        test.intervalInsert(3,9);
        test.intervalInsert(3,9);
        test.intervalInsert(3,9);
        test.intervalInsert(3,9);
        test.intervalInsert(3,9);
        test.intervalInsert(3,9);
        test.intervalInsert(3,9);
        test.intervalInsert(3,9);
        test.intervalInsert(3,9);

        test.intervalInsert(-9,-3);
        test.intervalInsert(-9,-3);
        test.intervalInsert(-9,-3);
        test.intervalInsert(-9,-3);
        test.intervalInsert(-9,-3);
        test.intervalInsert(-9,-3);


        //test.printRBTree(test.getRBTree().getRoot());
        Assert.assertEquals(9,test.getRBTree().getRoot().getMaxVal());


        test = new Intervals();
        Random rand  = new Random();

        for(int i=0; i< 12 ; i++){
            int num1 = -10 +rand.nextInt(20);
            int num2 = -10 +rand.nextInt(20);

            if(num1 >= num2){
                test.intervalInsert(num2,num1);
                System.out.println("("+num2 + "," + num1 + ")");
            }else{
                test.intervalInsert(num1,num2);
                System.out.println("("+num1 + "," + num2 + ")");
            }
        }

    }

}
