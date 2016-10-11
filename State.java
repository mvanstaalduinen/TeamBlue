

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State {
    
    private ArrayList<Piece> state = new ArrayList<>();
    private int totalFriends;
    
    State()
    {
    }
    
    State(State source)
    {
        state = (ArrayList<Piece>) source.getState();
        //setNeighbours();
        totalFriends = setFriends();
        
    }
    
    State(ArrayList<Piece> source)
    {
        state = source;
        //setNeighbours();
        totalFriends = setFriends();
    }
    
    public void setNeighbours() 
    {
        for (Piece p : state) {
            int j = state.indexOf(p);
            if (j == 0) {
                p.setLeftNeighbour(state.get((state.size() - 1)));
                p.setRightNeighbour(state.get(j+1));
            }
            else if (j < (state.size() - 1)) {          
                p.setLeftNeighbour(state.get(j-1));
                p.setRightNeighbour(state.get(j+1));
            }
            else {
                p.setLeftNeighbour(state.get(j-1));
                p.setRightNeighbour(state.get(0));
            }
        }
    }
    
    public final int setFriends()
    {
        int friends = 0;
        for (int i = 0; i < state.size(); i++) {
             
            if ((i < (state.size() -1)) && (state.get(i).isEqual(state.get(i+1)))) {
                friends = friends + 1;
            }
            if ((i > 0) && (state.get(i).isEqual(state.get(i-1)))) {
                friends = friends + 1;
            }
            if ((i == 0) && (state.get(i).isEqual(state.get(state.size()-1)))) {
                friends = friends + 1;
            }
            if ((i == (state.size() -1)) && (state.get(i).isEqual(state.get(0)))) {
                friends = friends + 1;
            } 
        }
        totalFriends = friends;
        return friends;
    }
    
    public int getFriends() {
        return totalFriends;
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
    
    public boolean isLegal(State second, Board board)
    {
        int indexOfZero = -1;
        int futureZero = -1;
        int largeToken = -1;
        for (Piece p : state) {
            if(p.isZero()) {
                indexOfZero = state.indexOf(p);
                largeToken = board.getPosition(indexOfZero);
            }
        }
        for (Piece p : second.getState()) {
            if(p.isZero()) {
                futureZero = second.getState().indexOf(p);
            }
        }
        if ((largeToken != -1) && (futureZero != -1)) {
            int dist = abs(indexOfZero-futureZero);
            if (dist == 1) {
                // all tokens can make a move of 1
                return true;
            }
            if (largeToken == dist) {
                return true;
            }   
        }
        
        return false;
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
            if (p.isZero()) { //added method to Piece class
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