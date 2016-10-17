import java.util.ArrayList;

public class NodeList {
    
    private ArrayList<SearchNode> Node;
    
    public NodeList() {
        Node = new ArrayList<>();
    }
    
/* Adds a searchNode to the Node list
    Input: a node
    Outputs: None
    */
    public void addToNode(SearchNode nodeToAdd) 
    {
        Node.add(nodeToAdd);
    }
    
    //outputs a reference to the ArrayList within Node.
    public ArrayList<SearchNode> getEverything () {
        return(Node);
    }
    
    //gets the Node from the NodeList
    public SearchNode getNode(int index) {
        return(Node.get(index));    
    }
    
    public SearchNode removeNode(SearchNode nodeToRemove) {
        int index;
        index = Node.indexOf(nodeToRemove);
        if (index!=-1) {
            return(Node.remove(index));
        }
        return(null);
    }
    
    public boolean checkNode(SearchNode nodeToCheck)
    {
        return(Node.contains(nodeToCheck));
    }
    
 /*Checks to see if the Node list is empty
    Input: None
    Output Returns False if Node is empty
           Returns True is Node is not empty
    */
    public boolean isNotEmpty()
    {
        int NodeSize = 0;
        NodeSize = Node.size();
        if (NodeSize == 0)
        {
            return(false);
        }
        return(true);
    }
    
    @Override
    public String toString()
    {
        //return state.toString();
        
        String stringOutput = "";
        for (SearchNode NodeItem : Node  ) {
            stringOutput += NodeItem.getCurrent() + " f=" + NodeItem.getFevaluation() + "\n";
        }
        return stringOutput;
    }
    
}