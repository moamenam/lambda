import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlaneGameTest {

    protected PlaneGame solution;

    @Before
    public void setUp() {
        solution = new PlaneGame();
    }

    @Test(timeout = 200000000)
    public void testCase0() {
        int[] x = new int[]{0, 5,10};
        int[] y = new int[]{0, 5,10};

        int expected = 3;
        int actual = solution.bestShot(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase1() {
        int[] x = new int[]{0, -1, 1, 1, -1};
        int[] y = new int[]{0, -1, -1, 1, 1};

        int expected = 5;
        int actual = solution.bestShot(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout =  200000000)
    public void testCase2() {
        int[] x = new int[]{0, 0, 0, 1, -1};
        int[] y = new int[]{0, 1, -1, 0, 0};

        int expected = 5;
        int actual = solution.bestShot(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase3() {
        int[] x = new int[]{0, -3, 3, 3, -3, 0, 0, 3, -3};
        int[] y = new int[]{0, -3, -3, 3, 3, 3, -3, 0, 0};

        int expected = 5;
        int actual = solution.bestShot(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase4() {
        int[] x = new int[]{0};
        int[] y = new int[]{0};

        int expected = 1;
        int actual = solution.bestShot(x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase5() {
        int[] x = new int[]{-1000000, -1, 999998, 1, -1001, 1000000, -999999, 999999, 0, 0};
        int[] y = new int[]{1000000, 1, 1000000, -1, -999, 1000000, 0, 0, -999999, 999999};

        int expected = 5;
        int actual = solution.bestShot(x, y);

        Assert.assertEquals(expected, actual);
    }
    
    @Test(timeout = 200000000)
    public void testCase6() {
    	int [] x = {-1000000, 1000000, -1000000, 1000000, 559207, 551955, 432768, -290103, -166745, -567532, -572722, -845187, 47839, 998769, 494597, 119717, -139142, 620183, -403443, 874225, -644444, -995886, -305110, -257754, -264533, -70033, 984175, -835702, 229443, -636536, -451901, -903998, 125168, -353969, -701730, -893016, 318057, -892351, 152945, 39886, -889372, -2773, -553253, -88633, -65488, 764260, 721269, -949974, -368557, -80176};
    	int [] y = {999999, 1000000, -999999, -1000000, 15520, 655814, 332224, -668340, -697479, 674804, -764397, -266297, -471222, -118868, -134201, 643745, 100215, -373448, 690941, 477028, -308064, -200567, -9706, -550271, 19852, -317050, -437959, -53049, -829572, 816570, -395103, 587437, 284732, 322344, 213886, -313419, 439278, -695295, -745400, -942659, 898260, -369283, -525997, -469593, 335157, -672090, -718547, -34248, 923139, 466116};
    	
    	int expected = 3;
        int actual = solution.bestShot(x, y);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 200000000)
    public void testCase7() {
    	int [] x = {-1000000, 0, 1000000, 0, 1000000};
    	int [] y = {-1000000, 0, 0, 1000000, 1000000};
    	
    	int expected = 5;
        int actual = solution.bestShot(x, y);

        Assert.assertEquals(expected, actual);
    }
}
