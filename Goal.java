import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.util.Comparator;

public class Goal {
    
    private static ArrayList<Piece> goalState = new ArrayList<>();
    
    Goal(State orig)
    {
        goalState = (ArrayList<Piece>) orig.getState();
        Collections.sort(goalState, new Comparator<Piece>(){
		public int compare(Piece o1, Piece o2) {
			return o1.getSmallDisk() - o2.getSmallDisk();
		}
		});
        goalState.remove(0);
    }
    
    @Override
    public String toString()
    {
        return goalState.toString();
    }
    
    public boolean checkState(State state)
    {
        return state.stateWithNoZero().equals(goalState);
    }
}
