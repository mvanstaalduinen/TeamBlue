

import java.util.ArrayList;

public class ClosedList { 
    private ArrayList<SearchNode> closed = new ArrayList<>();
    
/* Adds a node to the closed list
    Input: a SearchNode
    Outputs: None
    */
    public void addToClosed(SearchNode nodeToAdd) 
    {
        closed.add(nodeToAdd);
    }
    
 /*Checks to see if a node is in the Closed list
    Input a state to be checked
    Output Returns True if list contains the element
    */
    public boolean checkClosed(SearchNode nodeToCheck)
    {
        return(closed.contains(nodeToCheck));
    }
}

