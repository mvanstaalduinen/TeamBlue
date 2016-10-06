package abpuzzle;

import java.util.ArrayList;
import java.util.List;

public class State {
    
    private ArrayList<Piece> state = new ArrayList<>();
    
    State()
    {
    }
    
    @Override
    public String toString()
    {
        String result = "";
        
        for (Piece item : state) {
            result += item.getSmallDisk();
        }
        return result;
    }
    
    public void addToState(Piece p)
    {
        state.add(p);
    }
    
    public State changeState(int firstIndex, int secondIndex)
    {
        State result = new State();
        int tempFirstTop = state.get(firstIndex).getSmallDisk();
        int tempSecTop = state.get(secondIndex).getSmallDisk();
        
        state.get(firstIndex).setSmallDisk(tempSecTop);
        state.get(secondIndex).setSmallDisk(tempFirstTop);
        
        for (Piece item : state){
            result.addToState(item);
        }
        
        return result;
    }
}
