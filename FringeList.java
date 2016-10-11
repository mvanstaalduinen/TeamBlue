

import java.util.ArrayList;

public class FringeList {
    
    private ArrayList<SearchNode> Fringe = new ArrayList<>();
    
/* Adds a searchNode to the Fringe list
    Input: a node
    Outputs: None
    */
    public void addToFringe(State nodeToAdd) 
    {
        Fringe.add(nodeToAdd);
    }
    
 /*Checks to see if the Fringe list is empty
    Input: None
    Output Returns False if Fringe is empty
           Returns True is Fringe is not empty
    */
    public boolean isNotEmpty()
    {
        int fringeSize=0;
        fringeSize=Fringe.size();
        if (fringeSize==0)
        {
            return(false);
        }
        return(true);
    }
}