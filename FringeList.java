import java.util.ArrayList;

public class FringeList {
    
    private ArrayList<SearchNode> Fringe;
    
    public FringeList() {
        Fringe = new ArrayList<>();
    }
    
/* Adds a searchNode to the Fringe list
    Input: a node
    Outputs: None
    */
    public void addToFringe(SearchNode nodeToAdd) 
    {
        Fringe.add(nodeToAdd);
    }
    
    //outputs a reference to the ArrayList within Fringe.
    public ArrayList<SearchNode> getEverything () {
        return(Fringe);
    }
    
    //gets the Node from the FringeList
    public SearchNode getNode(int index) {
        return(Fringe.get(index));    
    }
    
    public SearchNode removeNode(SearchNode nodeToRemove) {
        int index;
        index = Fringe.indexOf(nodeToRemove);
        return(Fringe.remove(index));
    }
    
    public boolean checkNode(SearchNode nodeToCheck)
    {
        return(Fringe.contains(nodeToCheck));
    }
    
 /*Checks to see if the Fringe list is empty
    Input: None
    Output Returns False if Fringe is empty
           Returns True is Fringe is not empty
    */
    public boolean isNotEmpty()
    {
        int fringeSize = 0;
        fringeSize = Fringe.size();
        if (fringeSize == 0)
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
        for (SearchNode fringeItem : Fringe  ) {
            stringOutput += fringeItem.getCurrent() + "\n";
        }
        return stringOutput;
    }
    
}