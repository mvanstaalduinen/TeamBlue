package TeamBlue;

import java.util.ArrayList;

public class ClosedList { 
    private ArrayList<State> closed = new ArrayList<>();
    
/* Adds a state to the closed list
    Input: a state
    Outputs: None
    */
    public void addToClosed(State stateToAdd) 
    {
        closed.add(stateToAdd);
    }
    
 /*Checks to see if a state is in the Closed list
    Input a state to be checked
    Output Returns True if list contains the element
    */
    public boolean checkClosed(State stateToCheck)
    {
        return(closed.contains(stateToCheck));
    }
}

