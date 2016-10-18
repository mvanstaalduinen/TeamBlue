import java.util.ArrayList;

public class NodeList {
    
    private ArrayList<SearchNode> Node;
    int size;
    
    public NodeList() {
        Node = new ArrayList<>();
        size = 0;
    }
    
/* Adds a searchNode to the Node list
    Input: a node
    Outputs: None
    */
    public void addToNode(SearchNode nodeToAdd) 
    {
        Node.add(nodeToAdd);
        //size+=1;
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
        //size-=1;
        return(null);
    }
    
    public int getSize() {
        return(Node.size());
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
            stringOutput += NodeItem.getCurrent() + "\n";
        }
        return stringOutput;
    }
    
}