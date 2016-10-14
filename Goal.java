import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.util.Comparator;
import java.util.Collections;

public class Goal {
    
    private static ArrayList<State> goalStates = new ArrayList<>();
    
    Goal(SearchNode orig)
    {
	ArrayList<Piece> tmp = (ArrayList<Piece>) orig.getCurrent().getState();
        //goalState = (ArrayList<Piece>) orig.getCurrent().getState();
        Collections.sort(tmp, new Comparator<Piece>(){
		public int compare(Piece o1, Piece o2) {
			return o1.getSmallDisk() - o2.getSmallDisk();
		}
		});
        tmp.remove(0);
	goalStates.add(new State(tmp));
	for (int i = 1; i <= Math.sqrt(tmp.size()); i++) {
		ArrayList<Piece> result = cloneList(tmp);
		Collections.rotate(result, i*-1);
		goalStates.add(new State(result));
	}			
    }
    
    @Override
    public String toString()
    {
        return goalStates.toString();
    }
    
    public boolean checkState(SearchNode orig)
    {
	for (State tmp : goalStates) {
		if (tmp.equals(orig.getCurrent().stateWithNoZero())) {
			return true;
		}
	}
	return false;
//	return goalStates.contains(orig.getCurrent().stateWithNoZero());
        //return orig.getCurrent().stateWithNoZero().contains(goalState);
    }

	private static ArrayList<Piece> cloneList(ArrayList<Piece> orig)
	{
		ArrayList<Piece> result = new ArrayList<>();
		for (Piece p : orig) {
			result.add(new Piece(p.getSmallDisk()));
		}
		return result;
	}
/// (111222333) (112223331) (122233311)
}
