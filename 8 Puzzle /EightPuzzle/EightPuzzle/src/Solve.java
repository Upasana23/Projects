import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solve {
	private Node root;
	private String goalSate;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public String getGoalSate() {
		return goalSate;
	}

	public void setGoalSate(String goalSate) {
		this.goalSate = goalSate;
	}

	public Solve(Node root, String goalSate) {
		this.root = root;
		this.goalSate = goalSate;
	}

	/**
	 * solves puzzle
	 * @param method
	 */
	public void aStar(int method) {
		Node node = new Node(root.getInput());
		node.setTotalCost(0);
		CompareCost cCost = new CompareCost();
		PriorityQueue<Node> openList = new PriorityQueue<Node>(cCost);
		List<Node> closedList = new ArrayList<Node>();
		Node currentNode = node;
		openList.add(currentNode);
		while (currentNode!=null && !currentNode.getInput().equals(goalSate)) {
			List<String> nodeSuccessors = Movement.getSuccessors(currentNode.getInput());
			for (String n : nodeSuccessors) {

				Node child = new Node(n);
				currentNode.addChild(child);
				child.setParent(currentNode);

				if ( method == 1) {
					child.setHCost(heuristicManhattan(child.getInput(), goalSate));
					child.setGCost(1+currentNode.getGCost());
					child.setTotalCost(child.getGCost()+child.getHCost());
				}else if(method == 2) {
					child.setHCost(heuristicMisplacedTiles(child.getInput(), goalSate));
					child.setTotalCost(currentNode.getHCost()+child.getHCost());

				}

				boolean var=false;
				openList.remove(currentNode);
				PriorityQueue<Node> duplicate = new PriorityQueue<Node>(cCost);
				
				duplicate.addAll(openList);
				while(!duplicate.isEmpty()) {
					Node a =duplicate.poll();
					if(a.getInput().equals(child.getInput())) {
						var = true;
						if(a.getTotalCost()>child.getTotalCost()) {
							openList.remove(a);
						}else {
							var = false;
						}
					}
					var=true;
				}
				if(openList.isEmpty() || var) {
					openList.add(child);
				}

			}
			boolean check= false;
			if(closedList.size()==0){
				check=true;
			}else{
				for(int i=0;i<closedList.size();i++) {
					check=false;
					if(closedList.get(i).getInput().equals(currentNode.getInput())){
						if(closedList.get(i).getTotalCost()>currentNode.getTotalCost()){
							closedList.remove(i);
							check=true;
							break;
						}else {
							check=false;
							break;
						}
					} check=true;
				}
			}
			if(check){
				closedList.add(currentNode);
			}
			/*PriorityQueue<Node> print = new PriorityQueue<Node>(cCost);
			System.out.println("-----------------");
			print.addAll(openList);
			while(!print.isEmpty()) {
				Node p = print.poll();
				System.out.println("PQ: "+ p.getState()+" "+p.getTotalCost());
			}*/
			currentNode = openList.poll();
		}
		if(currentNode==null) {
			System.out.println("Could not Reach Result");
		}else {
			Movement.output(currentNode, root);
			System.out.println("Close List: "+ closedList.size());
			System.out.println("Open List: "+ openList.size());
			System.out.println("Total Nodes Generated: "+ (closedList.size()+openList.size()));
		}
}
/**
 * Caculates heuristic Manhattan
 * @param currentState
 * @param goalSate
 * @return
 */
	private int heuristicManhattan(String currentState, String goalSate) {
		int distance = 0;
		for (int i = 0; i < currentState.length(); i++) {
			if (currentState.charAt(i)!='0' && currentState.charAt(i) != goalSate.charAt(i)) {
				for (int j = 0; j < goalSate.length(); j += 1) {
					if(goalSate.charAt(j)==currentState.charAt(i)) {
						int move = 0;
						if(Math.abs(j/3) == Math.abs(j/3)) {
							move = Math.abs((j%3) - (i%3));
						}else {
							int moveUD = Math.abs((i/3)- (j/3));
							int moveS = Math.abs((i%3)- (j%3));
							move = moveUD+moveS;
						}    					
						distance = distance + move;
					}
				}
			}
		}
		return distance;
	}
	
	/**
	 * Calculate MisplacedTiles
	 * @param currentState
	 * @param goalSate
	 * @return
	 */
	private int heuristicMisplacedTiles(String currentState, String goalSate) {
		int count = 0;
		for (int i = 0; i < currentState.length(); i += 1) {
			if (currentState.charAt(i)!='0' && currentState.charAt(i) != goalSate.charAt(i)) {
				count = count+1;
			}
		}
		return count;
	}
}
