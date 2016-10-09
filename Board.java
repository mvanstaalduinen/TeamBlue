package abpuzzle;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    private final ArrayList<Integer> board = new ArrayList<>();
    
    
    public void addToBoard(int value) 
    {
        board.add(value);
    }
    
    @Override
    public String toString()
    {
        String result = "";
        for (int item : board) {
            result += item;
        }
        return result;
    }
    
    public int getPosition(int pos)
    {
        return board.get(pos);
    }
    
    public List<Integer> getBoard()
    {
        return board;
    }
}
