package abpuzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State {
    
    private ArrayList<Piece> state = new ArrayList<>();
    
    State()
    {
    }
    
    State(State source)
    {
        state = (ArrayList<Piece>) source.getState();
    }
    
    State(ArrayList<Piece> source)
    {
        state = source;
    }
    
    public List<Piece> getState()
    {
        ArrayList<Piece> result = new ArrayList<>();
        for (int i = 0; i < state.size(); i++){
            result.add(state.get(i));
        }
        return result;
    }
    
    @Override
    public String toString()
    {
        return state.toString();
        
        /*String result = "";
        
        for (Piece item : state) {
            result += item.getSmallDisk();
        }
        return result;*/
    }
    
    public void addToState(Piece p)
    {
        state.add(p);
    }
    
    public State changeState(int firstIndex, int secondIndex, int distance)
    {   
        if (secondIndex >= state.size() || secondIndex < 0) {
            secondIndex = (secondIndex % state.size());
        }
        System.out.println("Second Index: " + secondIndex);
        State result = new State();
        int tempFirstTop = state.get(firstIndex).getSmallDisk();
        int tempSecTop = state.get(secondIndex).getSmallDisk();
        
        for (Piece p : state) {
            Piece temp = new Piece(p.getSmallDisk());
            result.addToState(temp);
        }
        
        result.getState().get(firstIndex).setSmallDisk(tempSecTop);
        result.getState().get(secondIndex).setSmallDisk(tempFirstTop);
                
        return result;
    }
    
    public List<Piece> stateWithNoZero()
    {
        ArrayList<Piece> result = new ArrayList<>();
        
        for (Piece p : state) {
            if (p.getSmallDisk() != 0) {
                result.add(p);
            }
        }
        return result;
    }
    
    public ArrayList<State> produceChildren(Board board)
    {
        int indexOfZero = -1;
        int distance;
        ArrayList<State> result = new ArrayList<>();
        
        for (Piece p : state) {
            if (p.getSmallDisk() == 0) {
                indexOfZero = state.indexOf(p);
            }
        }
        
        distance = board.getPosition(indexOfZero);
        System.out.println("indexOfZero: " + indexOfZero + " distance: " + distance);
        
        result.add(changeState(indexOfZero, indexOfZero + 1, 1));
        result.add(changeState(indexOfZero, indexOfZero - 1, 1));
        
        if (distance > 1) {
            System.out.println("Maybe? : " + (indexOfZero + distance) % state.size());
            result.add(changeState(indexOfZero, indexOfZero + distance, distance));
            result.add(changeState(indexOfZero, indexOfZero - distance, distance));
        }
        return result;
    }
    
    public void reverseState()
    {
        Collections.reverse(state);
    }
}