import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Movement {
	/**
	 * Find possible movement of 0 in puzzle
	 * @param state (Puzzle Node)
	 * @return possible successor
	 */
    public static List<String> getSuccessors(String state) {
        List<String> successors = new ArrayList<String>();
        //index of 0 in puzzle 
        switch (state.indexOf("0")) {
            case 0: { //if the index is 0, 0 can move right, down
                successors.add(state.replace(state.charAt(0), '@').replace(state.charAt(1), state.charAt(0)).replace('@', state.charAt(1)));
                successors.add(state.replace(state.charAt(0), '@').replace(state.charAt(3), state.charAt(0)).replace('@', state.charAt(3)));
                break;
            }
            case 1: { //if the index is 1, 0 can move left, down, up
                successors.add(state.replace(state.charAt(1), '@').replace(state.charAt(0), state.charAt(1)).replace('@', state.charAt(0)));
                successors.add(state.replace(state.charAt(1), '@').replace(state.charAt(2), state.charAt(1)).replace('@', state.charAt(2)));
                successors.add(state.replace(state.charAt(1), '@').replace(state.charAt(4), state.charAt(1)).replace('@', state.charAt(4)));
                break;
            }
            case 2: {   //if the index is 2, 0 can move left, down
                successors.add(state.replace(state.charAt(2), '@').replace(state.charAt(1), state.charAt(2)).replace('@', state.charAt(1)));
                successors.add(state.replace(state.charAt(2), '@').replace(state.charAt(5), state.charAt(2)).replace('@', state.charAt(5)));
                break;
            }
            case 3: {  //if the index is 3, 0 can move right, down, up
                successors.add(state.replace(state.charAt(3), '@').replace(state.charAt(0), state.charAt(3)).replace('@', state.charAt(0)));
                successors.add(state.replace(state.charAt(3), '@').replace(state.charAt(4), state.charAt(3)).replace('@', state.charAt(4)));
                successors.add(state.replace(state.charAt(3), '@').replace(state.charAt(6), state.charAt(3)).replace('@', state.charAt(6)));
                break;
            }
            case 4: {	//if the index is 4, 0 can move right, down, up, left
                successors.add(state.replace(state.charAt(4), '@').replace(state.charAt(1), state.charAt(4)).replace('@', state.charAt(1)));
                successors.add(state.replace(state.charAt(4), '@').replace(state.charAt(3), state.charAt(4)).replace('@', state.charAt(3)));
                successors.add(state.replace(state.charAt(4), '@').replace(state.charAt(5), state.charAt(4)).replace('@', state.charAt(5)));
                successors.add(state.replace(state.charAt(4), '@').replace(state.charAt(7), state.charAt(4)).replace('@', state.charAt(7)));
                break;
            }
            case 5: {  	//if the index is 5, 0 can move down, up, left
                successors.add(state.replace(state.charAt(5), '@').replace(state.charAt(2), state.charAt(5)).replace('@', state.charAt(2)));
                successors.add(state.replace(state.charAt(5), '@').replace(state.charAt(4), state.charAt(5)).replace('@', state.charAt(4)));
                successors.add(state.replace(state.charAt(5), '@').replace(state.charAt(8), state.charAt(5)).replace('@', state.charAt(8)));
                break;
            }
            case 6: {  	//if the index is 6, 0 can move up, right
                successors.add(state.replace(state.charAt(6), '@').replace(state.charAt(3), state.charAt(6)).replace('@', state.charAt(3)));
                successors.add(state.replace(state.charAt(6), '@').replace(state.charAt(7), state.charAt(6)).replace('@', state.charAt(7)));
                break;

            }
            case 7: {	//if the index is 7, 0 can move right, up, left
                successors.add(state.replace(state.charAt(7), '@').replace(state.charAt(4), state.charAt(7)).replace('@', state.charAt(4)));
                successors.add(state.replace(state.charAt(7), '@').replace(state.charAt(6), state.charAt(7)).replace('@', state.charAt(6)));
                successors.add(state.replace(state.charAt(7), '@').replace(state.charAt(8), state.charAt(7)).replace('@', state.charAt(8)));
                break;
            }
            case 8: {	//if the index is 8, 0 can move up, left
                successors.add(state.replace(state.charAt(8), '@').replace(state.charAt(5), state.charAt(8)).replace('@', state.charAt(5)));
                successors.add(state.replace(state.charAt(8), '@').replace(state.charAt(7), state.charAt(8)).replace('@', state.charAt(7)));
                break;
            }
        }
        return successors;
    }

    /**
	 * Print the path by tracing the parent
	 * @param goalNode, root, time
	 * @return possible successor
	 */
    public static void output(Node goalNode, Node root) {
    	System.out.println("Reached Goal");
        int totalCost = 0;

        Stack<Node> solutionStack = new Stack<Node>();
        solutionStack.push(goalNode);
        while (goalNode!=null && !goalNode.getInput().equals(root.getInput())) {
            solutionStack.push(goalNode.getParent());
            goalNode = goalNode.getParent();
        }
        String sourceState = root.getInput();
        String destinationState;
        for (int i = solutionStack.size() - 1; i >= 0; i--) {
            destinationState = solutionStack.get(i).getInput();
            if (!sourceState.equals(destinationState)) {
                totalCost += solutionStack.get(i).getTotalCost();
            }

            sourceState = destinationState;
            System.out.println("cost : "+solutionStack.get(i).getTotalCost());
            System.out.println("-----------------");
            System.out.println(solutionStack.get(i).getInput().substring(0, 3));
            System.out.println(solutionStack.get(i).getInput().substring(3, 6));
            System.out.println(solutionStack.get(i).getInput().substring(6, 9));
            

        }
        System.out.println("-------------------------------------------------");
        System.out.println("Number of moves: " + (solutionStack.size() - 1));
        System.out.println("Total cost: " + totalCost);

    }
    
   
}