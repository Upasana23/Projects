
public class Demo {
	final static private String INPUT = "123456708"; 		//123405678 123745680  281346750
    final static private String GOAL_STATE = "123456780";	//123456780 123864750  321804756

	public static void main(String[] args) {
		String rootState = INPUT;
        long startTime = System.currentTimeMillis();
        
        Solve solution = new Solve(new Node(rootState), GOAL_STATE);
        //solution.aStar(1);		// solve with Manhattan
        solution.aStar(2);	// solve with Misplaced Tiles

        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Time  :" + totalTime +" ms");
	}
	
}
