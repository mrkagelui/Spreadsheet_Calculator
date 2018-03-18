import java.util.ArrayList;
import java.util.List;

class Node {
    private String name;
    private List<Node> nextNodes;
    private boolean isVisited;
    private boolean isCyclic;
    private Cell cell;

    public void setCell(Cell c) {
        cell = c;
    }

    public boolean hasCell(){
        return cell != null;
    }

    public boolean isEvaluated() {
        return isEvaluated;
    }

    public void setEvaluated() {
        isEvaluated = true;
    }

    private boolean isEvaluated;

    public Node(String newName) {
        name = newName;
        isVisited = false;
        isCyclic = false;
        nextNodes = new ArrayList<>();
    }

    public void setVisited() {
        isVisited = true;
    }

    public void clearVisited() {
        isVisited = false;
    }

    public boolean isVisited(){
        return isVisited;
    }

    public boolean isCyclic() {
        return isCyclic;
    }

    public void setCyclic() {
        isCyclic = true;
    }

    public void clearCyclic() {
        isCyclic = false;
    }

    public String getName(){
        return name;
    }

    public boolean isPointingToSomething(){
        return nextNodes != null && nextNodes.size() > 0;
    }

    public List<Node> getNextNodes(){
        return nextNodes;
    }

    public void addNextNode(Node node) {
        if (null == nextNodes) nextNodes = new ArrayList<>();
        nextNodes.add(node);
    }

    public boolean evaluate(double[][] matrix){
        return cell.evaluate(matrix);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Node)) return false;

        Node n = (Node)obj;
        return name.equalsIgnoreCase(n.getName());
    }
}
