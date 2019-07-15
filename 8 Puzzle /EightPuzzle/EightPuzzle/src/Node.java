import java.util.ArrayList;

public class Node {

    private String input;
    private ArrayList<Node> children;
    private Node parent;
    private int hCost=0;
    private int gCost=0;
    private int totalCost=0;

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalCost(int cost, int estimatedCost) {
        this.totalCost = cost + estimatedCost;
    }

    public int getHCost() {
        return hCost;
    }

    public void setHCost(int hcost) {
        this.hCost = hcost;
    }

    public void setInput(String state) {
        this.input = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node(String state) {
        this.input = state;
        children = new ArrayList<Node>();
    }

    public String getInput() {
        return input;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }

	public int getGCost() {
		return gCost;
	}

	public void setGCost(int gCost) {
		this.gCost = gCost;
	}
}
