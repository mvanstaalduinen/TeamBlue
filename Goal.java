

import java.util.ArrayList;
import java.util.Collections;

public class Goal {
    
    private static ArrayList<Piece> goalState = new ArrayList<>();
    
    Goal(State orig)
    {
        goalState = (ArrayList<Piece>) orig.getState();
        Collections.sort(goalState, (Piece o1, Piece o2) -> o1.getSmallDisk() - (o2.getSmallDisk()));      
        goalState.remove(0);
    }
    
    @Override
    public String toString()
    {
        return "I'll get to it if we need it.";
    }
    
    public boolean checkState(State state)
    {
        return state.stateWithNoZero().equals(goalState);
    }
}
