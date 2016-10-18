

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State {
    
    private ArrayList<Piece> state = new ArrayList<>();
    private double totalFriends;
    private double finalFriends;
    
    State()
    {
    }
    
    State(State source)
    {
        state = (ArrayList<Piece>) source.getState();
        setFriends();
        
    }
    
    State(ArrayList<Piece> source)
    {
        state = source;
        setFriends();
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
    
    public final void setFriends()
    {
        int friends = 0;
        int n = 0;
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i).getSmallDisk() > n) {
                n = state.get(i).getSmallDisk();
            }
            if (i < (state.size() -1)) {
                    if (state.get(i).isEqual(state.get(i+1))) {
                friends = friends + 1;
                    }
            }
             if ((i == (state.size() -1)) && (state.get(i).isEqual(state.get(0)))) {
                friends = friends + 1;
            } 
        }
        finalFriends = ((n-1) * n); //(n * (((n-2) * 2) + 2));
        totalFriends = friends;
    }
    
    public double getFinalTotal() {
        return finalFriends;
    }
    
    
    public double getFriends() {
        return totalFriends;
    }
    
    public ArrayList<Piece> getState()
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
        String result = "";
        
        for (Piece item : state) {
            result += item.getSmallDisk() + " ";
        }
        return result;
    }
    
    public void addToState(Piece p)
    {
        state.add(p);
    }
    
    public State changeState(int firstIndex, int childIndex, int distance)
    {   
        if (childIndex < 0) {
            childIndex = abs(childIndex);
        }
        State result = new State();
        int tempFirstTop = state.get(firstIndex).getSmallDisk();
        int tempSecTop = state.get(childIndex).getSmallDisk();
        
        for (Piece p : state) {
            Piece temp = new Piece(p.getSmallDisk());
            result.addToState(temp);
        }
        
        result.getState().get(firstIndex).setSmallDisk(tempSecTop);
        result.getState().get(childIndex).setSmallDisk(tempFirstTop);
        
        result.setFriends(); // int value placeholder can remove later
        result.setNeighbours();
        
        return result;
    }
    
    public State stateWithNoZero()
    {
        ArrayList<Piece> result = new ArrayList<>();
        
        for (Piece p : state) {
            if (p.getSmallDisk() != 0) {
                result.add(p);
            }
        }
        return new State(result);
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
        
        if (indexOfZero + 1 >= state.size()) {
            result.add(changeState(indexOfZero, 0, 1));
        } else {
            result.add(changeState(indexOfZero, indexOfZero + 1, 1));
        }
        if (indexOfZero - 1 < 0) {
            result.add(changeState(indexOfZero, (state.size() - 1), 1));
        } else {
            result.add(changeState(indexOfZero, indexOfZero - 1, 1));
        }
        
        if (distance > 1) {
            // moving to the right from 0
            if ((distance + indexOfZero) >= state.size()) {
                result.add(changeState(indexOfZero, abs((indexOfZero + distance) - state.size()), distance));
            } else {
                result.add(changeState(indexOfZero, (indexOfZero + distance), distance));
            }
            // moving to the left from 0
            if ((indexOfZero - distance) < 0) {
                result.add(changeState(indexOfZero, ((distance - indexOfZero) - state.size()), distance));
            } else {
                result.add(changeState(indexOfZero, abs(indexOfZero - distance), distance));
            }
        }
        return result;
    }

	@Override
	public boolean equals(Object o)
	{
		if (o == null) {
			return false;
		}

		final State other = (State) o;
		System.out.println("first: " + state + " other: " + other);
		for (int i = 0; i < state.size(); i++) {
			if (state.get(i).getSmallDisk() != other.getState().get(i).getSmallDisk()) {
				return false;
			}
		}
		return true;
	}
    
    public void reverseState()
    {
        Collections.reverse(state);
    }
}
